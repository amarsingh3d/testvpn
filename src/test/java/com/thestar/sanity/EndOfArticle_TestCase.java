package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class EndOfArticle_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Article Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + ReadExternalData.article2, name);
		BaseTestObj.baseUrl = url ;
	}

	@Test (priority = 1, description = "Checking Subscribe Button Text for Anonymous User 'Subscribe Now'")
	public void endOfArticleComponent(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.assertEndOfArticleComponent(BaseTestObj);
		BaseTestObj.expendComponent(BaseTestObj);
		BaseTestObj.collapseComponent(BaseTestObj);
		
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Article Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
