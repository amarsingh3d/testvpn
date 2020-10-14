package com.thestar.sanity;

import com.thestar.base.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CampaignFromURLParameter_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	ObtainObjectsTextAEM ObtainObjectsTextAEM = new ObtainObjectsTextAEM();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException {
		System.out.println("Started Testing SUB-431 Campaign from URL Parameter"); 
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
	

	@Test (priority = 0, description = "Checking GreyBanner Text for Anonymous User \"Should NOT be empty text in banner\"")
	public void loadCampaignFromURL() {
		System.out.println("Launching StarWeb");
		BaseTestObj.loadPage("Home page", BaseTestObj.baseUrl);
		System.out.println("Finished Launching StarWeb");
		String CampaignFromUrl = BaseTestObj.baseUrl + "/?campaignid=automate-registered";
		BaseTestObj.loadURL("Registerd Campaign from URL Parameter", CampaignFromUrl);
			     
	}
	 	
	@Test (priority = 1)
	public void SubscribeButtonText(){
		
		System.out.println("Starting Test Case: SubscribeButtonText");
		AssertObjectsOnPages.AssertSubscribeButtonText(ObtainObjectsTextAEM.SubscribeNowDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: SubscribeButtonText");
		
	}
	  	
	@Test (priority = 2)
	public void ToasterText(){
		
		System.out.println("Starting Test Case: SubscribeButtonText");
		AssertObjectsOnPages.AssertToasterText(ObtainObjectsTextAEM.ToasterDesktopP1, BaseTestObj);
		System.out.println("Ending Test Case: SubscribeButtonText");

	      
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing SUB-431 Campaign from URL Parameter");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
