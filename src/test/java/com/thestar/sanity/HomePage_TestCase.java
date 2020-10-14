package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.Variables;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class HomePage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://www.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Home Page");
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
	public void Grey_Banner(){
		assertObjectsOnPagesObj.assertTopHatContainer(BaseTestObj);
			     
	}
	 

	@Test (priority = 1)
	public void Subscribe_Button(){
		BaseTestObj.niagaraSkipTest(BaseTestObj.baseUrl);
		BaseTestObj.isWellandtribuneSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertSubscribeButton(BaseTestObj);
		
	}
	  
	
	@Test (priority = 2)
	public void Toaster(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertToaster(BaseTestObj);
	      
	}
	  
	@Test (priority = 3, description = "Checking that logo present on page")
	public void instance_logo_block(){
		
		assertObjectsOnPagesObj.AssertTheStarLogo(BaseTestObj);
	      
	}
	
	@Test (priority = 4)
	public void alertBanner(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		BaseTestObj.isEnabled(By.xpath(".alert-banner-container__alert-banner-category"));
		assertObjectsOnPagesObj.AssertAlertBanner(BaseTestObj);
	      
	}
	
	@Test (priority = 5)
	public void bannerListHeader(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		BaseTestObj.isEnabled(By.xpath(Variables.NEWSLETTER_ICON_HOME_PAGE.toString()));
		assertObjectsOnPagesObj.assertBannerListHeader(BaseTestObj);

	}

	@Test (priority = 7)
	public void Search_Option(){
		
		assertObjectsOnPagesObj.AssertSearchOption(BaseTestObj);
	      
	}
	
	@Test (priority = 8)
	public void SignIn_Button(){
		
		assertObjectsOnPagesObj.AssertSignIn_Button(BaseTestObj);
	      
	}
	
	@Test (priority = 9)
	public void ChangeLocation_Icon(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertChangeLocationIcon(BaseTestObj);
	      
	}
	
	@Test (priority = 10)
	public void ChangeLocation_Text(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertChangeLocationText(BaseTestObj);
	      
	}
		
//	@Test (priority = 11)
//	public void Opinion(){
//		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
//		assertObjectsOnPagesObj.AssertOpinion(BaseTestObj);
//
//	}


	@Test (priority = 12)
	public void rightRailSection(){

		assertObjectsOnPagesObj.assertRightRail(BaseTestObj);

	}
	
	@Test (priority = 13)
	public void SocialIcons(){
		
		assertObjectsOnPagesObj.AssertSocialIcons(BaseTestObj);
	      
	}
	
	@Test (priority = 14)
	public void AppStoreIcon(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertAppStoreIcon(BaseTestObj);
	      
	}
	
	@Test (priority = 15)
	public void PlayStoreIcon(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.AssertPlayStoreIcon(BaseTestObj);
	      
	}
	
	@Test (priority = 16)
	public void PrivacyPolicy(){
		
		assertObjectsOnPagesObj.AssertPrivacyPolicy(BaseTestObj);
	      
	}

	@Test (priority = 17)
	public void mediaCard(){
		BaseTestObj.isRDRSkip(BaseTestObj.baseUrl);
		assertObjectsOnPagesObj.assertMediaCard(BaseTestObj);

	}
	
	@Test (priority = 18)
	public void CopyrightText(){
		
		assertObjectsOnPagesObj.AssertCopyrightText(BaseTestObj);
	      
	}
	
	@Test (priority = 19)
	public void AddressText(){
		assertObjectsOnPagesObj.AssertAddressText(BaseTestObj);
	      
	}

	@Test (priority = 19, description = "Check that marketing Panel present on home page and all required filed are there")
	public void MarketingPanel(){
		BaseTestObj.isEnabled(By.xpath("//strong[@class='c-engagement-panel__card-title']"));
		assertObjectsOnPagesObj.AssertMarketingPanel(BaseTestObj);

	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Home Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
