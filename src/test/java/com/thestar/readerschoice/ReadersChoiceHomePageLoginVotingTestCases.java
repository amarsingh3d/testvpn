package com.thestar.readerschoice;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ReadersChoiceHomePageLoginVotingTestCases{
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	String campaignUrl = "";

	@BeforeClass
	@Parameters({"browser", "user", "url", "signinpagexml"})
	public void FileReadBrowserLaunch(@Optional("Chrome") String browser, @Optional("Anonymous") String user,@Optional("http://northumberlandnews.com/readerschoice-northumberland/") String url, @Optional("http://northumberlandnews.com/user/login/") String signInPageXml) throws IOException, InterruptedException {
		System.out.println("Started Testing Voting Flow");
		campaignUrl = url;
		BaseTestObj.ReadObjectRepositoryXML(); 
		BaseTestObj.LaunchBrowserLocal(signInPageXml);
	}
	
		
	@Test (priority = 0)
   	public void Asserting_SignIn_To_Vote(){
		Assert.assertTrue(BaseTestObj.SignIn_To_Vote_SigninPage(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic));
		BaseTestObj.waitInSeconds(10);
		BaseTestObj.loadPage("Campaign url",campaignUrl);
	}
	
	@Test (dependsOnMethods = {"Asserting_SignIn_To_Vote"}, priority = 1)
   	public void Asserting_Voting(){
   			assertObjectsOnPagesObj.AssertVotingOpened(BaseTestObj);
	}
	
   	@Test (dependsOnMethods = {"Asserting_Voting"}, priority =  2)
	public void Category_Select(){
		BaseTestObj.isEnabled(By.linkText("Automotive"));
   		Assert.assertTrue(BaseTestObj.selectCategory());
   	}
   	
	@Test (dependsOnMethods = {"Asserting_Voting", "Category_Select"}, priority =  3)
	public void SubCategory_Select(){
		Assert.assertTrue(BaseTestObj.selectSubCategory());
   	}
	
	@Test (dependsOnMethods = {"Asserting_Voting", "SubCategory_Select"}, priority =  4)
	public void Clicking_Vote()  {
		Assert.assertTrue(BaseTestObj.clickVote());
   	}
	
	@Test (dependsOnMethods = {"Asserting_Voting", "Clicking_Vote"}, priority =  5)
	public void Asserting_User_Voted(){
		assertObjectsOnPagesObj.AssertReaderChoicePage_Login_Vote(BaseTestObj);
   	}
		  	  				
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed Voting Flow Testing");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
