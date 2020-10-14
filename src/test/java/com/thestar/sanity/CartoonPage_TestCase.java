package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CartoonPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages AssertObjectJsonPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.niagarafallsreview.ca") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Topic Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.cartoonPage, name);
			
	}
	
	
    @Test (priority = 0)
	public void CartoonEditorialCartoonLabel(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		AssertObjectJsonPagesObj.AssertCartoonEditorialCartoonLabel(BaseTestObj);
			     
	}
    
    
    @Test (priority = 1)
  	public void CartoonArticleHeadLine(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
  		AssertObjectJsonPagesObj.AssertCartoonArticleHeadLine(BaseTestObj);
  			     
  	}
    
    @Test (priority = 2)
  	public void CartooImageBody(){
    	AssertObjectJsonPagesObj.AssertCartooImageBody(BaseTestObj);
    	
  			     
  	}
    
//    @Test (priority = 3)
//  	public void CartoonGoogleAdSlot(){
//  		AssertObjectJsonPagesObj.AssertCartoonGoogleAdSlot(BaseTestObj);
//
//  	}
    
    @Test (priority = 4)
  	public void CartoonRelatedArticles_YMBII(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
    	AssertObjectJsonPagesObj.AssertCartoonRelatedArticles(BaseTestObj);

  			     
  	}
    
    @Test (priority = 5)
  	public void CartoonMoreArticles(){
  		AssertObjectJsonPagesObj.AssertCartoonMoreArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 6)
  	public void CartoonPartnerArticles(){
  		AssertObjectJsonPagesObj.AssertCartoonPartnerArticles(BaseTestObj);
  			     
  	}
    
    @Test (priority = 7)
  	public void CartoonTopStories(){
  		AssertObjectJsonPagesObj.AssertCartoonTopStories(BaseTestObj);
  			     
  	}
	 	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Article Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
