package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class ie11_Sign_in_Issue_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Windows7_IE11") String browser, @Optional("") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Testing ie11 Signin Issue");
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
		BaseTestObj.BsLocal_Setup();
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl + BaseTestObj.signinpage, name);
		
	}
	
   	@Test (priority = 0)
	
	public void Sign_In_Page_Loaded() {
		
   		System.out.println("Starting Test Case: Sign_In_Page_Loaded");
   		assertObjectsOnPagesObj.assertSignInPageLoaded(BaseTestObj);
   		System.out.println("Ending Test Case: Sign_In_Page_Loaded");
	       
	}
   	
	@Test (dependsOnMethods = {"Sign_In_Page_Loaded"}, priority =  1)
	
	public void User_Signed_in() {
		
   		System.out.println("Starting Test Case: User_Signed_in");
   		System.out.println("Email: " + BaseTestObj.usernamebasic);
   		//System.out.println("Password: " + BaseTestObj.passwordreg);
   		BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
   		assertObjectsOnPagesObj.AssertUserSignedInSuccessfully(BaseTestObj);
   		System.out.println("Ending Test Case: User_Signed_in");
	       
	}
	 
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase() throws Exception{
		System.out.println("Completed Testing ie11 Signin Issue");  
		BaseTestObj.QuitBrowser();
		BaseTestObj.BsLocal_Close();
		
	}
	  

}
