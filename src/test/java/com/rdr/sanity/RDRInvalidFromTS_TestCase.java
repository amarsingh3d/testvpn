package com.rdr.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;
import java.net.MalformedURLException;

public class RDRInvalidFromTS_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("http://qa4.therecord.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Started Testing Invalid Page From TS");
		BaseTestObj.ReadObjectRepositoryXML(); 
		BaseTestObj.ReadObjectRepositoryXML_RDR();
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.RDR_InvalidFromTS, name);
		
	
	}
	
	@Test (priority = 0)
	
	public void InvalidFromTS(){
		
   		System.out.println("Starting Test Case: InvalidFromTS");
   		BaseTestObj.OpenCategoryBlueLabel();
   		assertObjectsOnPagesObj.AssertPageNotInvalid(BaseTestObj);
   		System.out.println("Ending Test Case: InvalidFromTS");

   	
	       
	}
	
	  	
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed Testing Invalid Page From TS");
		BaseTestObj.QuitBrowser();
		
	}
	  

}
