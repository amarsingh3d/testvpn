package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class CitiesLocalPage_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Cities & Home Page");
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl + BaseTestObj.signinpage, name);
		BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
	}

	@Test (priority = 0, description = "Checking Reader Choice Awards Tab")
	public void TheStarEditionDropDown(){
		BaseTestObj.waitInSeconds(10);
		assertObjectsOnPagesObj.AssertTheStarEditionDropDown(BaseTestObj.CityDropDown());
     	     
	}
	
	@Test (dependsOnMethods = {"TheStarEditionDropDown"}, priority = 1)
	public void CitiesInDropDown(){
		assertObjectsOnPagesObj.AssertCitiesInDropDown(BaseTestObj);

	}
	
	@Test (dependsOnMethods = {"TheStarEditionDropDown"}, priority = 2)
	public void TorontoLocal() {
		BaseTestObj.selectToronto();
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Toronto", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"TorontoLocal"}, priority = 3)
	public void VancouverLocal() {
		
		System.out.println("By Passed Vancouver due to Renew Overlay");
		BaseTestObj.SelectLocation("Vancouver");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Vancouver", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"VancouverLocal"}, priority = 4)
	public void CalgaryLocal() {
		BaseTestObj.refreshPage();
		BaseTestObj.refreshPage();
//		AssertObjectsOnPages.AssertOverlay(BaseTestObj);
//		BaseTestObj.subscriptionOverlayIsShown();
		BaseTestObj.SelectLocation("Calgary");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Calgary", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"CalgaryLocal"}, priority = 5)
	public void EdmontonLocal() {
		  
		BaseTestObj.SelectLocation("Edmonton");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Edmonton", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"EdmontonLocal"}, priority = 6)
	public void WinnipegLocal() {
		  
		BaseTestObj.SelectLocation("Winnipeg");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Winnipeg", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"WinnipegLocal"}, priority = 7)
	public void OttawaLocal() {
		  
		BaseTestObj.SelectLocation("Ottawa");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Ottawa", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@Test (dependsOnMethods = {"OttawaLocal"}, priority = 8)
	public void HalifaxLocal() {
		  
		BaseTestObj.SelectLocation("Halifax");
		BaseTestObj.SelectCategory("Local");
		assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Halifax", BaseTestObj, BaseTestObj.baseUrl);
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Cities & Home Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
