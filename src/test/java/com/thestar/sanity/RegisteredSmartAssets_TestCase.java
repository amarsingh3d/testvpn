package com.thestar.sanity;

import com.thestar.base.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class RegisteredSmartAssets_TestCase {

	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	ObtainObjectsTextAEM ObtainObjectsTextAEM = new ObtainObjectsTextAEM();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException {

		System.out.println("Started Testing Registered Objects Text for Smart Asset Rule"); 
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
		System.out.println("Finished Launching AEM");
		
		System.out.println("Signing in into AEM");
		BaseTestObj.AemSignInPage();
		System.out.println("Signed in into AEM");
		
		System.out.println("Launching AEM Automate-Registered Page");
		BaseTestObj.AemAutomateRegistered();
		System.out.println("Finished Launching AEM Automate-Registered Page");
		
		System.out.println("Obtaining Objects text from AEM Automate-Registered Page");
		ObtainObjectsTextAEM.AEMRegisteredObjectText(BaseTestObj);
		System.out.println("Obtained Objects text from AEM Automate-Registered Page");

	}

	@Test (priority = 0, description = "Checking Subscribe Button Text for Anonymous User Subscribe Now")
	public void RegisteredSubscribeButtonText(){
		BaseTestObj.loadURL("Sign in page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);
		BaseTestObj.waitInSeconds(5);
		System.out.println("Starting Test Case: RegisteredSubscribeButtonText");
		AssertObjectsOnPages.AssertSubscribeButtonText(ObtainObjectsTextAEM.SubscribeNowDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredSubscribeButtonText");

		
	}

	@Test (priority = 1, description = "Checking Toaster on home page for Anonymous User ")
	public void RegisteredToasterText(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		System.out.println("Starting Test Case: RegisteredToasterText");
		AssertObjectsOnPages.AssertToasterText(ObtainObjectsTextAEM.ToasterDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredToasterText");
	}

//	@Test (priority = 2, description = "Checking GreyBanner Text for Anonymous User 'Should NOT be empty text in banner'")
//	public void RegisteredGreyBannerText(){
//		System.out.println("Started Testing Smart asset");
//		System.out.println("Starting Test Case: RegisteredGreyBannerText");
//		AssertObjectsOnPages.AssertGreyBannerText_Registered(ObtainObjectsTextAEM.BannerDesktopP1, BaseTestObj);
//		System.out.println("Ending Test Case: RegisteredGreyBannerText");
//
//	}
	  
	@Test (priority = 3, description = "Checking Overlay for Anonymous User on first article visited", dependsOnMethods = "RegisteredToasterText")
	public void RegisteredOverlay() {
		System.out.println("Starting Test Case: RegisteredOverlay");
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopP1, BaseTestObj);
		BaseTestObj.loadURL("Article 2", BaseTestObj.baseUrl + ReadExternalData.article2);
		AssertObjectsOnPages.AssertOverlayText(ObtainObjectsTextAEM.OverlayDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredOverlay");
					     
	}  

	@Test (priority = 4, description = "Checking meter for Anonymous User on first 4 articles", dependsOnMethods = "RegisteredOverlay")
	public void RegisteredMeterText() {
		System.out.println("Starting Test Case: RegisteredMeterText");
		BaseTestObj.loadPage("Article 3", BaseTestObj.baseUrl + ReadExternalData.article3);
//		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopP1, BaseTestObj);
		BaseTestObj.loadURL("Article 4", BaseTestObj.baseUrl + ReadExternalData.article4);
		AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredMeterText");
						 	  
	}

	@Test (priority = 5, description = "Checking meter for Anonymous User on 5th article", dependsOnMethods = "RegisteredMeterText")
	public void RegisteredNormalPayWallText5() {
		 
		System.out.println("Starting Test Case: RegisteredNormalPaywallText5");
		BaseTestObj.loadPage("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
		//AssertObjectsOnPages.AssertMeterText(ObtainObjectsTextAEM.MeterDesktopP1, BaseTestObj);
		BaseTestObj.loadURL("Article 6",BaseTestObj.baseUrl + ReadExternalData.article6);
		AssertObjectsOnPages.AssertNormalPayWallText(ObtainObjectsTextAEM.NormalPaywallDesktopP2, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredNormalPaywallText5");

					  
	}

	@Test (priority = 6, description = "Checking hard wall for Anonymous User")
	public void RegisteredManualPaywallText(){
		
		System.out.println("Starting Test Case: RegisteredManualPaywallText");
		BaseTestObj.loadURL("Hardwall page",BaseTestObj.baseUrl + BaseTestObj.articleHardwall);
		AssertObjectsOnPages.AssertManualPayWallText(ObtainObjectsTextAEM.ManualPaywallParagraph2, BaseTestObj);
		System.out.println("Ending Test Case: RegisteredManualPaywallText");

						  	  
	}
	/*
	//Checking premium wall for Anonymous User
	@Test (priority = 7)
	public void RegisteredPremiumwallText(){
		
		System.out.println("Starting Test Case: RegisteredPremiumwallText");
		BaseTestObjWeb.premiumwall();
		SmartAssetAssertObjectsObj.AssertPremiumPaywallText(ObtainObjectsTextAEM.PremiumPaywallDesktopP2, BaseTestObjWeb);
		System.out.println("Ending Test Case: RegisteredPremiumwallText");

					
	}*/
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Registered Objects Text for Smart Asset Rule");
		BaseTestObj.QuitBrowser();
		
	}
	  

}
