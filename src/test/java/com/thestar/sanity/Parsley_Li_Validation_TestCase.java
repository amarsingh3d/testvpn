package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Parsley_Li_Validation_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Parsley and Liftniter");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl + ReadExternalData.article5, name);
		BaseTestObj.network_log();
		
	}
	
	
    @Test (priority = 0)
	public void pixel_parsely_pageview(){
		assertObjectsOnPagesObj.Assert_PixelParsely_PageView(BaseTestObj);
					     
	}
    
    @Test (priority = 2)
   	public void query_petametrics_widget_shown(){
    	 BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.Assert_QueryPetametrics_widget_shown(BaseTestObj);
   					     
   	}
    
    @Test (priority = 3)
   	public void query_petametrics_stuck_10s(){
   		assertObjectsOnPagesObj.Assert_QueryPetametrics_stuck_10s(BaseTestObj);
   					     
   	}
	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Parsley and Liftniter");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
