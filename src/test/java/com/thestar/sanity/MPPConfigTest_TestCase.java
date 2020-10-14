package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class MPPConfigTest_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started MPP Config Test");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.thespecsubscribe, name);

	}
	
	
   	@Test (priority = 0)
	
	public void thespec_payment_page(){
		
   		System.out.println("Loading Login Page");
   		BaseTestObj.thespec_payment_page();
		assertObjectsOnPagesObj.Assert_thespec_email(BaseTestObj);
	       
	}
	
   	@Test (dependsOnMethods = {"thespec_payment_page"}, priority = 1)
   	
   	public void thespec_signin_user(){
		
   		System.out.println("Signing in existing user");
   		BaseTestObj.thespec_signin_user(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
	       
	}
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing MPP Config Test");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
