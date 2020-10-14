package com.rdr.sanity;

import com.thestar.base.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class RDRSmartAssets_TestCase {

	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	ObtainObjectsTextAEM ObtainObjectsTextAEM = new ObtainObjectsTextAEM();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thereocrd.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException {
		System.out.println("Started Testing Objects Text for RDR Smart Asset Rule"); 
		
		System.out.println("Reading Environment XML File");
		BaseTestObj.ReadObjectRepositoryXML();
		System.out.println("Completed Reading Environment XML File");
		
		System.out.println("Reading RDR Environment XML File");
		BaseTestObj.ReadObjectRepositoryXML_RDR();
		System.out.println("Completed Reading RDR Environment XML File");
		
		String aemURL = "https://author-dev.smgdigitaldev.com/libs/granite/core/content/login.html?resource=%252F&$$login$$=%2524%2524login%2524%2524&j_reason=unknown&j_reason_code=unknown";
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, aemURL, name);
		System.out.println("Finished Launching AEM");
		
		System.out.println("Signing in into AEM");
		BaseTestObj.RDRAemSignInPage();
		System.out.println("Signed in into AEM");
		
		System.out.println("Launching AEM RDR Page");
		BaseTestObj.AemRDR();
		System.out.println("Finished Launching AEM RDR Page");
		
		System.out.println("Obtaining Objects text from AEM RDR Page");
		ObtainObjectsTextAEM.AEMRDRObjectText(BaseTestObj);
		System.out.println("Obtained Objects text from AEM RDR Page");
		BaseTestObj.loadURL("Home page", url);
		BaseTestObj.waitInSeconds(3);
	}
	
	

	@Test (priority = 0, description = "Checking GreyBanner Text for Anonymous User \"Should NOT be empty text in banner\"")
	@Parameters({"browser", "url", "name"})
	public void RDRGreyBannerText() {
		System.out.println("Started Testing Registration Flow");
		System.out.println("Starting Test Case: RDRGreyBannerText");
		AssertObjectsOnPages.AssertGreyBannerText_RDR(ObtainObjectsTextAEM.BannerDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RDRGreyBannerText");

			     
	}

	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 1, description = "Checking Subscribe Button Text for Anonymous User \"Subscribe Now\"")
	public void RDRSubscribeButtonText(){
		
		System.out.println("Starting Test Case: RDRSubscribeButtonText");
		AssertObjectsOnPages.AssertSubscribeButtonText(ObtainObjectsTextAEM.SubscribeNowDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RDRSubscribeButtonText");
		
	}

	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 2, description = "Checking Toaster on home page for Anonymous User")
	public void RDRToasterText(){
		
		System.out.println("Starting Test Case: RDRToasterText");
		AssertObjectsOnPages.AssertToasterText(ObtainObjectsTextAEM.ToasterDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RDRToasterText");
	      
	}
	  
	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 3, description = "Checking Overlay for Anonymous User on first article visited")
	public void RDROverlayText(){
		 
		System.out.println("Starting Test Case: RDROverlayText");
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		AssertObjectsOnPages.AssertOverlayText(ObtainObjectsTextAEM.OverlayDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RDROverlayText");
					     
	}  
	  

	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 4, description = "Checking meter for Anonymous User on first 4 articles")
	public void RDRMeterText() {
		  
		System.out.println("Starting Test Case: RDRMeterText");
		BaseTestObj.loadURL("Article 3", BaseTestObj.baseUrl + ReadExternalData.article3);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 4", BaseTestObj.baseUrl + ReadExternalData.article4);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		System.out.println("Ending Test Case: RDRMeterText");
						 	  
	}

	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 5, description = "Checking meter for Anonymous User on 5th article")
	public void RDRNormalPayWallText(){
		
		System.out.println("Starting Test Case: AnonymousNormalPaywallText5");
		BaseTestObj.loadURL("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 6", BaseTestObj.baseUrl + ReadExternalData.article6);
		AssertObjectsOnPages.AssertNormalPayWallText(ObtainObjectsTextAEM.NormalPaywallDesktopP2, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousNormalPaywallText5");
					  
	}

	@Test (dependsOnMethods = {"RDRGreyBannerText"}, priority = 6, description = "Checking hard wall for Anonymous User")
	public void RDRPayWallText() {
		
		System.out.println("Starting Test Case: AnonymousManualPaywallText");
		BaseTestObj.loadURL("Hard wall", BaseTestObj.baseUrl + BaseTestObj.articleHardwall);
		AssertObjectsOnPages.AssertManualPayWallText(ObtainObjectsTextAEM.ManualPaywallDesktopP2, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousManualPaywallText");

						  	  
	}
	/*
	//Checking premium wall for Anonymous User
	@Test (priority = 7)
	public void AnonymousPremiumwallText(){
		
		System.out.println("Starting Test Case: AnonymousPremiumwallText");
		BaseTestObjWeb.premiumwall();
		SmartAssetAssertObjectsObj.AssertPremiumPaywallText(ObtainObjectsTextAEM.PremiumPaywallDesktopP2, BaseTestObjWeb);
		System.out.println("Ending Test Case: AnonymousPremiumwallText");
					
	}*/
	
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects Text for RDR Smart Asset Rule");
		BaseTestObj.QuitBrowser();
		
	}
	

}
