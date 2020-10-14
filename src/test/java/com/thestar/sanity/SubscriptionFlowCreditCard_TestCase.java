package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class SubscriptionFlowCreditCard_TestCase {
	
	private String newemailtouse = "";
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com/") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing New Subscription with Credit Card");
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
	
	public void EmailGenerator() throws IOException {
		
   		System.out.println("Starting Test Case: Email_Generator");
   		newemailtouse = BaseTestObj.createNewYopMailEmail();
		FileWriter csvWriter = new FileWriter("testUserEmails.csv");
		csvWriter.append(String.join(",", newemailtouse));
		csvWriter.append("\n");
		csvWriter.flush();
		csvWriter.close();
   		WriteExternalDataObj.WriteObjectRepositoryXML(newemailtouse);
   		System.out.println("Ending Test Case: Email_Generator");

   	
	       
	}
	
	@Test (dependsOnMethods = {"EmailGenerator"}, priority = 1)
	public void ExpressCheckout(){
   		System.out.println("Starting Test Case: Express_Checkout");
		BaseTestObj.expressCheckoutPage(newemailtouse);
   		assertObjectsOnPagesObj.assertPaymentPageLoaded(BaseTestObj);
   		System.out.println("Ending Test Case: Express_Checkout");
	       
	}

	@Test (dependsOnMethods = {"ExpressCheckout"}, priority = 2)

	public void applyPromoCode() {
		System.out.println("Starting Test Case: applyPromoCode");
		BaseTestObj.usePromoCode();
		assertObjectsOnPagesObj.AssertPromoCode(BaseTestObj);
		System.out.println("Ending Test Case: Payment_Completion");

	}
	
	
	@Test (dependsOnMethods = {"applyPromoCode"}, priority = 3)
	
	public void PaymentCompletion() {
   		System.out.println("Starting Test Case: Payment_Completion");
   		BaseTestObj.paymentPage();
   		assertObjectsOnPagesObj.AssertCompleteProfilePage(BaseTestObj);
   		System.out.println("Ending Test Case: Payment_Completion");

   		       
	}
	
	
	@Test (dependsOnMethods = {"PaymentCompletion"}, priority = 3)
	
	public void ProfilePageCompletion() {
		BaseTestObj.waitInSeconds(5);
		BaseTestObj.loadURL("Complete profile page", BaseTestObj.baseUrl + "/express-checkout/success?referenceNumber=15952419&postalCode=A1A%201A1");
   		System.out.println("Starting Test Case: Profile_Page_Completion");
   		assertObjectsOnPagesObj.AssertProfilePageCompleted(BaseTestObj.profilePage());
   		System.out.println("Ending Test Case: Profile_Page_Completion");
   		       
	}
	
	@Test (dependsOnMethods = {"ProfilePageCompletion"}, priority = 4)
	
	public void AutoLogin() {
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
   		System.out.println("Starting Test Case: AutoLogin");
   		assertObjectsOnPagesObj.AssertAutoLogin(BaseTestObj);
   		System.out.println("Ending Test Case: AutoLogin");
	}

	@Test (dependsOnMethods = {"AutoLogin"}, priority = 5)

	public void subscriptionIsAdded(){
		System.out.println("Starting Test Case: subscriptionIsAdded");
		BaseTestObj.loadURL("Order page",BaseTestObj.baseUrl + BaseTestObj.subscriptionsOrdersPage);
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
