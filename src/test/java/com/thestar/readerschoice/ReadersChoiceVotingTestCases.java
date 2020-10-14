package com.thestar.readerschoice;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ReadersChoiceVotingTestCases{
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	String campaignurl = "";
	
	@BeforeClass
	@Parameters({"browser", "user", "url"})
	public void FileReadBrowserLaunch(@Optional("Chrome") String browser, @Optional("Anonymous") String user, String url) throws IOException, InterruptedException {
		System.out.println("Started Testing Voting Flow");
		//BaseTestObj.ReadExcelxslsFile(0, 4, "RC_Urls.xlsx", "Master");
		campaignurl = url;
		BaseTestObj.ReadObjectRepositoryXML(); 
		BaseTestObj.LaunchBrowserLocal(campaignurl);
		System.out.println(campaignurl);
	}
	
		
   	@Test (priority = 0)
   	public void Asserting_Voting_Opened(){
   			assertObjectsOnPagesObj.AssertVotingOpened(BaseTestObj);
	}
	
   	@Test (dependsOnMethods = {"Asserting_Voting_Opened"}, priority =  1)
	public void Category_Select() {
   		//BaseTestObj.Select_Category();
   		Assert.assertTrue(BaseTestObj.selectCategory());
   	}
   	
	@Test (dependsOnMethods = {"Asserting_Voting_Opened", "Category_Select"}, priority =  2)
	public void SubCategory_Select() {
		Assert.assertTrue(BaseTestObj.selectSubCategory());
   	}
	
	@Test (dependsOnMethods = {"Asserting_Voting_Opened", "SubCategory_Select"}, priority =  3)
	public void Clicking_Vote() throws InterruptedException {
		Assert.assertTrue(BaseTestObj.clickVote());
   	}
	
	@Test (dependsOnMethods = {"Asserting_Voting_Opened", "Clicking_Vote"}, priority =  4)
	public void Clicking_Signin() throws InterruptedException {
		Assert.assertTrue(BaseTestObj.clickSignInVote());
   	}
	
	@Test (dependsOnMethods = {"Asserting_Voting_Opened", "Clicking_Signin"}, priority =  5)
	public void SignIn_To_Vote(){
		BaseTestObj.SignIn_To_Vote(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);
   	}
	
	@Test (dependsOnMethods = {"SignIn_To_Vote"}, priority =  6)
	public void Asserting_User_Voted() throws InterruptedException {
		assertObjectsOnPagesObj.AssertReaderChoicePage_Login_Vote(BaseTestObj);
   	}
		
		
		   					
		
   	  				
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed Voting Flow Testing");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
