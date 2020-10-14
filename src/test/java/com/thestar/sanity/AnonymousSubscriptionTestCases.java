package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AnonymousSubscriptionTestCases {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages AssertObjectionPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Anonymous Subscription Objects");
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
		System.out.println("Start Loading: Home page");
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl, name);
		System.out.println("End Loading: Home page");
		
	}

	@Test (priority = 0, description = "Checking GreyBanner Text for Anonymous User 'Should NOT be empty text in banner'")
	public void AnonymousGreyBanner(){
	
		System.out.println("Starting Test Case: AnynomousGreyBanner");
		AssertObjectionPagesObj.assertTopHatContainer(BaseTestObj);
		System.out.println("Ending Test Case: AnynomousGreyBanner");

			     
	}
	 

	@Test (priority = 1, description = "Checking Subscribe Button Text for Anonymous User 'Subscribe Now'")
	public void AnonymousSubscribeButton(){
		
		System.out.println("Starting Test Case: AnonymousSubscribeButton");
		AssertObjectionPagesObj.AssertSubscribeButton(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousSubscribeButton");

		
	}

	@Test (priority = 2, description = "Checking Toaster on home page for Anonymous User ")
	public void AnonymousToaster(){
		
		System.out.println("Starting Test Case: AnonymousToaster");
		AssertObjectionPagesObj.AssertToaster(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousToaster");

	      
	}
	  
	@Test (priority = 3, description = "Checking Overlay for Anonymous User on first article visited")
	public void AnonymousOverlay() {
		 
		System.out.println("Starting Test Case: AnonymousOverlay");
		System.out.println(BaseTestObj.baseUrl + ReadExternalData.article1);
		BaseTestObj.loadURL("Article 1",BaseTestObj.baseUrl + ReadExternalData.article1);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		BaseTestObj.loadURL("Article 2",BaseTestObj.baseUrl + ReadExternalData.article2);
		BaseTestObj.isEnabled(By.xpath("//div[@class='overlayRightPanel']"));
		AssertObjectsOnPages.AssertOverlay(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousOverlay");

					     
	}  

	@Test (priority = 4, description = "Checking meter for Anonymous User on first 4 articles")
	public void AnonymousMeterArticle_1to4() {
		  
		System.out.println("Starting Test Case: AnonymousMeterArticle_1to4");
		BaseTestObj.loadURL("Article 3",BaseTestObj.baseUrl + ReadExternalData.article3);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		BaseTestObj.loadURL("Article 4",BaseTestObj.baseUrl + ReadExternalData.article4);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousMeterArticle_1to4");

						 	  
	}

	@Test (priority = 5, description = "Checking meter for Anonymous User on 5th article")
	public void AnonymousMeterArticle_5(){

		System.out.println("Starting Test Case: AnonymousMeterArticle_5");
		BaseTestObj.loadURL("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
		AssertObjectionPagesObj.assertMeterArticle(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousMeterArticle_5");
					  
	}
	
	@Test (priority = 6, description = "Checking normal wall for Anonymous User")
	public void AnonymousMeteredWall(){
		 
		System.out.println("Starting Test Case: AnonymousMeteredWall");
		BaseTestObj.loadURL("Article 6",BaseTestObj.baseUrl + ReadExternalData.article6);
		AssertObjectionPagesObj.AssertMeteredWall(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousMeteredWall");
					  
	}

	@Test (priority = 7, description = "Checking hard wall for Anonymous User")
	public void AnonymousHardWall(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: AnonymousHardWall");
		BaseTestObj.loadURL("Hardwall page",BaseTestObj.baseUrl + BaseTestObj.articleHardwall);
		AssertObjectionPagesObj.assertHardWall(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousHardWall");
								  	  
	}
	
	/*  
	//Checking premium wall for Anonymous User
	@Test (priority = 7)
	public void AnonymousPremiumWall(){
		
		System.out.println("Starting Test Case: AnonymousPremiumWall");
		BaseTestObj.premiumwall();
		assertObjectsOnPagesObj.AssertPremiumwall_False(BaseTestObj);
		System.out.println("Ending Test Case: AnonymousPremiumWall");
					
	}*/
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Anonymous Subscription Objects");  
		BaseTestObj.QuitBrowser();
	}
	  

}
