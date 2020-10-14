package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class RegisteredSubscription_TestCases {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages AssertObjectionPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Registered Subscription Objects");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl + BaseTestObj.signinpage, name);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);
		
	}


	@Test (priority = 0,description = "Checking GreyBanner Text for Registered User Should NOT be empty text in banner")
	public void RegisteredGreyBanner(){
		  BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: RegisteredGreyBanner");
		BaseTestObj.loadPage("Home page", BaseTestObj.baseUrl);
		AssertObjectionPagesObj.assertTopHatContainer(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredGreyBanner");
	     	     
	}
	  

	@Test (priority = 1, description = "Checking Subscribe Button Text for Registered User Subscribe Now")
	public void RegisteredSubscribeButton(){
		  
		System.out.println("Starting Test Case: RegisteredSubscribeButton");
		AssertObjectionPagesObj.AssertSubscribeButton(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredSubscribeButton");

		
	}

	@Test (priority = 2, description = "Checking Toaster on home page for Registered User ")
	public void RegisteredToaster(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: RegisteredToaster");
		AssertObjectionPagesObj.AssertToaster(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredToaster");
	      
	}

	  
	@Test (priority = 3, description = "Checking Overlay for Registered User on first article visited")
	public void RegisteredOverlay() {
		System.out.println("Starting Test Case: RegisteredOverlay");
		BaseTestObj.loadURL("Article 1",BaseTestObj.baseUrl + ReadExternalData.article1);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		AssertObjectsOnPages.AssertOverlay(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredOverlay");

				     
	}  

	@Test (priority = 5, description = "Checking meter for Registered User on first 4 articles")
	public void RegisteredMeterArticle_1to4() {
		  
		System.out.println("Starting Test Case: RegisteredMeterArticle_1to4");
		BaseTestObj.loadURL("Article 3",BaseTestObj.baseUrl + ReadExternalData.article3);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		BaseTestObj.loadURL("Article 4",BaseTestObj.baseUrl + ReadExternalData.article4);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredMeterArticle_1to4");
				 	  
	}

	@Test (priority = 6, description = "Checking meter for Registered User on 5th article")
	public void RegisteredMeterArticle_5(){
		System.out.println("Starting Test Case: RegisteredMeterArticle_5");
		BaseTestObj.loadURL("Article 5",BaseTestObj.baseUrl + ReadExternalData.article5);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredMeterArticle_5");
				  
	}
	

	@Test (priority = 7, description = "Checking RegisteredMeteredWall")
	public void RegisteredMeteredWall(){
		 
		System.out.println("Starting Test Case: RegisteredMeteredWall");
		BaseTestObj.loadURL("Article 6",BaseTestObj.baseUrl + ReadExternalData.article6);
		AssertObjectionPagesObj.AssertMeteredWall(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredMeteredWall");
					  
	}
	
	
	@Test (priority = 8, description = "Checking RegisteredHardWall")
	public void RegisteredHardWall() {
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: RegisteredHardWall");
		BaseTestObj.DeleteAllCookies();
		BaseTestObj.loadURL("Sign in", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);
		BaseTestObj.loadPage("Hardwall page",BaseTestObj.baseUrl + BaseTestObj.articleHardwall);
		AssertObjectionPagesObj.assertHardWall(BaseTestObj);
		System.out.println("Ending Test Case: RegisteredHardWall");
				  	  
	}

//	@Test (priority = 7, description = "Checking premium wall for Registered User")
//	public void RegisteredPremiumWall(){
//
//		System.out.println("Starting Test Case: RegisteredPremiumWall");
//		BaseTestObj.premiumwall();
//		assertObjectsOnPagesObj.AssertPremiumwall_False(BaseTestObj);
//		System.out.println("Ending Test Case: RegisteredPremiumWall");
//
//	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Registered Subscription Objects");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
