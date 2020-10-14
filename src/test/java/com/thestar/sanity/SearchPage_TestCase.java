package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SearchPage_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages AssertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
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
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url, name);
		
	}

	@Test (priority = 0)
	public void SearchInputTest() {
		BaseTestObj.openSearch();
		AssertObjectsOnPagesObj.asertSearchInput(BaseTestObj);

	}

	@Test (priority = 1, dependsOnMethods = "SearchInputTest")
	public void SearchTest() {
		BaseTestObj.searchText("Testing");
		BaseTestObj.assertSearchURL(BaseTestObj.baseUrl +"/search.html?q=Testing");
		AssertObjectsOnPagesObj.asertSearchPage(BaseTestObj);
	}

	@Test (priority = 2, dependsOnMethods = "SearchInputTest")
	public void SearchSortingTest() {
		AssertObjectsOnPagesObj.asertSortResults(BaseTestObj);
		BaseTestObj.sortSearchOldest();
		BaseTestObj.sortSearchRelevance();
		BaseTestObj.sortSearchNewest();
	}


	@Test (priority = 4, dependsOnMethods = "SearchSortingTest")
	public void SearchFilterAuthor() {
		AssertObjectsOnPagesObj.asertFilterAuthor(BaseTestObj);
	}

	@Test (priority = 3, dependsOnMethods = "SearchFilterAuthor")
	public void SearchFilterContentType() {
		AssertObjectsOnPagesObj.asertFilterContent(BaseTestObj);
		BaseTestObj.filterVideo();
		BaseTestObj.filterPhoto();
		BaseTestObj.filterVideoPhoto();
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing REG-199");  
		BaseTestObj.QuitBrowser();
		
	}

}
