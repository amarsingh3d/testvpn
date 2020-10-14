package com.rdr.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class MPP_Config_Test_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thespec.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started MPP Config Test");
		BaseTestObj.ReadObjectRepositoryXML();
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.subscribepage, name);

	}
	
	
   	@Test (priority = 0)
	
	public void theSpecPayment_page() {
		
   		System.out.println("Loading Login Page");
   		BaseTestObj.thespec_payment_page();
		assertObjectsOnPagesObj.Assert_thespec_email(BaseTestObj);
	       
	}
	
   	@Test (dependsOnMethods = {"theSpecPayment_page"}, priority = 1)
   	
   	public void theSpecSignIn_user() {
		
   		System.out.println("Signing in existing user");
   		BaseTestObj.thespec_signin_user(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
	}
   	
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed Testing MPP Config Test");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
