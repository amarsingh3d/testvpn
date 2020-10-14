package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BasicSubscription_TestCases {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.therecord.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Basic Subscription Objects");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.signinpage, name);
		BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
		
	}
	

	@Test (priority = 0, description = "Checking GreyBanner Text for Basic User")
	
	public void BasicGreyBanner(){
		BaseTestObj.loadPage("Home page", BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.assertTopHatContainer(BaseTestObj);
	       
	}

	@Test (priority = 1, description = "Checking Subscribe Button Text for Basic User")
	public void BasicSubscribeButton(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertSubscribeButtonBasic(BaseTestObj);
		   	   
	}

	@Test (priority = 2, description = "Checking Toaster on home page for Basic User")
	public void BasicToaster(){
		
		assertObjectsOnPagesObj.AssertToaster_False(BaseTestObj);
	}
	  
	@Test (priority = 3, description = "Checking Overlay for Registered User on first article visited")
	public void BasicOverlay() {
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		assertObjectsOnPagesObj.AssertMeterArticle_1to4_false(BaseTestObj);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		assertObjectsOnPagesObj.AssertMeterArticle_1to4_false(BaseTestObj);
								     
	}  

	@Test (priority = 4, description = "Checking meter for Registered User on first 4 articles")
	public void BasicMeterArticle_1to4(){
		BaseTestObj.loadURL("Article 3",BaseTestObj.baseUrl + ReadExternalData.article3);
		assertObjectsOnPagesObj.AssertMeterArticle_1to4_false(BaseTestObj);
		BaseTestObj.loadURL("Article 4",BaseTestObj.baseUrl + ReadExternalData.article4);
		assertObjectsOnPagesObj.AssertMeterArticle_1to4_false(BaseTestObj);
						 	  
	}

	@Test (priority = 5, description = "Checking meter for Anonymous User on 5th article")
	public void BasicMeterArticle_5(){
		BaseTestObj.loadURL("Article 5",BaseTestObj.baseUrl + ReadExternalData.article5);
		assertObjectsOnPagesObj.AssertMeterArticle_5_false(BaseTestObj);
				  
	}
	
	
	@Test (priority = 6)
	public void AnonymousMeteredWall(){
		System.out.println("Starting Test Case: AnonymousMeteredWall");
		BaseTestObj.loadURL("Article 6",BaseTestObj.baseUrl + ReadExternalData.article6);
		assertObjectsOnPagesObj.AssertMeteredWall_false(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousMeteredWall");
					  
	}

		@Test (priority = 7, description = "Checking hard wall for Anonymous User")
		public void BasicHardWall() {

		System.out.println("Starting Test Case: BasicHardWall");
		BaseTestObj.DeleteAllCookies();
		BaseTestObj.loadURL("Sign in page",BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
		BaseTestObj.loadPage("Hard wall", BaseTestObj.baseUrl + BaseTestObj.articleHardwall);
		assertObjectsOnPagesObj.AssertHardwall_true(BaseTestObj);
		System.out.println("Ending Test Case: BasicHardWall");
	}
	  
	
	/*  
	//Checking premium wall for Anonymous User
	@Test (priority = 7)
	public void BasicPremiumWall(){
		BaseTestObj.premiumwall();
		assertObjectsOnPagesObj.AssertArticleMeterwall_False(BaseTestObj);
						
	}*/
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Basic Subscription Objects");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
