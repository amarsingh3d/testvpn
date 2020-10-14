package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class ExpressCheckoutPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Express Checkout Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.signinpage, name);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);

	}
	
	
   	@Test (priority = 0)
	@Parameters({"url"})
	public void EmailField_AutoPopulated(@Optional("https://reactqa2.smgdigitaldev.com") String url) {
		
   		System.out.println("Express Checkout Page For Email Field Value");
		BaseTestObj.loadURL("Express checkout", url + BaseTestObj.expresscheckoutpage);
		BaseTestObj.waitForInput();
		assertObjectsOnPagesObj.AssertEmailFieldValue(BaseTestObj);
	       
	}
	
   	@Test (priority = 1)
   	
   	public void EmailField_ReadOnly() {
		
   		System.out.println("Express Checkout Page For Email Field Read Only");
   		BaseTestObj.newValueEmailField();
		assertObjectsOnPagesObj.assertEmailFieldReadOnly(BaseTestObj);
	       
	}

	@Test (priority = 1)

	public void DAPSLinkExpressCheckout() {
		System.out.println("Express Checkout Page For Email Field Read Only");
		assertObjectsOnPagesObj.assertDAPSLinkExpressCheckout(BaseTestObj);

	}
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing SUB-316");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
