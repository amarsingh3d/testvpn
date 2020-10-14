package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AmpPages_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	

	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://uat2.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Amp Pages");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		BaseTestObj.baseUrl = url ;
	}

	@Test (priority = 0)
	public void hardWallAMPPage(){
		System.out.println("Testing AMP hard wall");
		BaseTestObj.loadURL("Testing AMP hard wall",BaseTestObj.baseUrl + BaseTestObj.ampHardWallPage);
		assertObjectsOnPagesObj.assertAMPHardWall(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}
	
	@Test (priority = 0)
	public void slideShowAMPPage(){
		System.out.println(BaseTestObj + BaseTestObj.slideshowamppage);
		BaseTestObj.loadURL("Testing Slide Show Amp Page", BaseTestObj.baseUrl + BaseTestObj.slideshowamppage);
		assertObjectsOnPagesObj.assertAMPPageStarLogo(BaseTestObj);
		assertObjectsOnPagesObj.assertAMPPageSlideShow(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
					     
	}
	
	@Test (priority = 0, dependsOnMethods = "slideShowAMPPage")
	public void videoAMPPage(){
		BaseTestObj.loadURL("Testing Video Amp Page", BaseTestObj.baseUrl + BaseTestObj.videoamppage);
		assertObjectsOnPagesObj.assertAMPPageStarLogo(BaseTestObj);
		BaseTestObj.SwitchToFrame(0);
		assertObjectsOnPagesObj.assertAMPPageVideo(BaseTestObj);
		BaseTestObj.SwitchToDefaultContent();
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}
	
	@Test (priority = 1, dependsOnMethods = "videoAMPPage")
	public void editorialCartoonAMPPage(){
		BaseTestObj.loadURL("Testing Editorial Cartoon Amp Page", BaseTestObj.baseUrl + BaseTestObj.editorialcartoonamppage);
		assertObjectsOnPagesObj.assertAMPPageStarLogo(BaseTestObj);
		assertObjectsOnPagesObj.assertAMPPageEditorialCartoon(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}
	
	@Test (priority = 2, dependsOnMethods = "editorialCartoonAMPPage")
	public void articleAMPPage(){
		System.out.println("Testing Article Amp Page");
		BaseTestObj.loadPage("Testing Article Amp Page", BaseTestObj.baseUrl + BaseTestObj.articleamppage);
		assertObjectsOnPagesObj.assertAMPPageStarLogo(BaseTestObj);
		assertObjectsOnPagesObj.assertAMPPageArticle(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}

	@Test (priority = 0, dependsOnMethods = "articleAMPPage")
	public void normalPayWallAMP() {
		System.out.println("Testing AMP normal wall");
		BaseTestObj.loadPage("Open page five",BaseTestObj.baseUrl + BaseTestObj.ampPageFive);
		BaseTestObj.loadPage("Open page six",BaseTestObj.baseUrl + BaseTestObj.ampPageSix);
		BaseTestObj.loadPage("Page 7", BaseTestObj.baseUrl + "/amp/news/canada/2018/09/09/kitchener-woman-charged-with-slapping-officer-at-us-border.html");
		assertObjectsOnPagesObj.assertAMPNormalWall(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}

	@Test (priority = 4, dependsOnMethods = "normalPayWallAMP")
	public void socialSignInAMPWall() {
		System.out.println("Testing AMP normal wall");
		BaseTestObj.loadPage("Open page five",BaseTestObj.baseUrl + BaseTestObj.ampPageFive);
		BaseTestObj.loadPage("Open page six",BaseTestObj.baseUrl + BaseTestObj.ampPageSix);
		assertObjectsOnPagesObj.assertAMPNormalWall(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}

//	@Test (priority = 0)
//	public void HardWallAMPageGoogle(){
//		System.out.println("Testing AMP hard wall with ggogle");
//		BaseTestObj.loadPage("Testing AMP hard wall","https://www.google.ca/amp/s/www.thestar.com" + BaseTestObj.ampHardWallPage);
//		assertObjectsOnPagesObj.assertAMPHardWall(BaseTestObj);
//		BaseTestObj.findAndVerifyAnalyticsFrame();
//	}
//
//	@Test (priority = 0)
//	public void HTML5AMPPage(){
//		System.out.println("Testing AMP html5 component");
//		BaseTestObj.loadURL("Testing html5 ",BaseTestObj.baseUrl +  BaseTestObj.ampPageHTML5);
//		assertObjectsOnPagesObj.assertHTML5Component(BaseTestObj);
//		BaseTestObj.openHTML5Component();
//		assertObjectsOnPagesObj.assertHTML5ComponentExtended(BaseTestObj);
//	}

	@Test (priority = 0, dependsOnMethods = "normalPayWallAMP")
	public void AMPMenu(){
		BaseTestObj.loadURL("Testing html5 ",BaseTestObj.baseUrl +  BaseTestObj.ampPageHTML5);
		System.out.println("Testing AMP menu component");
		BaseTestObj.openAMPMenu();
		assertObjectsOnPagesObj.assertAMPSideBar(BaseTestObj);
	}


	@Test (priority = 5)
	public void Amp_Page_Validate(){
		System.out.println("Testing AMP page structure");
		BaseTestObj.loadURL("validate page structure",BaseTestObj.googleValidation);
		BaseTestObj.waitInSeconds(10);
		assertObjectsOnPagesObj.assertAMPPageValid(BaseTestObj);
		BaseTestObj.findAndVerifyAnalyticsFrame();
	}
    
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Amp Pages");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
