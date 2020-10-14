package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BlueUnderline_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing BlueUnderline TestCase");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.blueLine, name);
	}
	
	
   	@Test (priority = 0)
	public void Asserting_URL_Border_Color() {
   		System.out.println("Asserting Underline Color of Link Text");
   		assertObjectsOnPagesObj.assertBorderColorText(BaseTestObj);
	       
	}
   	
	@Test (dependsOnMethods = {"Asserting_URL_Border_Color"}, priority = 1)
   	public void Asserting_URL_MouseOver_Color(){
		
   		System.out.println("Asserting Background Color of Link Text When Mouse Over");
   		BaseTestObj.waitInSeconds(10);
   		BaseTestObj.scrollPage(0,1600);
   		BaseTestObj.BlueLinePage();
   		assertObjectsOnPagesObj.assertBackgroundColorText(BaseTestObj);
	       
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing BlueUnderline TestCase");
		BaseTestObj.QuitBrowser();
		
	}
	  

}
