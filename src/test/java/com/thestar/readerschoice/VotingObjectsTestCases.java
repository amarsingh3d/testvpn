package com.thestar.readerschoice;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class VotingObjectsTestCases{
	
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	//@Parameters({"browser", "user", "url"})
	public void FileReadBrowserLaunch() throws IOException {
		System.out.println("Started Testing Readers Choice Login Test");
		//BaseTestObj.ReadExcelxslsFile(0, 4, "RC_Urls.xlsx", "Master");
		BaseTestObj.LaunchBrowserLocal("https://www.guelphmercury.com/readerschoice/");
		//System.out.println(url);

	}
	
		
   	@Test (priority = 0)
	
	public void Business_Search_Box(){
   		
   			assertObjectsOnPagesObj.AssertBusinessSearchBox(BaseTestObj);
						
		}
   	
  	@Test (priority = 1)
	
	public void Automotive(){
   			assertObjectsOnPagesObj.AssertAutomotive(BaseTestObj);
					
		}
		
 	@Test (priority = 2)
	
	public void Entertainment(){
   			assertObjectsOnPagesObj.AssertEntertainment(BaseTestObj);
					
		}
   		
 	@Test (priority = 3)
	
	public void Food_Drink_Grocery(){
   			assertObjectsOnPagesObj.AssertFood_Drink_Grocery(BaseTestObj);
					
		}
 	
 	@Test (priority = 4)
	
	public void Health_Wellness_Fitness_Beauty(){
   			assertObjectsOnPagesObj.AssertHealth_Fitness_Wellness_Beauty(BaseTestObj);
					
		}
 	
	@Test (priority = 5)
	
	public void Home_HomeImprovment(){
   			assertObjectsOnPagesObj.AssertHome_HomeImprovement(BaseTestObj);
					
		}
	
	@Test (priority = 6)
	
	public void People_Professionals(){
   			assertObjectsOnPagesObj.AssertPeople_Professionals(BaseTestObj);
					
		}
	
	@Test (priority = 7)
	
	public void ProfessionalServices(){
   			assertObjectsOnPagesObj.AssertProfessionalServices(BaseTestObj);
					
		}
	
	@Test (priority = 8)
	
	public void Restaurant(){
   			assertObjectsOnPagesObj.AssertRestaurant(BaseTestObj);
					
		}
	
	@Test (priority = 9)
	
	public void Shopping(){
   			assertObjectsOnPagesObj.AssertShopping(BaseTestObj);
					
		}
	
	
		@AfterTest  
	public void TerminateTestCase(){
		System.out.println("Completed RC URLs");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
