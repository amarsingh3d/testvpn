package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class DAPSFlow_TestCase {

	private String newemailtouse = "";

	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Registration Flow");
		BaseTestObj.ReadObjectRepositoryXML();
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
		BaseTestObj.waitInSeconds(5);
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

	@Test (dependsOnMethods = {"Registration_Flow_Completion"}, priority = 2)
	public void Registration_Flow_User_Created(){
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"Registration_Flow_User_Created"}, priority = 4)
	public void User_Signed_in() {
		BaseTestObj.loadPage("Sign in Page", BaseTestObj.baseUrl +BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newemailtouse);
		BaseTestObj.SignIn(newemailtouse, BaseTestObj.passwordbasic);
		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
		System.out.println("Ending Test Case: User_Signed_in");

	}
	
	@Test (dependsOnMethods = {"User_Signed_in"}, priority = 5)
	public void DAPS_Flow_Subscription() {
		BaseTestObj.loadPage("DAPS subscribe page", BaseTestObj.baseUrl + BaseTestObj.dapsPage);
   		System.out.println("Starting Test Case: DAPS_Flow_Subscription");
		assertObjectsOnPagesObj.assertDAPSPageLoaded(BaseTestObj);
		BaseTestObj.DAPSAddressSet();
		BaseTestObj.acceptTermsContinue();
   		System.out.println("Ending Test Case: DAPS_Flow_Subscription");
	       
	}
	
	
	@Test (dependsOnMethods = {"DAPS_Flow_Subscription"}, priority = 6)
	
	public void DAPS_Success_Page() {
   		System.out.println("Starting Test Case: DAPS_Success_Page");
   		assertObjectsOnPagesObj.assertDAPSSuccessPage(BaseTestObj);
   		System.out.println("Ending Test Case: DAPS_Success_Page");
   		       
	}

	@Test (dependsOnMethods = {"DAPS_Success_Page"}, priority = 7)

	public void DAPS_Subscription_Is_Added(){
		System.out.println("Starting Test Case: subscriptionIsAdded");
		BaseTestObj.loadURL("Order page",BaseTestObj.baseUrl + BaseTestObj.subscriptionsOrdersPage);
		assertObjectsOnPagesObj.assertDAPSSubscriptionIsAdded(BaseTestObj);
		System.out.println("Ending Test Case: subscriptionIsAdded");
	}

	   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing New Subscription with Credit Card");
		BaseTestObj.QuitBrowser();
		
	}
	  

}
