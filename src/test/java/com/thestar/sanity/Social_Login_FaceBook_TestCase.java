package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Social_Login_FaceBook_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional(" https://qa4.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Social Login with FaceBook Account");
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
		
	}
	
   	@Test (priority = 0)
	
	public void Sign_In_Page_Loaded() {
		
   		assertObjectsOnPagesObj.assertSignInPageLoaded(BaseTestObj);
	       
	}
   	
	@Test (dependsOnMethods = {"Sign_In_Page_Loaded"}, priority =  1)
	
	public void User_SignedIn_Facebook() {
		
   		System.out.println("Asserting if user can sign in with Facebook Account");
   		BaseTestObj.facebookLoginPage();
   		Assert.assertTrue(BaseTestObj.signInFacebook(BaseTestObj.facebookusername, BaseTestObj.facebookpassword));
	}
	 
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Social Login with FaceBook Account");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
