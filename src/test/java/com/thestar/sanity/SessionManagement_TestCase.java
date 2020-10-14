package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class SessionManagement_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Testing Session management functionality");
		BaseTestObj.ReadObjectRepositoryXML();
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		BaseTestObj.network_log_marketing_id();
		BaseTestObj.baseUrl = url ;
		
	}

    @Test (priority = 1, description = "Verify that marketing id can be returned and it's length correct")
   	public void marketingIdIsPresent(){
		System.out.println(BaseTestObj.newnetData);
    	assertObjectsOnPagesObj.assertMarketingId(BaseTestObj.newnetData);

   	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase() throws Exception{
		BaseTestObj.QuitBrowser();
		BaseTestObj.BsLocal_Close();
		
	}

}
