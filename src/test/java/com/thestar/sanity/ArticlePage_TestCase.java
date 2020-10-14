package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class ArticlePage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + ReadExternalData.article5, name);
		BaseTestObj.baseUrl = url ;
	}
	
	

	@Test (priority = 0)
	public void YMBII(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		BaseTestObj.waitInSeconds(5);
		BaseTestObj.scrollPage(0, 1600);
		assertObjectsOnPagesObj.AssertYMBIIArticlePage(BaseTestObj);
			     
	}

	@Test (priority = 2, description = "Checking Toaster on home page for Anonymous User ")
	public void ShareLabel(){
		
		assertObjectsOnPagesObj.AssertShareTextArticlePage(BaseTestObj);
	      
	}
	  
	@Test (priority = 3, description = "Checking Overlay for Anonymous User on first article visited")
	public void ShareOnFacebook() {	 
		 
		assertObjectsOnPagesObj.AssertShareFacebookArticlePage(BaseTestObj);
					     
	}  

	@Test (priority = 4, description = "Checking meter for Anonymous User on first 4 articles")
	public void ShareonTwitter(){
		  
		assertObjectsOnPagesObj.AssertShareTwitterArticlePage(BaseTestObj);
						 	  
	}

	@Test (priority = 5, description = "Checking meter for Anonymous User on 5th articleChecking meter for Anonymous User on 5th article")
	public void ShareonEmail(){
		 
		assertObjectsOnPagesObj.AssertShareEmailArticlePage(BaseTestObj);
					  
	}

//	@Test (priority = 6, description = "Checking hard wall for Anonymous User")
//	public void ConversationWidget(){
//		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
//		assertObjectsOnPagesObj.AssertConversationWidgetArticlePage(BaseTestObj);
//
//	}

	@Test (priority = 7, description = "Checking REPORT an error")
	public void ReportAnError(){
		
		assertObjectsOnPagesObj.AssertReportAnErrorArticlePage(BaseTestObj);
					
	}
	
	@Test (priority = 8, description = "Checking ABOUT PAGE")
	public void AboutTheStar(){
		
		assertObjectsOnPagesObj.AssertAboutTheStarArticlePage(BaseTestObj);
					
	}
	
	@Test (priority = 9, description = "Checking SeeMore")
	public void SeeMore(){
		
		assertObjectsOnPagesObj.AssertSeeMoreArticlePage(BaseTestObj);
					
	}
	
	@Test (priority = 10, description = "Checking TopStories")
	public void TopStories(){
		
		assertObjectsOnPagesObj.AssertTopStoriesArticlePage(BaseTestObj);
					
	}

	@Test (priority = 11, dependsOnMethods = "TopStories")
	public void Asserting_Trust_Label(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		BaseTestObj.loadURL("Page with trust label",BaseTestObj.baseUrl + BaseTestObj.trustlabel);
		System.out.println("Asserting TrustLabel");
		assertObjectsOnPagesObj.Assert_Trust_Label(BaseTestObj);

	}

	@Test (priority = 12, dependsOnMethods = "Asserting_Trust_Label",description = "Checking of 404 page exist and redirect correct")

	public void InvalidURL404NotFound() throws InterruptedException{
		BaseTestObj.loadURL("Invalid url", BaseTestObj.baseUrl + BaseTestObj.InvalidURL);
		System.out.println("Starting Test Case: InvalidURL404NotFound");
		assertObjectsOnPagesObj.AssertInvalidURL404NotFound(BaseTestObj);
		System.out.println("Ending Test Case: InvalidURL404NotFound");

	}


	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Article Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
