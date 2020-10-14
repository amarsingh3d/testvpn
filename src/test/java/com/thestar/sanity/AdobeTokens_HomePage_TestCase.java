package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class AdobeTokens_HomePage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	String FullUrl = "";

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome_Console") String browser, @Optional("") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Start Test Case: " + "AdobeTokens_HomePage_LocationNotSpecified_TestCase");
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
		FullUrl = BaseTestObj.baseUrl + url;
		System.out.println("Full URL: " + FullUrl);
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, FullUrl, name);
		BaseTestObj.Reading_AdobeTokensFromConsoleData();
	
		
	}
	
	@Test (priority = 0)
	@Parameters({"pageType"})
	public void PageType(String pageType){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "pageType", pageType);
	}
	
	@Test (priority = 1)
	@Parameters({"channel"})
	public void Channel(String channel){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "channel", channel);
	}
	
	@Test (priority = 2)
	@Parameters({"template"})
	public void Template(String template){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "template", template);
	}
	
	@Test (priority = 3)
	@Parameters({"location"})
	public void Location(String location){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "location", location);
	}
	
	@Test (priority = 4)
	@Parameters({"siteDomain"})
	public void SiteDomain(String siteDomain){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "siteDomain", siteDomain);
	}
	
	@Test (priority = 5)
	@Parameters({"commenting"})
	public void Commenting(String commenting){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "commenting", commenting);
	}
	
	@Test (priority = 6)
	@Parameters({"locked"})
	public void Locked(String locked){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "locked", locked);
	}
	
	@Test (priority = 7)
	@Parameters({"metered"})
	public void Metered(String metered){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "metered", metered);
	}
	
	@Test (priority = 8)
	@Parameters({"mobileInlay"})
	public void MobileInlay(String mobileInlay){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "mobileInlay", mobileInlay);
	}
	
	@Test (priority = 9)
	@Parameters({"overlay"})
	public void Overlay(String overlay){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlay", overlay);
	}
	
	@Test (priority = 10)
	@Parameters({"overlayRenew"})
	public void OverlayRenew(String overlayRenew){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlayRenew", overlayRenew);
	}
	
	@Test (priority = 11)
	@Parameters({"overlaySub"})
	public void OverlaySub(String overlaySub){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlaySub", overlaySub);
	}
	
	@Test (priority = 12)
	@Parameters({"smartCampaign"})
	public void SmartCampaign(String smartCampaign){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "smartCampaign", smartCampaign);
	}
    
	@Test (priority = 13)
	@Parameters({"toaster"})
	public void Toaster(String toaster){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "toaster", toaster);
	}
	
	@Test (priority = 14)
	@Parameters({"trust"})
	public void Trust(String trust){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "trust", trust);
	}
	
	@Test (priority = 15)
	@Parameters({"mppData"})
	public void MPPData(String mppData){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "mppData", mppData);
	}
        	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("End Test Case: " + "AdobeTokens_HomePage_LocationNotSpecified_TestCase");
		BaseTestObj.QuitBrowser();
		
		
	}
	  

}
