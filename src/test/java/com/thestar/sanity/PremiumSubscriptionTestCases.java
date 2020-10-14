package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class PremiumSubscriptionTestCases {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Premium Subscription Objects");
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
		BaseTestObj.SignIn(BaseTestObj.usernamepremium, BaseTestObj.passwordpremium);
		
	}

	@Test (priority = 0, description = "Checking GreyBanner Text for Premium User")
	
	public void PremiumGreyBanner(){
		
		System.out.println("Testing Premium Banner");
		BaseTestObj.loadURL("Home page",BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.assertTopHatContainer(BaseTestObj);
	     
	}

	@Test (priority = 1, description = "Checking Subscribe Button for Premium User\"")
	public void PremiumSubscribeButton(){
		
		assertObjectsOnPagesObj.AssertSubscribeButton_False(BaseTestObj);
		
	}

	@Test (priority = 2, description = "Checking Toaster on home page for Premium User ")
	public void PremiumToaster(){
		
		assertObjectsOnPagesObj.AssertToaster_False(BaseTestObj);
	      
	}
	  
	@Test (priority = 3, description = "Checking Overlay for Premium User on first article visited")
	public void PremiumOverlay() {
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		assertObjectsOnPagesObj.AssertOverlay_true(BaseTestObj);
						     
	}  

	@Test (priority = 4, description = "Checking meter for Premium User on first 4 articles")
	public void PremiumMeterArticle_1to4() {
		BaseTestObj.loadURL("Article 3", BaseTestObj.baseUrl + ReadExternalData.article3);
		BaseTestObj.loadURL("Article 4", BaseTestObj.baseUrl + ReadExternalData.article4);
		assertObjectsOnPagesObj.AssertMeterArticle_1to4_false(BaseTestObj);
						 	  
	}

	@Test (priority = 5, description = "Checking meter for Premium User on 5th article")
	public void PremiumMeterArticle_5(){
		BaseTestObj.loadURL("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
		assertObjectsOnPagesObj.AssertMeterArticle_5_false(BaseTestObj);
				  
	}

	@Test (priority = 6, description = "Checking hard wall for Premium User")
	public void PremiumdHardWall(){
		BaseTestObj.loadURL("Hardwall page",BaseTestObj.articleHardwall);
		assertObjectsOnPagesObj.AssertHardwall_true(BaseTestObj);
	}

	@Test (priority = 7, description = "Checking premium wall for Premium User")
	public void PremiumPremiumWall(){
		
		BaseTestObj.premiumWall();
		assertObjectsOnPagesObj.AssertPremiumwall_False(BaseTestObj);
				
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Premium Subscription Objects");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
