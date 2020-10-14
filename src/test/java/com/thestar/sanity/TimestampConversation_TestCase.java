package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class TimestampConversation_TestCase {
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("TIMESTAMP TESTING");
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
	
	
   	@Test (priority = 0)
	
	public void TimeStamp_ConversationWidget(){
   		System.out.println("Conversation Page Check");
   		BaseTestObj.loadURL("Page With Conversation Widget", BaseTestObj.baseUrl+BaseTestObj.conversationpage );
   		assertObjectsOnPagesObj.AssertConversationWidget(BaseTestObj);
   		
	}
   	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		BaseTestObj.QuitBrowser();
		
	}
	  

}
