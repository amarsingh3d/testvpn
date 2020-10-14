package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SponsoredArticlePage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Sponsored Article Page");
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
		BaseTestObj.baseUrl = url ;
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
			
	}

	@Parameters({"url"})
    @Test (priority = 0)
	public void SponsoredArticlePayWallNotPresent(@Optional ("https://reactqa2.smgdigitaldev.com") String url) {
    	System.out.println("Starting Test Case: SponsoredArticlePayWallNotPresent");
    	BaseTestObj.loadURL("article1", url + ReadExternalData.article1);
		BaseTestObj.loadURL("article2",url + ReadExternalData.article2);
		BaseTestObj.loadURL("article3", url + ReadExternalData.article3);
		BaseTestObj.loadURL("article4", url + ReadExternalData.article4);
		BaseTestObj.loadURL("article5", url + ReadExternalData.article5);
    	BaseTestObj.loadURL("sponsored article", url + BaseTestObj.SponsoredArticle);
		assertObjectsOnPagesObj.AssertSponsoredArticlePayWallNotPresent(BaseTestObj);
    	System.out.println("Ending Test Case: SponsoredArticlePayWallNotPresent");

			     
	}
    
    @AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Anonymous Subscription Objects");  
		BaseTestObj.QuitBrowser();
		
	}
    
    
	  

}
