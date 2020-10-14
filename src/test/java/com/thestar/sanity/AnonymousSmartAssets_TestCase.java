package com.thestar.sanity;
import com.thestar.base.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AnonymousSmartAssets_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	ObtainObjectsTextAEM ObtainObjectsTextAEM = new ObtainObjectsTextAEM();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException {
		System.out.println("Started Testing Anonymous Objects Text for Smart Asset Rule"); 
		System.out.println("Reading Smart Asset XML File");
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
		System.out.println("Completed Reading Smart Asset XML File");
		
		System.out.println("Launching AEM");
		
		String aemURL = "https://author-stage.smgdigitaldev.com/libs/granite/core/content/login.html?resource=%252F&$$login$$=%2524%2524login%2524%2524&j_reason=unknown&j_reason_code=unknown";
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, aemURL, name);
	}
	@Test (priority = 0)
	public void AEMSetup() {
		BaseTestObj.loadPage("Home page", BaseTestObj.baseUrl);
		System.out.println("Started Testing Smart asset");
		System.out.println("Starting Test Case: AnonymousGreyBannerText");
		AssertObjectsOnPages.AssertGreyBannerTextAnonymous(ObtainObjectsTextAEM.BannerDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousGreyBannerText");
	}

	@Test (priority = 1, description = "Checking GreyBanner Text for Anonymous User \"Should NOT be empty text in banner\"")
	public void AnonymousGreyBannerText() {
		BaseTestObj.loadPage("Home page", BaseTestObj.baseUrl);
		System.out.println("Started Testing Smart asset");
		System.out.println("Starting Test Case: AnonymousGreyBannerText");
		AssertObjectsOnPages.AssertGreyBannerTextAnonymous(ObtainObjectsTextAEM.BannerDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousGreyBannerText");
	}

	@Test (priority = 2, description = "Checking Subscribe Button Text for Anonymous User \"Subscribe Now\"")
	public void AnonymousSubscribeButtonText(){
		
		System.out.println("Starting Test Case: AnonymousSubscribeButtonText");
		AssertObjectsOnPages.AssertSubscribeButtonText(ObtainObjectsTextAEM.SubscribeNowDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousSubscribeButtonText");
		
	}

	@Test (priority = 3, description = "Checking Toaster on home page for Anonymous User")
	public void AnonymousToasterText(){
		
		System.out.println("Starting Test Case: AnonymousToasterText");
		AssertObjectsOnPages.AssertToasterText(ObtainObjectsTextAEM.ToasterDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousToasterText");
	      
	}

	@Test (priority = 4, description = "Checking Overlay for Anonymous User on first article visited")
	public void AnonymousOverlayText() {
		System.out.println("Starting Test Case: AnonymousOverlayText");
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		AssertObjectsOnPages.AssertOverlayText(ObtainObjectsTextAEM.OverlayDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousOverlayText");
					     
	}  

	@Test (priority = 4, description = "Checking meter for Anonymous User on first 4 articles")
	public void AnonymousMeterText() {
		  
		System.out.println("Starting Test Case: AnonymousMeterText");
		BaseTestObj.loadURL("Article 3", BaseTestObj.baseUrl + ReadExternalData.article3);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 4", BaseTestObj.baseUrl + ReadExternalData.article4);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousMeterText");
						 	  
	}

	@Test (priority = 5, description = "Checking meter for Anonymous User on 5th article")
	public void AnonymousNormalPayWallText(){
		
		System.out.println("Starting Test Case: AnonymousNormalPaywallText5");
		BaseTestObj.loadURL("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopSUB, BaseTestObj);
		BaseTestObj.loadURL("Article 6", BaseTestObj.baseUrl + ReadExternalData.article6);
		AssertObjectsOnPages.AssertNormalPayWallText(ObtainObjectsTextAEM.NormalPaywallDesktopP2, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousNormalPaywallText5");
					  
	}

	@Test (priority = 6, description = "Checking hard wall for Anonymous User")
	public void AnonymousManualPayWallText() {
		
		System.out.println("Starting Test Case: AnonymousManualPayWallText");
		BaseTestObj.loadURL("Hardwall page",BaseTestObj.articleHardwall);
		AssertObjectsOnPages.AssertManualPayWallText(ObtainObjectsTextAEM.ManualPaywallDesktopP2, BaseTestObj);
		System.out.println("Ending Test Case: AnonymousManualPayWallText");

						  	  
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
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Anonymous Objects Text for Smart Asset Rule");
		BaseTestObj.QuitBrowser();
	}
	  

}
