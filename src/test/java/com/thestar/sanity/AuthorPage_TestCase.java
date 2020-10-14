package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AuthorPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Author Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.authorPage, name);
		BaseTestObj.baseUrl = url;
	}
	
	
    @Test (priority = 0)
	public void AuthorTitle(){
		assertObjectsOnPagesObj.AssertAutorTitle(BaseTestObj);
			     
	}
    
    
    @Test (priority = 1)
  	public void AuthorImage(){
  		assertObjectsOnPagesObj.AssertAutorImage(BaseTestObj);
  			     
  	}
    
    @Test (priority = 2)
  	public void AuthorProfileName(){
  		assertObjectsOnPagesObj.AssertAuthorProfileName(BaseTestObj);
  			     
  	}
    
    @Test (priority = 3)
  	public void AuthorProfileDescription(){
  		assertObjectsOnPagesObj.AssertAuthorProfileDescription(BaseTestObj);
  			     
  	}
    
    @Test (priority = 4)
  	public void ArticlesByAuthor(){
  		assertObjectsOnPagesObj.AssertArticlesByAuthor(BaseTestObj);
  			     
  	}
    
    @Test (priority = 5)
  	public void AuthorGoogleAdSlot(){
  		assertObjectsOnPagesObj.AssertAuthorGoogleAdSlot(BaseTestObj);
  			     
  	}
    
    @Test (priority = 6)
  	public void AuthorMoreFromAuthor(){
  		assertObjectsOnPagesObj.AssertAuthorViewMore(BaseTestObj);
  			     
  	}
	 	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Author Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
