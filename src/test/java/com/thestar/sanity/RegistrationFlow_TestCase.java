package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class RegistrationFlow_TestCase {
	
	private String newemailtouse = "";
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Registration Flow");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.signinpage, name);
		BaseTestObj.loadRegistrationPage();

	}
	
	@Test (priority = 0)
	
	public void Create_Email_Mailinator() throws IOException {
   		newemailtouse = BaseTestObj.createNewMailinatorEmail();
   		WriteExternalDataObj.WriteObjectRepositoryXML(newemailtouse);
	}
	
	@Test (dependsOnMethods = {"Create_Email_Mailinator"}, priority = 1)
	
	public void NewUser_Registration() {
   		BaseTestObj.FillRegistrationPage(newemailtouse);
   		assertObjectsOnPagesObj.assertEmailVerificationLinkSent(BaseTestObj);
   		       
	}
			
   	@Test (dependsOnMethods = {"NewUser_Registration"}, priority = 2)
	public void Registration_Flow_Completion() {
   		System.out.println(BaseTestObj.mailinator);
   		BaseTestObj.loadURL("Mailinator page", BaseTestObj.mailinator);
   		BaseTestObj.VerifyEmail(newemailtouse);
		BaseTestObj.switchToWindow();
   		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);
	       
	}

	@Test (dependsOnMethods = {"NewUser_Registration"}, priority = 4)
	public void User_Signed_in() {
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		BaseTestObj.loadPage("Sign in Page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newemailtouse);
		BaseTestObj.SignIn(newemailtouse, BaseTestObj.passwordbasic);
		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
		System.out.println("Ending Test Case: User_Signed_in");

	}

	@Test (dependsOnMethods = {"User_Signed_in"}, priority = 4)
	public void SignedOut() {
		BaseTestObj.openMenu();
		assertObjectsOnPagesObj.assertMenuItems(BaseTestObj);
		BaseTestObj.signOut();
		assertObjectsOnPagesObj.assertSignedOut(BaseTestObj);
	}
   	
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Registration Flow");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
