package com.thestar.sanity;

import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class SetupBrowserLocalServer {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("http://localhost:45454/") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
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
	}
	
	
   	@Test (priority = 0)
	public void SetKey() throws Exception {
		BaseTestObj.BsLocal_Setup();
		BaseTestObj.waitInSeconds(10);
		BaseTestObj.setup(BaseTestObj);
		BaseTestObj.waitInSeconds(10);
	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Home Page");  
		BaseTestObj.QuitBrowser();
		BaseTestObj.waitInSeconds(5);
	}
	  

}
