package com.thestar.sanity;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class Adobe_Analytics_Tracking_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Testing Adobe Analytics Tracking");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		BaseTestObj.network_log_analytics();
		BaseTestObj.AnalyticsParameters();
		BaseTestObj.baseUrl = url ;
		
	}
	
	@Test (priority = 0)
	public void torontodnnlocal_qa(){
		BaseTestPageAndObjects.extractUrls(BaseTestObj.newnetData, "torontodnnlocal" );
	}
    
    @Test (priority = 1)
   	public void thestardesktop_dev(){
    BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
	BaseTestPageAndObjects.extractUrls(BaseTestObj.newnetData, "thestardesktopdev" );
   	}
    	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Adobe Analytics Tracking Testing");  
		BaseTestObj.QuitBrowser();
		
	}

}
