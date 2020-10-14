package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class NewsLettersPage_TestCase {

	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	private String newemailtouse = "";
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		
		System.out.println("Started Testing Newsletter page");
		BaseTestObj.ReadObjectRepositoryXML();
		if (BaseTestObj.isRDR(url)) {
			BaseTestObj.ReadObjectRepositoryXML_RDR();
		}
		if(BaseTestObj.isRDRNiagara(url)){
			BaseTestObj.ReadObjectRepositoryXML_RDR_OTHER();
		}
		if(BaseTestObj.isRDRPE(url)){
			BaseTestObj.ReadObjectRepositoryXML_RDR_PE();
		}
		BaseTestObj.baseUrl = url;
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		
	}

	@Test (priority = 0)
	public void recommendForYouNewsletter() {
		BaseTestObj.loadURL("Emails page", BaseTestObj.baseUrl + BaseTestObj.recomendNewsletter);
		assertObjectsOnPagesObj.assertRecommendForYouNewsletter(BaseTestObj);
		BaseTestObj.loadURL("Emails page", BaseTestObj.baseUrl + BaseTestObj.email);
	}

	@Test (priority = 1)
	public void SubscribeAllNewsLetters() {
		assertObjectsOnPagesObj.AssertNewsLetters(BaseTestObj);
		BaseTestObj.SubscribeNewsLetterExistingUser();
		BaseTestObj.scrollPage(0,1600);
		assertObjectsOnPagesObj.AssertNewsLettersSignIn(BaseTestObj);
		BaseTestObj.loadURL("Temp success page", BaseTestObj.baseUrl + BaseTestObj.email +"/success");
		assertObjectsOnPagesObj.AssertNewsLettersSubscribed(BaseTestObj);

	}

	@Test (priority = 1)
	public void Create_Email_Mailinator() throws IOException {
		newemailtouse = BaseTestObj.createNewMailinatorEmail();
		WriteExternalDataObj.WriteObjectRepositoryXML(newemailtouse);
	}

	@Test (priority = 2, dependsOnMethods = {"Create_Email_Mailinator"})
	public void NewUser_Registration() {
		BaseTestObj.loadURL("Sign up page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.loadRegistrationPage();
		BaseTestObj.FillRegistrationPage(newemailtouse);
		assertObjectsOnPagesObj.assertEmailVerificationLinkSent(BaseTestObj);

	}

	@Test (priority = 3, dependsOnMethods = {"NewUser_Registration"})
	public void Registration_Flow_Completion() {
		System.out.println(BaseTestObj.mailinator);
		BaseTestObj.loadURL("Mailinator page",BaseTestObj.mailinator);
		BaseTestObj.VerifyEmail(newemailtouse);
		BaseTestObj.closeTab();
		BaseTestObj.waitInSeconds(5);
		BaseTestObj.switchToWindow();
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"Registration_Flow_Completion"}, priority = 4)
	public void Registration_Flow_User_Created() {
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"Registration_Flow_User_Created"}, priority = 5)
	@Parameters({"browser", "url", "name"})
	public void User_Signed_in() {
		BaseTestObj.loadURL("Sign in Page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newemailtouse);
		BaseTestObj.SignIn(newemailtouse, BaseTestObj.passwordbasic);
		System.out.println("Ending Test Case: User_Signed_in");

	}

	@Test (priority = 6,dependsOnMethods = "User_Signed_in", description = "Checking Newsletters SignUp")
	public void NewsLettersSignUp(){
		BaseTestObj.loadURL("Emails page", BaseTestObj.baseUrl + BaseTestObj.email);
		assertObjectsOnPagesObj.AssertNewsLettersSubscribedNotPreset(BaseTestObj);
		BaseTestObj.SubscribeNewsLetter();
		//assertObjectsOnPagesObj.assertNewsLettersSubscribed(BaseTestObj);
		BaseTestObj.UnsubscribeNewsLetter();
		//assertObjectsOnPagesObj.assertNewsLettersUnsubscribed(BaseTestObj);
		BaseTestObj.loadURL("Success page", BaseTestObj.baseUrl + BaseTestObj.email +"/success");
		assertObjectsOnPagesObj.AssertNewsLettersSubscribed(BaseTestObj);
	}


	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing REG-199");
		BaseTestObj.QuitBrowser();

	}

}
