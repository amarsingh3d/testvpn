package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SlideShowPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://www.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Slide Show Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url+ BaseTestObj.SlideShowPage2, name);
			
	}
    
    @Test (priority = 1)
  	public void SlideShowLeaderBoardAd(){
  		assertObjectsOnPagesObj.AssertSlideShowLeaderBoardAd(BaseTestObj);
  			     
  	}
    
  
    @Test (priority = 2)
  	public void SlideShownMoreArticles(){
  		assertObjectsOnPagesObj.AssertSlideShowMoreArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 3)
  	public void SlideShowPartnerArticles(){
  		assertObjectsOnPagesObj.AssertSlideShowPartnerArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 4)
  	public void SlideShowTopStories(){
  		assertObjectsOnPagesObj.AssertSlideShowTopStories(BaseTestObj);
  			     
  	}
	 	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Slide Show Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
