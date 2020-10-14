package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class RegisteredUserSubscriptionFlowPayPal_TestCase {

	private String newEmail = "";

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
		newEmail = BaseTestObj.createNewMailinatorEmail();
		WriteExternalDataObj.WriteObjectRepositoryXML(newEmail);
	}

	@Test (dependsOnMethods = {"Create_Email_Mailinator"}, priority = 1)
	public void NewUser_Registration() {
		BaseTestObj.FillRegistrationPage(newEmail);
		assertObjectsOnPagesObj.assertEmailVerificationLinkSent(BaseTestObj);
	}

	@Test (dependsOnMethods = {"NewUser_Registration"}, priority = 2)
	public void Registration_Flow_Completion(){
		BaseTestObj.loadURL("Mailinator page",BaseTestObj.mailinator);
		BaseTestObj.VerifyEmail(newEmail);
		BaseTestObj.closeTab();
		BaseTestObj.switchToWindow();
		//BaseTestObj.loadPage("Activation link",BaseTestObj.baseUrl +"/sign-in?"+BaseTestObj.getActivationLink());
   		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);

	}

	@Test (dependsOnMethods = {"NewUser_Registration"}, priority = 2)
	public void Registration_Flow_User_Created(){
		assertObjectsOnPagesObj.AssertRegistrationSuccess(BaseTestObj);
	}

	@Test (dependsOnMethods = {"Registration_Flow_User_Created"}, priority = 4)
	public void  User_Signed_in() {
		BaseTestObj.loadURL("Sign in Page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		System.out.println("Starting Test Case: User_Signed_in");
		System.out.println("Email: " + newEmail);
		BaseTestObj.SignIn(newEmail, BaseTestObj.passwordbasic);
		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
		System.out.println("Ending Test Case: User_Signed_in");

	}

	@Parameters({ "url"})
	@Test (dependsOnMethods = {"User_Signed_in"}, priority = 5)
	public void Express_Checkout() {
		BaseTestObj.loadPage("Express checkout page ", BaseTestObj.baseUrl + BaseTestObj.expresscheckoutpage);
		System.out.println("Starting Test Cases: Express_Checkout");
		BaseTestObj.expressCheckoutPageExistingUser();
   		assertObjectsOnPagesObj.assertPaymentPageLoaded(BaseTestObj);
		System.out.println("Ending Test Cases: Express_Checkout");

	}
	
	@Test (dependsOnMethods = {"Express_Checkout"}, priority = 6)
	
	public void PayPal_Payment_Method() {
		
		System.out.println("Starting Test Cases: PayPal_Payment_Method");
   		assertObjectsOnPagesObj.Assert_PayPal_SignIn_Page(BaseTestObj.payPal());
		System.out.println("Ending Test Cases: PayPal_Payment_Method");

	}
	
	@Test (dependsOnMethods = {"PayPal_Payment_Method"}, priority = 7)
	
	public void SignIn_To_PayPal(){
		
		System.out.println("Starting Test Cases: SignIn_To_PayPal");
   		Boolean SignedIn = (BaseTestObj.SignIn_To_PayPal(BaseTestObj.PayPalEmail, BaseTestObj.PayPalPassword));
   		assertObjectsOnPagesObj.Assert_SignedIn_InTo_PayPal(SignedIn);
		System.out.println("Ending Test Cases: SignIn_To_PayPal");
	}

	@Test (dependsOnMethods = {"SignIn_To_PayPal"}, priority = 8)

	public void ProfilePageCompletion() {

		System.out.println("Starting Test Case: Profile_Page_Completion");
		BaseTestObj.profilePageRegisterUser(BaseTestObj.passwordbasic);
		System.out.println("Ending Test Case: Profile_Page_Completion");

	}

	@Test (dependsOnMethods = {"ProfilePageCompletion"}, priority = 9)

	public void AutoLogin(){

		System.out.println("Starting Test Case: AutoLogin");
		assertObjectsOnPagesObj.AssertAutoLogin(BaseTestObj);
		System.out.println("Ending Test Case: AutoLogin");
	}

	@Test (dependsOnMethods = {"AutoLogin"}, priority = 10)

	public void subscriptionIsAdded(){
		System.out.println("Starting Test Case: subscriptionIsAdded");
		BaseTestObj.loadURL("Order page",BaseTestObj.baseUrl + BaseTestObj.subscriptionsOrdersPage);
		assertObjectsOnPagesObj.assertSubscriptionIsAdded(BaseTestObj);
		System.out.println("Ending Test Case: subscriptionIsAdded");
	}
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Subscription Pay Pal Flow");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
