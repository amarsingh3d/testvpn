package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

public class AdobeTokensHomePageLocationSpecified_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome_Console") String browser, @Optional("") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Start Test Case: " + "AdobeTokensHomePageLocationSpecified_TestCase");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.VancouverHome, name);
		BaseTestObj.Reading_AdobeTokensFromConsoleData();
	
		
	}
	
	@Test (priority = 0)
	public void PageType(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "pageType", "pageType=home");
	}
	
	@Test (priority = 1)
	public void Channel(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "channel", "channel=home");
	}
	
	@Test (priority = 2)
	public void Template(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "template", "template=home-v1");
	}
	
	@Test (priority = 3)
	public void Location(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "location", "location=vancouver");
	}
	
	@Test (priority = 4)
	public void SiteDomain(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "siteDomain", "siteDomain=thestar.com");
	}
	
	@Test (priority = 5)
	public void Commenting(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "commenting", "commenting");
	}
	
	@Test (priority = 6)
	public void Locked(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "locked", "locked");
	}
	
	@Test (priority = 7)
	public void Metered(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "metered", "metered");
	}
	
	@Test (priority = 8)
	public void MobileInlay(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "mobileInlay", "mobileInlay");
	}
	
	@Test (priority = 9)
	public void Overlay(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlay", "overlay");
	}
	
	@Test (priority = 10)
	public void OverlayRenew(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlayRenew", "overlayRenew");
	}
	
	@Test (priority = 11)
	public void OverlaySub(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "overlaySub", "overlaySub");
	}
	
	@Test (priority = 12)
	public void SmartCampaign(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "smartCampaign", "smartCampaign");
	}
    
	@Test (priority = 13)
	public void Toaster(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "toaster", "toaster");
	}
	
	@Test (priority = 14)
	public void Trust(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "trust", "trust");
	}
	
	@Test (priority = 15)
	public void MPPData(){
		
		assertObjectsOnPagesObj.assertAdobeTokenProperty(BaseTestObj, "mppData", "mppData");
	}
        	
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase() {
		System.out.println("End Test Case: " + "AdobeTokensHomePageLocationSpecified_TestCase");
		BaseTestObj.QuitBrowser();
		
		
	}
	  

}
