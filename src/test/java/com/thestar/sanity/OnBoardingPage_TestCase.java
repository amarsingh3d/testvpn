package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class OnBoardingPage_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages AssertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa2.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing On-boarding pages");
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
		BaseTestObj.ReadObjectRepositoryXML();
		BaseTestObj.baseUrl = url;
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		
	}

	@Test (priority = 0)
	public void SubscribeNewsLetters() {
		BaseTestObj.loadURL("Emails page", BaseTestObj.baseUrl + BaseTestObj.onboardingPage);
		BaseTestObj.subscribeNewsLetter();
		AssertObjectsOnPagesObj.asertOnBoardingPage(BaseTestObj);

	}

	@Test (priority = 0)
	public void UnSubscribeNewsLetters() {
		BaseTestObj.unSubscribeNewsLetter();

	}

	@Test (priority = 2)
	public void AEMFieldsVerification() {
		AssertObjectsOnPagesObj.assertAEMFieldsOnBoarding(BaseTestObj);
	}

	@Test(priority = 3, description = "Verification of mobile app promo page")
	public void MobilePromPage(){
		BaseTestObj.nextPromoPage();
		AssertObjectsOnPagesObj.assertAEMFieldPromoPage(BaseTestObj);
		AssertObjectsOnPagesObj.asertOnBoardingMobilePromoPageObjects(BaseTestObj);
		BaseTestObj.textMeAPP();
		AssertObjectsOnPagesObj.assertSuccessMessage(BaseTestObj);
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing on-boarding pages");
		BaseTestObj.QuitBrowser();
		
	}

}
