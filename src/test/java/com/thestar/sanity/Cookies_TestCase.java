package com.thestar.sanity;

import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class Cookies_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("http://prod-test.thestar.com:8080") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
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

	@Test (priority = 1, description = "Checking user cookies")
	public void durableCookiesTestIncognito(){
		BaseTestObj.loadPage("Article page", BaseTestObj.baseUrl + ReadExternalData.article3);
		BaseTestObj.waitInSeconds(10);
		BaseTestObj.getCookieByName("ts_s_ecid");
		System.out.println(BaseTestObj.getAllCookies());
		Assert.assertTrue(BaseTestObj.getCookieByName("s_ecid").contains("MCMID%"));
		BaseTestObj.deleteCookieByName("s_ecid");
		Assert.assertFalse(BaseTestObj.getCookieByName("s_ecid").contains("MCMID%"));
		Assert.assertFalse(BaseTestObj.getCookieByName("ts_userToken").contains("%"));

	}

	@Test (priority = 2, description = "Checking user cookies")
	public void durableCookiesTestSignedIn(){
		BaseTestObj.loadPage("Sign in page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);
		BaseTestObj.waitInSeconds(5);
		BaseTestObj.loadPage("", BaseTestObj.baseUrl + ReadExternalData.article3);
		BaseTestObj.waitInSeconds(15);
		System.out.println(BaseTestObj.getAllCookies());
		BaseTestObj.getCookieByName("userToken");
		BaseTestObj.getCookieByName("ts_userToken");
		BaseTestObj.getCookieByName("ts_s_ecid");
		Assert.assertTrue(BaseTestObj.getCookieByName("s_ecid").contains("MCMID%"));
		Assert.assertTrue(BaseTestObj.getCookieByName("ts_s_ecid").contains("MCMID%"));
		System.out.println(BaseTestObj.getAllCookies());
		System.out.println("Ending Test Case: durableCookiesTest");
	}

	@Test (priority = 2, description = "Checking user cookies")
	public void restoreDurableCookiesFromTs(){
 		String ts_s_ecid = BaseTestObj.getCookieValueByName("ts_s_ecid");
		BaseTestObj.deleteCookieByName("s_ecid");
		BaseTestObj.loadPage("Sign in page", BaseTestObj.baseUrl + BaseTestObj.signinpage);
		BaseTestObj.SignIn(BaseTestObj.usernamereg, BaseTestObj.passwordreg);
		BaseTestObj.loadPage("", BaseTestObj.baseUrl + ReadExternalData.article3);
		BaseTestObj.waitInSeconds(15);
		BaseTestObj.getCookieByName("s_ecid");
		BaseTestObj.getCookieByName("ts_s_ecid");
		Assert.assertEquals(BaseTestObj.getCookieValueByName("s_ecid"), ts_s_ecid);
		System.out.println("Ending Test Case: durableCookiesTest");
	}

	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing of durable cookies");
		BaseTestObj.QuitBrowser();
		
	}

}
