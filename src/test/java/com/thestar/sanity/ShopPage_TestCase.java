package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class ShopPage_TestCase {

	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa3.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Express Checkout Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.subscribepage, name);
	}

	@Test (priority = 0, description = "Checking that all regionalization data-lpos present on page")
	public void regionalization_testing(){
		assertObjectsOnPagesObj.assertShopPageRegionalization(BaseTestObj);
	}

	@Test (priority = 1)
	public void AEM_data_shown_on_package_component(){
		assertObjectsOnPagesObj.assertAEMDataShopPagePackageComponent(BaseTestObj);
	}

	@Test (priority = 2)
	public void AEM_data_shown_on_benefits_component(){
		assertObjectsOnPagesObj.assertAEMDataBenefitsComponent(BaseTestObj);
	}

	@Test (priority = 3 )
	public void AEM_data_shown_on_other_offers_component(){
		assertObjectsOnPagesObj.assertAEMDataOtherOffers(BaseTestObj);
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing ShopPage test Cases");
		BaseTestObj.QuitBrowser();

	}


}
