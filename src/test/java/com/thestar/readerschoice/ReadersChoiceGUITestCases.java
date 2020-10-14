package com.thestar.readerschoice;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.io.IOException;

public class ReadersChoiceGUITestCases{
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	String campaignurl = "";
	
	@BeforeClass
	@Parameters({"browser", "user", "url"})
	public void FileReadBrowserLaunch(@Optional("Firefox") String browser, @Optional("Anonymous") String user, String url) throws IOException {
		System.out.println("Started Testing Readers Choice Login Test");
		//BaseTestObj.ReadExcelxslsFile(0, 4, "RC_Urls.xlsx", "Master");
		campaignurl = url;
		BaseTestObj.LaunchBrowserLocal_Firefox(campaignurl);
		System.out.println(campaignurl);

	}
	
		
   	@Test (priority = 0)
	
	public void Brand_Logo(){
   		
   		//for (int i = 0; i<=4; i++)
		//{
			//BaseTestObj.row = BaseTestObj.excelSheet.getRow(i);
			//String url = BaseTestObj.row.getCell(0).getStringCellValue();
			//System.out.println(url);
			//BaseTestObj.LaunchBrowserLocal(url);
   			System.out.println("Asserting Brand Logo on RC Page");
   			assertObjectsOnPagesObj.AssertBrandLogo(BaseTestObj);
			//BaseTestObj.QuitBrowser();
			//System.out.println(BaseTestObj.row.getCell(2).getStringCellValue());
				
		}
   	
  	@Test (priority = 1)
	
	public void Readers_Choice_Logo(){
  			System.out.println("Asserting RC Logo on RC Page");
   			assertObjectsOnPagesObj.AssertRCLogo(BaseTestObj);
					
		}
		
 	@Test (priority = 2)
	
	public void Signin_Button(){
 			System.out.println("Asserting Sign in Button on RC Page");
   			assertObjectsOnPagesObj.assertSignInButton(BaseTestObj);
					
		}
   		
// 	@Test (priority = 3)
//
//	public void Previous_Winners_Link(){
// 			System.out.println("Asserting Previous Winners Link on RC Page");
//   			assertObjectsOnPagesObj.AssertPrevousWinners(BaseTestObj);
//
//		}
 	
 	@Test (priority = 4)
	
	public void FAQ_Link(){
 			System.out.println("Asserting FAQ Link on RC Page");
   			assertObjectsOnPagesObj.AssertFAQ(BaseTestObj);
					
		}
 	
	@Test (priority = 5)
	
	public void Privacy_Policy_Link(){
			System.out.println("Asserting Privacy Policy Link on RC Page");
   			assertObjectsOnPagesObj.AssertPrivacyPolicy(BaseTestObj);
					
		}
	
	@Test (priority = 6)
	
	public void TermsAndConditions_Link(){
			System.out.println("Asserting Terms and Conditions Link on RC Page");
   			assertObjectsOnPagesObj.AssertTandC(BaseTestObj);
					
		}
	
	@Test (priority = 7)
	
	public void Leader_Board(){
			System.out.println("Asserting Leader Board on RC Page");
   			assertObjectsOnPagesObj.AssertLeaderBoard(BaseTestObj);
					
		}

	
   	@Test (priority =  9)
	
	public void Business_Search_Box(){
   		    System.out.println("Asserting Business Search Box on active campaign of RC Page");
   			assertObjectsOnPagesObj.AssertBusinessSearchBox(BaseTestObj);
						
		}
   	
  	@Test (priority = 10)
	
	public void Automotive(){
   			assertObjectsOnPagesObj.AssertAutomotive(BaseTestObj);
					
		}
		
 	@Test (priority = 11)
	
	public void Entertainment(){
   			assertObjectsOnPagesObj.AssertEntertainment(BaseTestObj);
					
		}
   		
 	@Test (priority = 12)
	
	public void Food_Drink_Grocery(){
   			assertObjectsOnPagesObj.AssertFood_Drink_Grocery(BaseTestObj);
					
		}
 	
 	@Test (priority = 13)
	
	public void Health_Wellness_Fitness_Beauty(){
   			assertObjectsOnPagesObj.AssertHealth_Fitness_Wellness_Beauty(BaseTestObj);
					
		}
 	
	@Test (priority = 14)
	
	public void Home_HomeImprovment(){
   			assertObjectsOnPagesObj.AssertHome_HomeImprovement(BaseTestObj);
					
		}
	
	@Test (priority = 15)
	
	public void People_Professionals(){
   			assertObjectsOnPagesObj.AssertPeople_Professionals(BaseTestObj);
					
		}
	
	@Test (priority = 16)
	
	public void ProfessionalServices(){
   			assertObjectsOnPagesObj.AssertProfessionalServices(BaseTestObj);
					
		}
	
	@Test (priority = 17)
	
	public void Restaurant(){
   			assertObjectsOnPagesObj.AssertRestaurant(BaseTestObj);
					
		}
	
	@Test (priority = 18)
	
	public void Shopping(){
   			assertObjectsOnPagesObj.AssertShopping(BaseTestObj);
					
		}
	
	@Test (priority = 20)
	
	public void SubCategory_BrandLogo(){
			System.out.println("Asserting Brand Logo on Sub Category Page");
			assertObjectsOnPagesObj.AssertBrandLogo(BaseTestObj);
					
		}
	
	@Test (priority = 21)
	
	public void SubCategory_RCLogo(){
			System.out.println("Asserting RC Logo on Sub Category Page");
			assertObjectsOnPagesObj.AssertSubCategoryRCLogo(BaseTestObj);
					
		}
	
	@Test (priority = 22)
	
	public void SubCategory_Signin(){
			System.out.println("Asserting Sign in Button on Sub Category Page");
			assertObjectsOnPagesObj.assertSignInButton(BaseTestObj);
					
		}
	
	@Test (priority = 24)
	
	public void SubCategory_Search_Box(){
			System.out.println("Asserting Business Search Box on active campaign of Sub Category Page");
			assertObjectsOnPagesObj.AssertBusinessSearchBox(BaseTestObj);
					
		}
	
//	@Test (priority = 25)
//
//	public void SubCategory_Previous_Winners_Link(){
//			System.out.println("Asserting Previous Winners Link on Sub Category Page");
//			assertObjectsOnPagesObj.AssertPrevousWinners(BaseTestObj);
//
//		}
	
	@Test ( priority = 26)
	
	public void SubCategory_FAQ_Link(){
			System.out.println("Asserting FAQ Link on Sub Category Page");
			assertObjectsOnPagesObj.AssertFAQ(BaseTestObj);
								
		}
	
	@Test ( priority = 27)
	
	public void SubCategory_Privacy_Policy_Link(){
			System.out.println("Asserting Privacy Policy Link on Sub Category Page");
			assertObjectsOnPagesObj.AssertPrivacyPolicy(BaseTestObj);
								
		}
	
	@Test (priority = 28)
	
	public void SubCategory_TermsAndConditions_Link(){
			System.out.println("Asserting Terms and Conditions Link on Sub Category Page");
			assertObjectsOnPagesObj.AssertTandC(BaseTestObj);
								
		}
	
	@Test (priority = 31)
	
	public void SubCategory_Leader_Board(){
			System.out.println("Asserting Leader Board on Sub Category Page");
			assertObjectsOnPagesObj.AssertSubCategoryLeaderBoard(BaseTestObj);
								
		}
   				
	@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed RC URLs");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
