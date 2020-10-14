package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import com.thestar.base.Variables;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class RegistrationWall_TestCases {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.therecord.com") String url, @Optional("Not Required from Local") String name) throws Exception {
		System.out.println("Testing Basic Subscription Objects");
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
		BaseTestObj.BsLocal_Setup();
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		
	}

	@Test (priority = 0, description = "Checking of registration wall")

	public void regWall(){
		BaseTestObj.loadURL("Article page", BaseTestObj.baseUrl + ReadExternalData.article1);
		BaseTestObj.isEnabled(By.xpath(Variables.REG_WALL_PARAGRAPH_1.toString()));
		assertObjectsOnPagesObj.assertRegWall(BaseTestObj);

	}

	@Test (priority = 1, description = "Checking that there are no wall on free article")
	public void noRegWallFreeArticle(){
		BaseTestObj.loadURL("Free article", BaseTestObj.baseUrl + ReadExternalData.freeArticle);
		assertObjectsOnPagesObj.assertNoRegWall(BaseTestObj);
	}

	@Test (priority = 1, description = "Checking that there are no wall on out of wall page")
	public void noRegWallOnOutOfWallPage(){
		BaseTestObj.loadURL("Free article", BaseTestObj.baseUrl + ReadExternalData.faq);
		assertObjectsOnPagesObj.assertNoRegWall(BaseTestObj);
	}
	  
	@Test (priority = 3, description = "Checking that registration wall shown only to unregistered user", dependsOnMethods = "noRegWallFreeArticle")
	public void noRegWallRegisteredUser() {
		BaseTestObj.loadPage("Sign in", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordbasic);
		BaseTestObj.waitInSeconds(10);
		BaseTestObj.loadURL("Article 1", BaseTestObj.baseUrl + ReadExternalData.article1);
		assertObjectsOnPagesObj.assertMeterArticle(BaseTestObj);
								     
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase() throws Exception {
		System.out.println("Completed Testing Basic Subscription Objects");
		BaseTestObj.QuitBrowser();
		BaseTestObj.BsLocal_Close();
	}
	  

}
