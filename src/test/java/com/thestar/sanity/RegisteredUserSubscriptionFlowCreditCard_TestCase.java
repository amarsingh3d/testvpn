package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class RegisteredUserSubscriptionFlowCreditCard_TestCase {

	private String newemailtouse = "";

	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
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
	@Parameters({"browser", "url", "name"})
	public void Registration_Flow_Completion(){
		BaseTestObj.loadURL("Mailinator page", BaseTestObj.mailinator);
		BaseTestObj.VerifyEmail(newemailtouse);
		BaseTestObj.closeTab();
		BaseTestObj.switchToWindow();
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"Registration_Flow_Completion"}, priority = 2)
	public void Registration_Flow_User_Created() {
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"Registration_Flow_User_Created"}, priority = 4)
	public void User_Signed_in() {
		BaseTestObj.loadURL("Sign in Page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newemailtouse);
		BaseTestObj.SignIn(newemailtouse, BaseTestObj.passwordbasic);
		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
		System.out.println("Ending Test Case: User_Signed_in");

	}
	
	@Test (dependsOnMethods = {"User_Signed_in"}, priority = 5)
	public void ExpressCheckout() {
		BaseTestObj.loadURL("Express checkout page", BaseTestObj.baseUrl + BaseTestObj.expresscheckoutpage);
   		System.out.println("Starting Test Case: Express_Checkout");
		BaseTestObj.expressCheckoutPageExistingUser();
   		assertObjectsOnPagesObj.assertPaymentPageLoaded(BaseTestObj);
   		System.out.println("Ending Test Case: Express_Checkout");
	       
	}
	
	
	@Test (dependsOnMethods = {"ExpressCheckout"}, priority = 6)
	
	public void PaymentCompletion() {
   		System.out.println("Starting Test Case: Payment_Completion");
   		BaseTestObj.paymentPage();
   		assertObjectsOnPagesObj.AssertCompleteProfilePage(BaseTestObj);
   		System.out.println("Ending Test Case: Payment_Completion");

   		       
	}
	
	
	@Test (dependsOnMethods = {"PaymentCompletion"}, priority = 7)
	
	public void ProfilePageCompletion() {
   		System.out.println("Starting Test Case: Profile_Page_Completion");
		BaseTestObj.profilePageRegisterUser(BaseTestObj.passwordbasic);
   		System.out.println("Ending Test Case: Profile_Page_Completion");
   		       
	}
	
	@Test (dependsOnMethods = {"ProfilePageCompletion"}, priority = 8)
	
	public void AutoLogin() {
		BaseTestObj.waitInSeconds(5);
   		System.out.println("Starting Test Case: AutoLogin");
   		assertObjectsOnPagesObj.AssertAutoLogin(BaseTestObj);
   		System.out.println("Ending Test Case: AutoLogin");
	}

	@Test (dependsOnMethods = {"AutoLogin"}, priority = 9)

	public void subscriptionIsAdded(){
		BaseTestObj.loadPage("Sign in Page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newemailtouse);
		BaseTestObj.SignIn(newemailtouse, BaseTestObj.passwordbasic);
		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
		System.out.println("Ending Test Case: User_Signed_in");
		System.out.println("Starting Test Case: subscriptionIsAdded");
		BaseTestObj.loadPage("Order page",BaseTestObj.baseUrl + BaseTestObj.subscriptionsOrdersPage);
		assertObjectsOnPagesObj.assertSubscriptionIsAdded(BaseTestObj);
		System.out.println("Ending Test Case: subscriptionIsAdded");
	}
	
	   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing New Subscription with Credit Card");
		BaseTestObj.QuitBrowser();
		
	}
	  

}
