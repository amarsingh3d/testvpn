package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class LocalTestingAdobeAnalyticsTracking_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Testing Adobe Analytics Tracking");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		BaseTestObj.network_log_analytics();
		BaseTestObj.AnalyticsParameters();
		
	}
	
	@Test (priority = 0)
	public void torontodnnlocal_qa(){
		assertObjectsOnPagesObj.Assert_torontodnnlocalqa(BaseTestObj);
					     
	}
    
    @Test (priority = 1)
   	public void thestardesktop_dev(){
    	BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
        assertObjectsOnPagesObj.Assert_thestardesktopdev(BaseTestObj);
   	}
    	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase() throws Exception{
		System.out.println("Completed Adobe Analytics Tracking Testing");  
		BaseTestObj.QuitBrowser();
		BaseTestObj.BsLocal_Close();
		
	}
	  

}
