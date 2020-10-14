package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class VideoPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa2.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Video Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.VideoPage2, name);
		BaseTestObj.baseUrl = url;
			
	}
	
	
    @Test (priority = 0)
	public void VideoYMBBINotPresent(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertVideoYMBIINotPresent(BaseTestObj);
			     
	}
    
    @Test (priority = 1)
  	public void VideoLeaderBoardAd(){
  		assertObjectsOnPagesObj.AssertVideoLeaderBoardAd(BaseTestObj);
  			     
  	}
    
  
    @Test (priority = 2)
  	public void VideonMoreArticles(){
  		assertObjectsOnPagesObj.AssertVideoMoreArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 3)
  	public void VideoPartnerArticles(){
  		assertObjectsOnPagesObj.AssertVideoPartnerArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 4)
  	public void VideoTopStories(){
  		assertObjectsOnPagesObj.AssertVideoTopStories(BaseTestObj);
  			     
  	}
	 	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Video Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
