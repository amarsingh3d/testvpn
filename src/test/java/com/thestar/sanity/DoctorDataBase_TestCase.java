package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class DoctorDataBase_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Dr. Database");
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
		BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);

	}
	
	
   	@Test (priority = 0)
	public void DR_DB_Page_Loaded(){
		
   		BaseTestObj.loadURL("Doctor db page", BaseTestObj.baseUrl + BaseTestObj.doctordb);
   		assertObjectsOnPagesObj.Assert_Search_Box(BaseTestObj);
   		
	}
   	
   	@Test (dependsOnMethods = {"DR_DB_Page_Loaded"}, priority = 1)
	
	public void Assert_Doctor_Search(){
   		BaseTestObj.Search_Doctor("armogan");
   		assertObjectsOnPagesObj.Assert_Doctor_Found(BaseTestObj);
   		
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Dr. Database");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
