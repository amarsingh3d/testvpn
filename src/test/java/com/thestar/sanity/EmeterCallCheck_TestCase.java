package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class EmeterCallCheck_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Emeter Call");
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
		BaseTestObj.baseUrl = url;
		
	}
	
	@Test (priority = 0)
	public void HomePageEmeterCall() {
		
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
					     
	}

	@Parameters({ "url"})
	@Test (priority = 1)
	public void ArticlePageEmeterCall(@Optional("https://reactqa2.smgdigitaldev.com") String url) {
		
		BaseTestObj.loadURL("Article Page", url + ReadExternalData.article1);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
					     
	}
	
	@Test (priority = 2)
	public void AuthorPageEmeterCall() {
		
		BaseTestObj.loadURL("Author Page", BaseTestObj.baseUrl + BaseTestObj.authorPage);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
		
					     
	}
	
	@Test (priority = 3)
	public void CartoonPageEmeterCall() {
		
		BaseTestObj.loadURL("Cartoon Page", BaseTestObj.baseUrl + BaseTestObj.cartoonPage);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
		
					     
	}

	@Parameters({ "url"})
	@Test (priority = 4)
	public void SlideShowPageEmeterCall(@Optional("https://reactqa2.smgdigitaldev.com") String url){
		
		BaseTestObj.loadURL("Slide Show Page", url + BaseTestObj.SlideShowPage2);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
					     
	}
	
	@Test (priority = 5)
	public void TopicPageEmeterCall() {
		
		BaseTestObj.loadURL("Topic Page", BaseTestObj.baseUrl + BaseTestObj.topicpage);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
		
					     
	}
	
	@Test (priority = 6)
	public void VideoPageEmeterCall(){
		
		BaseTestObj.loadURL("Video Page", BaseTestObj.baseUrl + BaseTestObj.VideoPage2);
		BaseTestObj.waitInSeconds(2);
		BaseTestObj.network_log_analytics();
		assertObjectsOnPagesObj.AssertEmeterCall(BaseTestObj);
		
					     
	}
	
    	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Emeter Call Testing");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
