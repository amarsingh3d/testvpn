package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.WriteExternalData;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;

public class GiftFlow_TestCase {
	private String giftFromEmail = "";
	private String GiftForEmail = "";
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	WriteExternalData WriteExternalDataObj = new WriteExternalData();
	AssertObjectsOnPages AssertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.therecord.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing On boarding page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url+ BaseTestObj.giftsPage, name);
		
	}

	@Test (priority = 0)
	public void switchBetweenGifts() {
		BaseTestObj.waitGorGiftPage();
		BaseTestObj.switchBetweenGifts();
		AssertObjectsOnPagesObj.asertGiftPage(BaseTestObj);
		AssertObjectsOnPagesObj.asertFAQComponent(BaseTestObj);
		AssertObjectsOnPagesObj.asertTermsComponent(BaseTestObj);
		BaseTestObj.proceedToPurchaseDetails();
	}

	@Test (priority = 1, dependsOnMethods = "switchBetweenGifts")
	public void editGiftPackage() {
		AssertObjectsOnPagesObj.asertPurchaseDetailsPage(BaseTestObj);
		BaseTestObj.editPackage();
		AssertObjectsOnPagesObj.asertGiftPage(BaseTestObj);
		BaseTestObj.proceedToPurchaseDetails();
	}

	@Test (priority = 0,dependsOnMethods = "editGiftPackage")
	public void giftProcessBar() {
		AssertObjectsOnPagesObj.asertGiftProcessBar(BaseTestObj);
	}

	@Test (priority = 2, dependsOnMethods = "editGiftPackage")
	public void purchaseDetailsPage() throws IOException {
		giftFromEmail = BaseTestObj.createNewMailinatorEmail();
		GiftForEmail = BaseTestObj.createNewMailinatorEmail();
		WriteExternalDataObj.WriteObjectRepositoryXML(GiftForEmail);
		WriteExternalDataObj.WriteObjectRepositoryXML(giftFromEmail);
		AssertObjectsOnPagesObj.asertPurchaseDetailsPage(BaseTestObj);
		BaseTestObj.enterPurchaseDetailsInfo(giftFromEmail,GiftForEmail);
		AssertObjectsOnPagesObj.asertTermsComponent(BaseTestObj);
		BaseTestObj.submitPurchaseDetailsPage();
	}

	@Test(priority = 3)
    public void redeemActivationCode(){
		BaseTestObj.loadURL("Gif redeem page",BaseTestObj.baseUrl + BaseTestObj.giftRedeemPage);
		AssertObjectsOnPagesObj.asertFAQComponent(BaseTestObj);
		AssertObjectsOnPagesObj.asertHowItWorks(BaseTestObj);
		AssertObjectsOnPagesObj.asertActivationCode(BaseTestObj);
	}

	@AfterTest
	public void TerminateTestCase(){
		System.out.println("Completed Testing");
		BaseTestObj.QuitBrowser();
		
	}

}
