package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class SubscriptionFlowPayPal_TestCase {
	
	private String newemailtouse = "";
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Subscription Pay Pal Flow");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.expresscheckoutpage, name);
	
	}
	
	@Test (priority = 0)
	
	public void Email_Generator() throws IOException {
		
   		System.out.println("Starting Test Cases: Email_Generator");
   		newemailtouse = BaseTestObj.createNewYopMailEmail();
   		WriteExternalDataObj.WriteObjectRepositoryXML(newemailtouse);
   		System.out.println("Ending Test Cases: Email_Generator");
	       
	}
	
	@Test (dependsOnMethods = {"Email_Generator"}, priority = 1)
	public void Express_Checkout(){
		
		System.out.println("Starting Test Cases: Express_Checkout");
		BaseTestObj.expressCheckoutPage(newemailtouse);
   		assertObjectsOnPagesObj.assertPaymentPageLoaded(BaseTestObj);
		System.out.println("Ending Test Cases: Express_Checkout");
   	
	       
	}
	
	@Test (dependsOnMethods = {"Express_Checkout"}, priority = 2)
	
	public void PayPal_Payment_Method(){
		
		System.out.println("Starting Test Cases: PayPal_Payment_Method");
   		assertObjectsOnPagesObj.Assert_PayPal_SignIn_Page(BaseTestObj.payPal());
		System.out.println("Ending Test Cases: PayPal_Payment_Method");

	}
	
	@Test (dependsOnMethods = {"PayPal_Payment_Method"}, priority = 3)
	
	public void SignIn_To_PayPal() {
		
		System.out.println("Starting Test Cases: SignIn_To_PayPal");
   		Boolean Signedin = (BaseTestObj.SignIn_To_PayPal(BaseTestObj.PayPalEmail, BaseTestObj.PayPalPassword));
   		assertObjectsOnPagesObj.Assert_SignedIn_InTo_PayPal(Signedin);
		System.out.println("Ending Test Cases: SignIn_To_PayPal");
	}

	@Test (dependsOnMethods = {"SignIn_To_PayPal"}, priority = 3)

	public void ProfilePageCompletion() {
		BaseTestObj.waitInSeconds(5);
		BaseTestObj.loadURL("Complete profile page", BaseTestObj.baseUrl + "/express-checkout/success?referenceNumber=15952419&postalCode=A1A%201A1");
		System.out.println("Starting Test Case: Profile_Page_Completion");
		assertObjectsOnPagesObj.AssertProfilePageCompleted(BaseTestObj.profilePage());
		System.out.println("Ending Test Case: Profile_Page_Completion");

	}

	@Test (dependsOnMethods = {"ProfilePageCompletion"}, priority = 4)

	public void AutoLogin(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: AutoLogin");
		assertObjectsOnPagesObj.AssertAutoLogin(BaseTestObj);
		System.out.println("Ending Test Case: AutoLogin");
	}

	@Test (dependsOnMethods = {"AutoLogin"}, priority = 5)

	public void subscriptionIsAdded(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
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
