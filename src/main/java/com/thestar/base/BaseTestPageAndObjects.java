package com.thestar.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;


public class BaseTestPageAndObjects extends BaseTest {
	
	   public void premiumWall(){
		  
		 System.out.println("Start Loading: Article with Premium Wall");
		 driver.get(articlePremiumwall);
		 System.out.println("End Loading: Article with Premium Wall");
	  
	   }
	   
	   	   
	   public void SignIn(String username, String password) {
		   wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id(Variables.SIGN_IN_EMAIL_INPUT.toString())));
		   driver.findElement(By.id(Variables.SIGN_IN_EMAIL_INPUT.toString())).sendKeys(username);
		   driver.findElement(By.id(Variables.SIGN_IN_PASSWORD_INPUT.toString())).sendKeys(password);
		   driver.findElement(By.id(Variables.SIGN_IN_BUTTON.toString())).click();
		   System.out.println("Sign in Button Clicked");
		   wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.PODCASTS_ICON_HOME_PAGE.toString())));
	   }
	   
	   
	   public void SubscribeNewsLetterExistingUser(){
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		   driver.findElement(By.name("email")).sendKeys("regtest@yopmail.com");
		   wait20.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='MuiButton-label']")));
		   hover(driver.findElement(By.xpath("//span[@class='MuiButton-label']")));
		   System.out.println("Email Address Entered");
		   waitInSeconds(5);
	
	   }
	   
	   public void SubscribeNewsLetter()  {
		   System.out.println("Start: Selecting All Morning Headlines");
		   wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEWSLETTER_SELECT_ALL.toString())));
		   driver.findElement(By.xpath(Variables.NEWSLETTER_SELECT_ALL.toString())).click();
		   System.out.println("End: Selecting All Morning Headlines");
	   }

	public void UnsubscribeNewsLetter()  {
		System.out.println("Start: Deselecting All Morning Headlines");
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEWSLETTER_DESELECT_ALL.toString())));
		driver.findElement(By.xpath(Variables.NEWSLETTER_DESELECT_ALL.toString())).click();
		System.out.println("End: Deselecting All Morning Headlines");
	}
	   
	   public Boolean selectCategory() {
			
		   Boolean methodexecuted = false;
		   System.out.println("Selecting Category");
		   wait5.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Automotive")));
		   driver.findElement(By.linkText("Automotive")).click();
		   System.out.println("Selected Category");
		   return methodexecuted = true;
		 			  
	   }
	   
	   public Boolean selectSubCategory() {
			
		   Boolean methodexecuted = false;
		   System.out.println("Selecting Sub Category");
		   wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sc-bdVaJa:nth-child(1) > .styled__SubcategoryList-qt31fz-1 > li:nth-child(1) > .styled__SubcategoryLink-qt31fz-2")));
		   driver.findElement(By.cssSelector(".sc-bdVaJa:nth-child(1) > .styled__SubcategoryList-qt31fz-1 > li:nth-child(1) > .styled__SubcategoryLink-qt31fz-2")).click();
		   System.out.println("Selected Sub Category");
		   return methodexecuted = true;
		   
		 			  
	   }
	   
	   public Boolean clickVote() {
			
		   Boolean methodexecuted = false;
		   System.out.println("Clicking Vote");
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']")));
		   waitInSeconds(2);
		   driver.findElement(By.xpath("//button[@type='button']")).click();
		   System.out.println("Clicked Vote");
		   return methodexecuted = true;

	   }  
	   
	   public Boolean clickSignInVote() {
		   
		   Boolean methodexecuted = false;
		   campaignwindowhandler = driver.getWindowHandle();
		   System.out.println("Click sign in for Vote");
		   wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[4]")));
		   driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		   waitInSeconds(5);
		   System.out.println("Clicked signed in for Vote");
		   signinwindowhandler = driver.getWindowHandles();
		   i1= signinwindowhandler.iterator();
		   System.out.println("Campaign window handler " + campaignwindowhandler);
		   System.out.println("Sign in window handler " + signinwindowhandler);
		   return methodexecuted = true;
		   
		   
	   }

	   public void subscriptionOverlayIsShown() {
		   System.out.println("Waiting for subscription overlay");

		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-lpos='meter|overlay']")));
		   System.out.println("Subscription overlay found");
		   driver.navigate().refresh();
		   waitInSeconds(5);
	   }
	   
	   public void SelectLocation(String city) {
		   String locationIdentifier = "";
		   System.out.println("Clicking Location Options");
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".o-nav-location-desktop .o-two-row-paragraph:nth-child(1")));
		   driver.findElement(By.cssSelector(".o-nav-location-desktop .o-two-row-paragraph:nth-child(1")).click();
		   System.out.println("Location Options Clicked");
		   System.out.println("Selecting Location");
		   switch (city) {
				
		  	case "Vancouver":
				locationIdentifier = "//button[contains(text(),'Vancouver')]";
				break;
				
		  	case "Calgary":
				locationIdentifier = "//button[contains(text(),'Calgary')]";
				break;
				
		  	case "Edmonton":
				locationIdentifier = "//button[contains(text(),'Edmonton')]";
				break;
				
		  	case "Winnipeg":
				locationIdentifier = "//button[contains(text(),'Winnipeg')]";
				break;
				
		  	case "Ottawa":
				locationIdentifier = "//button[contains(text(),'Ottawa')]";
				break;
				
		  	case "Halifax":
				locationIdentifier = "//button[contains(text(),'Halifax')]";
				break;
		   }
		   
		   System.out.println("Selecting " + city);
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locationIdentifier)));
		   driver.findElement(By.xpath(locationIdentifier)).click();
		   waitInSeconds(10);
		   System.out.println("Selected " + city);
	   }
		   
	   public void SelectCategory(String category){
			   
			   String categoryIdentifier = "";
			   switch (category) {
			   	case "Local":
			   		categoryIdentifier = "//span[contains(text(),'local')]";
			   		break;
				   
				case "Sports":
					categoryIdentifier = "//span[contains(text(),'sports')]";
					break;
				
				case "Politics":
					categoryIdentifier = "//span[contains(text(),'politics')]";
					break;	
					
					
			   }	
			   
			   System.out.println("Selecting " + category);
			   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryIdentifier)));
			   driver.findElement(By.xpath(categoryIdentifier)).click();
			  waitInSeconds(10);
			   System.out.println("Selected " + category);
			  
	  
	   }
	   
	   
	   public void selectSubCategory(String subcategory) {
		   
		   String subcategoryIdentifier = "";
		   switch (subcategory) {
		   	case "Provincial Politics":
		   		subcategoryIdentifier = "//*[@id=\"app\"]/div/div[8]/div/ul/li[2]/a/span";
		   			   			   	
		   		break;
				
		   }	
		   
		   System.out.println("Selecting " + subcategory);
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subcategoryIdentifier)));
		   driver.findElement(By.xpath(subcategoryIdentifier)).click();
		   waitInSeconds(3);
		   System.out.println("Selected " + subcategory);
  
	   }
	   
	   public String Page_URL(String URLFor, String baseUrl) {
		  
		    String expectedURL = "";
			switch (URLFor) {
				case "Toronto":
			   		expectedURL = baseUrl + torontopage;
			   		break;
			   		
				case "Vancouver":
			   		expectedURL = baseUrl + vancouverpage;
			   		break;
			   		
				case "Calgary":
			   		expectedURL = baseUrl + calgarypage;
			   		break;
			   		
				case "Edmonton":
			   		expectedURL = baseUrl + edmontonpage;
			   		break;
			   		
				case "Winnipeg":
			   		expectedURL = baseUrl + winnipegpage;
			   		break;
			   		
				case "Ottawa":
			   		expectedURL = baseUrl + ottawapage;
			   		break;
			   		
				case "Halifax":
			   		expectedURL = baseUrl + halifaxpage;
			   		break;
				
				case "ReaderChoice":
			   		expectedURL = baseUrl + rcpage;
			   		break;
				   
				case "Sports":
					expectedURL = baseUrl + sportspageurl;
					break;
					
				case "Politics":
					expectedURL = baseUrl + politicspageurl;
					break;
					
				case "Provincial Politics":
					expectedURL = baseUrl + provincialpoliticspageurl;
					break;	
				
				
		   }	
		   
		   return expectedURL;
	   }

	   
	   public void newValueEmailField(){
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.EXPRESS_CHECKOUT_EMAIL_INPUT.toString())));
		   driver.findElement(By.xpath(Variables.EXPRESS_CHECKOUT_EMAIL_INPUT.toString())).sendKeys("newvalue");
			waitInSeconds(5);
		   }
	   
	   	   
	   public String createNewYopMailEmail() {
		   
		     System.out.println("Creating New Email");
		   	 String newEmail =  RandomStringUtils.randomAlphanumeric(10);
		     String fullNewEmail = newEmail + "torstartest@yopmail.com";
		     System.out.println("New Email ID is " + fullNewEmail);
		   	 return fullNewEmail;
				    
	   }
	   
	   public String createNewMailinatorEmail() {
		   	 String newEmail =  RandomStringUtils.randomAlphanumeric(10);
		     String fullNewEmail = newEmail + "torstartest@mailinator.com";
		     System.out.println("New Email ID is " + fullNewEmail);
		   	 return fullNewEmail;
				    
	   }
	   
	   
	   public void expressCheckoutPage(String email) {
		  	 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
			 driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button")));
			 driver.findElement(By.cssSelector("button")).click();
			    
	   }

		public void expressCheckoutPageExistingUser() {

		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button")));
		driver.findElement(By.cssSelector("button")).click();

		}
	   
	   public void paymentPage() {
		   
		     System.out.println("Filling Payment Details");
		   
		  	 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("number")));
			 driver.findElement(By.id("number")).sendKeys("4111 1111 1111 1111");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("expiryMonth")));
		     Select select = new Select(driver.findElement(By.id("expiryMonth")));
		     select.selectByValue("string:03");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("expiryYear")));
		     Select selectYear = new Select(driver.findElement(By.id("expiryYear")));
		     selectYear.selectByValue("string:2029");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("securityCode")));
			 driver.findElement(By.id("securityCode")).sendKeys("486");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalZipCode")));
			 driver.findElement(By.id("postalZipCode")).sendKeys("A1A 1A1");
			 
			 System.out.println("Filled Payment Details");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkReadAndAgree")));
			 driver.findElement(By.id("chkReadAndAgree")).click();
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidBtnStartSubscription")));
			 driver.findElement(By.id("hidBtnStartSubscription")).click();
	   }
	   
	   public Boolean payPal(){
		   	 Boolean PayPalSignIn = false;
		     System.out.println("Making Payment with PayPal");
		     
		     mainwindowhandler = driver.getWindowHandle();
		   
		     System.out.println("Selecting PayPal Option");
		     waitInSeconds(3);
		     wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(2) .radio-payment-label")));
			 driver.findElement(By.cssSelector("li:nth-child(2) .radio-payment-label")).click();
			 waitInSeconds(3);
			 System.out.println("PayPal Option Selected");
			 
			
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalZipCodePayPal")));
		     driver.findElement(By.id("postalZipCodePayPal")).clear();
			 driver.findElement(By.id("postalZipCodePayPal")).sendKeys("A1A 1A1");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkReadAndAgree")));
			 driver.findElement(By.id("chkReadAndAgree")).click();
			 
			 waitInSeconds(5);
			 
			 Integer size = driver.findElements(By.tagName("iframe")).size();
			 
			 System.out.println("Size of frames = " + size);
			 
			 for (int i = 0; i<size;)
			 {	 
				 System.out.println("Switching to Frame " + i);
				 driver.switchTo().frame(i);
				 System.out.println("Switched to Frame " + i);
				 driver.manage().timeouts().implicitlyWait(impwait5, TimeUnit.SECONDS);
				try {
				 driver.findElement(By.cssSelector(".paypal-button")).isDisplayed();
				 	 
					 System.out.println("PayPal Button Found");
					 driver.findElement(By.cssSelector(".paypal-button")).click();
					 System.out.println("Pay With PayPal Clicked");
					 childindowhandler = driver.getWindowHandles();
					 i1= childindowhandler.iterator();
					 System.out.println("PayPal Button Clicked");
					 System.out.println("Main window handler " + mainwindowhandler);
					 System.out.println("Child window handler " + childindowhandler);
					 System.out.println("Loading PayPal Sign In Page");
					 PayPalSignIn = true;
					 break;
				
				 }
				 catch (NoSuchElementException e) {
					 System.out.println("Pay Pal Button not found");
					 i++;
				 }
				 
			 }
			 
			 return PayPalSignIn;
					 			 			    
	   }
	   
	   public Boolean profilePage() {
		   
		     Boolean MethodExecuted = false;
		     System.out.println("Filling Profile Page");
		     wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='postalCode']")));
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
			 driver.findElement(By.xpath("//input[@name='firstName']")).clear();
			 driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Testing");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastName']")));
		   	 driver.findElement(By.xpath("//input[@name='lastName']")).clear();
			 driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("User");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
			 driver.findElement(By.xpath("//input[@name='password']")).clear();
			 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("avatar123");
			 
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='confirmPassword']")));
		     driver.findElement(By.xpath("//input[@name='confirmPassword']")).clear();
			 driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("avatar123");

			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create Account')]")));
			 waitInSeconds(5);
			 scrollPage(0,1600);
			 hover(driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")));
			 driver.findElement(By.xpath("//button[contains(text(),'Create Account')]")).click();
			 
			 System.out.println("Filled Profile Page");
			 return MethodExecuted = true;
				 			 			    
	   }

	public Boolean profilePageRegisterUser(String password) {
		Boolean MethodExecuted = false;
		System.out.println("Filling Login form on subscription success page ");

		wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		driver.findElement(By.xpath("//input[@name='password']")).clear();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sign-in-btn']")));
		driver.findElement(By.xpath("//*[@id='sign-in-btn']")).click();
		System.out.println("Filled Profile Page");
		return MethodExecuted = true;

	}
	   
	   public void loadRegistrationPage() {
		   
		     System.out.println("Loading Registration page");
		   	 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_createAccountButton")));
			 driver.findElement(By.id("capture_signIn_createAccountButton")).click();
			 System.out.println("Registration Page Loaded");
									    
	   }
	   
	   public void FillRegistrationPage(String NewEmail) {
		   
		     wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_traditionalRegistration_firstName")));
			 driver.findElement(By.id("capture_traditionalRegistration_firstName")).sendKeys("Testing");
			 System.out.println("First Name Entered");
			 
			 driver.findElement(By.id("capture_traditionalRegistration_lastName")).sendKeys("Testing");
			 System.out.println("Last Name Entered");

			 driver.findElement(By.id("capture_traditionalRegistration_emailAddress")).sendKeys(NewEmail);
			 System.out.println("Email Entered");
			 
			 driver.findElement(By.id("capture_traditionalRegistration_addressPostalCode")).sendKeys("A1A 1A1");
			 System.out.println("Postal Code Entered");
			 
			 driver.findElement(By.id("capture_traditionalRegistration_newPassword")).sendKeys("avatar123");
			 System.out.println("Password Entered");
			 
			 driver.findElement(By.id("capture_traditionalRegistration_newPasswordConfirm")).sendKeys("avatar123");
			 System.out.println("Confirm Password Entered");
			 
			 driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
									    
	   }
	   
	   public void VerifyEmail(String NewEmail) {
		     System.out.println("Verifying Email");
		     waitInSeconds(5);
		   	 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("addOverlay")));
			 driver.findElement(By.id("addOverlay")).sendKeys(NewEmail);

			 driver.findElement(By.id("go-to-public")).click();
			 System.out.println("Clicked Login Button");
			 
			 System.out.println("Opening Verification Email");
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Torstar account email verification")));
			 driver.findElement(By.linkText("Torstar account email verification")).click();
		     System.out.println("Switching to plain text view");
		   	 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='parts_buttons']/button[1]")));
		   	 driver.findElement(By.xpath("//*[@id='parts_buttons']/button[1]")).click();
			 System.out.println("Clicking Verification Link");
			 System.out.println("Switching to Frame 0");
			 driver.switchTo().frame(0);
			 System.out.println("Switched to Frame 0");
			 wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > a:nth-child(7)")));
			 System.out.println("Verification link found");
			 driver.findElement(By.cssSelector("body > a:nth-child(7)")).click();
			 System.out.println("Error with Click");
			 System.out.println("Verification Link Clicked");
	   }
	   
	   public void SwitchToFrame (int frame) {
	   	driver.switchTo().frame(frame);
	   }

		public void SwitchToDefaultContent () {
		driver.switchTo().defaultContent();
	   }
	   
	   public void SignIn_To_Vote(String username, String password){
		   

		   System.out.println("Size of windows " + signinwindowhandler.size());
		   while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!campaignwindowhandler.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                try {   
	            	driver.switchTo().window(ChildWindow);	                                                                                                           
	                   System.out.println("Current Window Handler " + driver.getWindowHandle());
	         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='styled__Login-sc-10wdlse-4 eYtuxd']")));
	         		   System.out.println("User Signing In as " + username + "  " + password);
	         		   driver.findElement(By.id("capture_signIn_signInEmailAddress")).sendKeys(username);
	         		   //wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_currentPassword")));
	         		   driver.findElement(By.id("capture_signIn_currentPassword")).sendKeys(password);
	         		   //wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));
	         		   driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	         		   //wait20.until(ExpectedConditions.visibilityOfElementLocated(By.className("o-tophat-container")));
	         		   System.out.println("User Signed In");
	                }
	                
	                catch (ElementNotVisibleException e) {
	                	
	                	   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		         		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		         		   //wait20.until(ExpectedConditions.visibilityOfElementLocated(By.className("o-tophat-container")));
		         		   System.out.println("User Signed In");
	                	
	                	
	                }
	            }
			  
	        }
		   
	   }
	   
	   public Boolean SignIn_To_Vote_SigninPage(String username, String password) {
		   
		   Boolean methodexecuted = false;

	                   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_signInEmailAddress")));
	         		   System.out.println("User Signing In as " + username + "  " + password);
	         		   driver.findElement(By.id("capture_signIn_signInEmailAddress")).sendKeys(username);
	         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_currentPassword")));
	         		   driver.findElement(By.id("capture_signIn_currentPassword")).sendKeys(password);
	         		   try {
						   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[2]")));
						   driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
						   System.out.println("User Signed In");
						   methodexecuted = true;
					   }
	                
	                	catch (TimeoutException e) {
	                	
	                	   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		         		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.className("o-tophat-container")));
		         		   System.out.println("User Signed In");
		         		   methodexecuted = true;

	                }
		   waitInSeconds(4);
		   return methodexecuted;
		   
	   }
	   
	   public Boolean SignIn_To_PayPal(String email, String password) {
		   
		   Boolean methodexecuted = false;
		   waitInSeconds(5);
		   System.out.println("Size of windows " + childindowhandler.size());
		   while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!mainwindowhandler.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                try {   
		                  driver.switchTo().window(ChildWindow);	                                                                                                           
		                  System.out.println("Current Window Handler " + driver.getWindowHandle());
		                  try{
							  wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Log In')]")));
							  driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
							  waitInSeconds(5);
						  }
		                  catch (TimeoutException ex){
		                  	  System.out.println("Step is skipped as there are other form");
						  }
		         		  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		         		  driver.findElement(By.id("email")).sendKeys(email);

		         		  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNext")));
		         		  driver.findElement(By.id("btnNext")).click();
		         		  
		         		  wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		         		  driver.findElement(By.id("email")).sendKeys(email);
		         		  
		         		  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		         		  driver.findElement(By.id("password")).sendKeys(password);
		         		  
		         		  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
		         		  driver.findElement(By.id("btnLogin")).click();
		         		  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment-submit-btn")));
						  wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='add-fi-link']")));
						  driver.findElement(By.id("payment-submit-btn")).click();

						methodexecuted = true;
	                }
	                
	                catch (ElementNotVisibleException e) {
	                	
	                	   System.out.println("Element not found");
		         		   methodexecuted = false;
	                	
	                	
	                }
	            }
		   System.out.println("Switching back to main window handler " + mainwindowhandler);
		   driver.switchTo().window(mainwindowhandler);
			}
		   return methodexecuted;
		   
	   }

	   public void switchToWindow(){
		   String subWindowHandler = null;
		   Set<String> handles = driver.getWindowHandles(); // get all window handles
		   for (String handle : handles) {
			   subWindowHandler = handle;
		   }
		   driver.switchTo().window(subWindowHandler); // switch to popup page
	   }
	   
	   public void BlueLinePage (){

		   wait10.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dutch investigators")));
		   WebElement btn = driver.findElement(By.linkText("Dutch investigators"));
		   hover(btn);
		   waitInSeconds(3);
		   Actions action = new Actions(driver);
		   action.moveToElement(btn).perform();
		   System.out.println(driver.findElement(By.linkText("Dutch investigators")).getCssValue("background-color"));
	   }

	   
	   public String Color_Match (By locator, String property){
	   	   waitInSeconds(10);
		   wait10.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   String bordercolor = driver.findElement(locator).getCssValue(property);
		   System.out.println(bordercolor);
		   return bordercolor;
	   }
	   
	   public void network_log(){
		   
		   String scriptToExecute1 = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		   //driver.get(article5);
		   waitInSeconds(35);
		   newnetData = ((JavascriptExecutor)driver).executeScript(scriptToExecute1).toString();
		   //System.out.println(newnetData);
		   //System.out.println(newnetData.substring(newnetData.indexOf("pixel.parsely"), newnetData.indexOf("pageview")));

		   //pixel_parsely_pageview = newnetData.substring(newnetData.indexOf("pixel.parsely"));
		   //pixel_parsely_pageview = pixel_parsely_pageview.substring(0, pixel_parsely_pageview.indexOf("pageview") + 8);
		   //System.out.println(pixel_parsely_pageview);
		   
		   //String startof_parsely_heartbeat = newnetData.substring(newnetData.indexOf("pixel.parsely") + 14);
		   //pixel_parsely_heartbeat = startof_parsely_heartbeat.substring(startof_parsely_heartbeat.indexOf("pixel.parsely"));
		   //pixel_parsely_heartbeat = pixel_parsely_heartbeat.substring(0, pixel_parsely_heartbeat.indexOf("heartbeat") + 9);
		   
		   //Integer lastindex = pixel_parsely_pageview.indexOf("pageview");
		   //lastindex = lastindex + 8;
		   
		  
		   
		   //String startof_parsely_heartbeat = newnetData.substring(newnetData.indexOf("pixel.parsely") + 14);
		   //pixel_parsely_heartbeat = startof_parsely_heartbeat.substring(startof_parsely_heartbeat.indexOf("pixel.parsely"));
		   //pixel_parsely_heartbeat = pixel_parsely_heartbeat.substring(0, pixel_parsely_heartbeat.indexOf("heartbeat") + 9);
		   //System.out.println(pixel_parsely_heartbeat);

		   /*
		   JsonParser parser = new JsonParser();
		      JsonObject json = parser.parse(newnetData).getAsJsonObject();

		      Gson gson = new GsonBuilder().setPrettyPrinting().create();
		      String prettyJson = gson.toJson(json);

		      //return prettyJson;
		   */
		   
		   /*
		   List <LogEntry> entries =  driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		   System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
		   for (LogEntry entry : entries) {
		             System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		   }*/
		   		  
	  
	   }
	   
	   public String parsely_pageview() {
	   
		   pixel_parsely_pageview = newnetData.substring(newnetData.indexOf("pixel.parsely"));
		   pixel_parsely_pageview = pixel_parsely_pageview.substring(pixel_parsely_pageview.indexOf("action=pageview"), pixel_parsely_pageview.indexOf("action=pageview") + 15);
		   System.out.println("Pixel Parsely_pageview: " + pixel_parsely_pageview);
		   
		   String findStr = "action=pageview";
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   System.out.println("Count of action=pageview: " + count);
		   return pixel_parsely_pageview;
	   }
	   
	   public String parsely_heartbeat() {
		   
		   pixel_parsely_heartbeat = newnetData.substring(newnetData.indexOf("pixel.parsely") + 14);
		   pixel_parsely_heartbeat = pixel_parsely_heartbeat.substring(pixel_parsely_heartbeat.indexOf("pixel.parsely"));
		   pixel_parsely_heartbeat = pixel_parsely_heartbeat.substring(pixel_parsely_heartbeat.indexOf("action=heartbeat"), pixel_parsely_heartbeat.indexOf("action=heartbeat") + 16);
		   System.out.println("Pixel Parsely_heartbeat: " + pixel_parsely_heartbeat);
		   
		   String findStr = "action=heartbeat";
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   System.out.println("Count of action=heartbeat: " + count);
		   
		   return pixel_parsely_heartbeat;
	   }
	   
	   public String petametrics_widget_shown() {
		   
		   query_petametrics_widget_shown = newnetData.substring(newnetData.indexOf("e=widget_shown"));
		   query_petametrics_widget_shown = query_petametrics_widget_shown.substring(query_petametrics_widget_shown.indexOf("e=widget_shown"), query_petametrics_widget_shown.indexOf("e=widget_shown") + 14);
		   System.out.println("Query_Petametrics_widgetshown: " + query_petametrics_widget_shown);
		   
		   String findStr = "e=widget_shown";
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   
		   System.out.println("Count of e=widget_shown: " + count);
		   return query_petametrics_widget_shown;
	   }
	   
	   public String petametrics_stuck_10s() {
		   
		   query_petametrics_stuck_10s = newnetData.substring(newnetData.indexOf("e=stuck_10s"));
		   query_petametrics_stuck_10s = query_petametrics_stuck_10s.substring(query_petametrics_stuck_10s.indexOf("e=stuck_10s"), query_petametrics_stuck_10s.indexOf("e=stuck_10s") + 11);
		   System.out.println("Query_Petametrics_stuck10s: " + query_petametrics_stuck_10s);
		   
		   String findStr = "e=stuck_10s";
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   System.out.println("Count of e=stuck_10s: " + count);
		   
		   return query_petametrics_stuck_10s;
	   }
	   
	   public String torontodnnlocalqa() {
		   System.out.println("newnetdata: " + newnetData);
		   try {
		   torontodnnlocalqa = newnetData.substring(newnetData.indexOf(find_torontodnnlocal));
		   torontodnnlocalqa = torontodnnlocalqa.substring(torontodnnlocalqa.indexOf(find_torontodnnlocal), torontodnnlocalqa.indexOf(find_torontodnnlocal) + last_index_local);
		   System.out.println("URL QA: " + torontodnnlocalqa);
		   
		   String findStr = find_torontodnnlocal;
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   System.out.println("Count of QA URL: " + count);
		   }
		   catch (IndexOutOfBoundsException e) {
			   torontodnnlocalqa = "Not Found";
			   System.out.println("URL QA: " + torontodnnlocalqa);
			   System.out.println("Count of QA URL: 0" );
		   }
		   
		   return torontodnnlocalqa;
	   }

	public static void extractUrls(String text, String textForAssert)
	{
		List<String> containedUrls = new ArrayList<String>();
		String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
		Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
		Matcher urlMatcher = pattern.matcher(text);

		while (urlMatcher.find())
		{
			containedUrls.add(text.substring(urlMatcher.start(0),
					urlMatcher.end(0)));
		}
			boolean testresult = containedUrls.toString().contains(textForAssert);
			System.out.println(containedUrls.toString().contains(textForAssert));
			Assert.assertTrue(testresult);
	}
	   
	   public String thestardesktopdev() {
		   //System.out.println("newnetdata: " + newnetData);
		   try {
		   thestardesktopdev = newnetData.substring(newnetData.indexOf(find_thestardesktop));
		   thestardesktopdev = thestardesktopdev.substring(thestardesktopdev.indexOf(find_thestardesktop), thestardesktopdev.indexOf(find_thestardesktop) + last_index_desktop);
		   System.out.println("URL Dev: " + thestardesktopdev);
		   
		   String findStr = find_thestardesktop;
		   int lastIndex = 0;
		   int count = 0;

		   while(lastIndex != -1){

		       lastIndex = newnetData.indexOf(findStr,lastIndex);

		       if(lastIndex != -1){
		           count ++;
		           lastIndex += findStr.length();
		       }
		   }
		   System.out.println("Count of DEV URL: " + count);
		   }
		   catch (IndexOutOfBoundsException e) {
			   thestardesktopdev = "Not Found";
			   System.out.println("URL Dev: " + thestardesktopdev);
			   System.out.println("Count of DEV URL: 0");
		   }
		   
		   return thestardesktopdev;
	   }
	   
	   public void network_log_analytics() {
		   System.out.println("Start Reading Network Logs");
		   waitInSeconds(30);
		   newnetData = null;
		   String scriptToExecute1 = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		   newnetData = ((JavascriptExecutor)driver).executeScript(scriptToExecute1).toString();
		   
		   System.out.println("Network Data: " + newnetData);
		   System.out.println("End Reading Network Logs");
	   }

	public void network_log_marketing_id() {

		System.out.println("Start Reading Network Logs");
		waitInSeconds(30);
		String scriptToExecute1 = "return _satellite.getVisitorId().getMarketingCloudVisitorID();";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		newnetData = js.executeScript(scriptToExecute1).toString();
		System.out.println("Network Data: " + js.executeScript(scriptToExecute1));
		System.out.println("End Reading Network Logs");
	}

	   
	   public void Search_Doctor(String Doctor_LastName) {
			 
		   System.out.println("Searching Doctor by Last Name");
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("DoctorDatabaseSearchInput")));
		   driver.findElement(By.id("DoctorDatabaseSearchInput")).sendKeys(Doctor_LastName);
		   waitInSeconds(3);

		   }

	   
	   public void thespec_payment_page(){
		   
		   System.out.println("Clicking Subscribe Button");
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='o-shop-package-item__btn']")));
		   driver.findElement(By.xpath("//button[@class='o-shop-package-item__btn']")).click();
		   System.out.println("Subscribe button clicked");
	   }
	   
	   public void thespec_signin_user(String username, String password) {
			
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("capture_signIn_signInEmailAddress")));
		   driver.findElement(By.id("capture_signIn_signInEmailAddress")).sendKeys(username);
		   driver.findElement(By.id("capture_signIn_currentPassword")).sendKeys(password);
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		   System.out.println("Sign in Button Clicked");
	   }
	   
	     
	   public void facebookLoginPage() {
		   
		   mainwindowhandler = driver.getWindowHandle();
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".janrain-provider-text-color-facebook")));
		   driver.findElement(By.cssSelector(".janrain-provider-text-color-facebook")).click();
		   System.out.println("FaceBook Button Clicked");
		   childindowhandler = driver.getWindowHandles();
		   i1= childindowhandler.iterator();
		   System.out.println("Main window handler " + mainwindowhandler);
		   System.out.println("Child window handler " + childindowhandler);
	   }
	   
	   
	   public Boolean signInFacebook(String username, String password) {
		   
		   Boolean methodexecuted = false;
		   System.out.println("Size of windows " + childindowhandler.size());
		   waitInSeconds(10);
		   while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!mainwindowhandler.equalsIgnoreCase(ChildWindow))			
	            {    		

	                try {   
	                   driver.switchTo().window(ChildWindow);	                                                                                                           
	                   System.out.println("Current Window Handler " + driver.getWindowHandle());
	         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
	         		   
	         		   driver.findElement(By.id("email")).sendKeys(username);
	         		   
	         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
	         		   
	         		   driver.findElement(By.id("pass")).sendKeys(password);
	         		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton")));
	         		   driver.findElement(By.id("loginbutton")).click();
	         		   System.out.println("User Name and Password Entered, Login Button Clicked");
	         		   waitInSeconds(5);
	         		   driver.switchTo().window(mainwindowhandler);
	         		   waitInSeconds(5);
	         		   //wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thestar')]")));
	         		   methodexecuted = true;
	                }
	                
	                catch (ElementNotVisibleException e) {
	                	
	                	   System.out.println("Element not found");
		         		   methodexecuted = false;
	                	
	                	
	                }
	            }
			  
	        }
		   return methodexecuted;
		   
	   }
	   
	   public Boolean CityDropDown() {
		   
		   Boolean MethodExecuted = false;
		   System.out.println("Clicking Location Options");
		   waitInSeconds(10);
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.HOME_CITY_DROPDOWN.toString())));
		   driver.findElement(By.xpath(Variables.HOME_CITY_DROPDOWN.toString())).click();
		   System.out.println("Location Options Clicked");
		   MethodExecuted = true;
		   return MethodExecuted;
		   
	   }
	   
	   public void AnalyticsParameters() {
		   if (baseUrl.contains("reactqa") )  {
			   System.out.println("ReactQA Parameters Found");
			   find_torontodnnlocal = "https://s.thestar.com/b/ss/torontodnnlocalqa/"; //qa
			   find_thestardesktop = "https://s.thestar.com/b/ss/thestardesktopdev/"; //qa
			   last_index_local = 45; // qa
			   last_index_desktop = 45; // qa
			   System.out.println("QA Parameters Assigned");
		   }
		   else if (baseUrl.contains("thespec")) {
			   System.out.println("RDR Parameters Found");
			   find_torontodnnlocal = "https://s.thestar.com/b/ss/torontodnnlocalqa/"; //qa
			   find_thestardesktop = "https://s.thestar.com/b/ss/thestardesktopdev/"; //qa
			   last_index_local = 45; // qa
			   last_index_desktop = 45; // qa
			   System.out.println("RDR Parameters Assigned");
		   }
		   else if (baseUrl.contains("react")) {
			   System.out.println("React Parameters Found");
			   find_torontodnnlocal = "http://n.thestar.com/b/ss/torontodnnlocal/"; //prod
			   /*http://n.thestar.com/b/ss/torontodnnlocal/*/
			   find_thestardesktop = "http://n.thestar.com/b/ss/thestarbrowser/"; //prod
			   last_index_local = 42; // prod
			   last_index_desktop = 41; // prod
			   System.out.println("React Parameters Assigned");
		   }
			   
		   else {
			   		//System.out.println(baseUrl.indexOf("reactqa") == 0);
			   		System.out.println("Production Parameters Found");
			   		find_torontodnnlocal = "https://s.thestar.com/b/ss/torontodnnlocal/"; //prod
			   		find_thestardesktop = "https://s.thestar.com/b/ss/thestarbrowser/"; //prod
			   		last_index_local = 43; // prod
			   		last_index_desktop = 42; // prod
			   		System.out.println("Production Parameters Assigned");
			   
		   }
		   
	   }
	   
	   public void OpenCategoryBlueLabel() {
		   System.out.println("Clicking Link on Blue Label");
		   wait5.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".label-flag")));
		   driver.findElement(By.cssSelector(".label-flag")).click();
		   System.out.println("Clicked Link on Blue Label");
		   waitInSeconds(3);
	   }
	   
	   public void DeleteAllCookies(){
			  
		   System.out.println("Start: Deleting All Cookies");
		   driver.manage().deleteAllCookies();
		   System.out.println("End: Deleting All Cookies");
	  
	   }

	public void loadURL(String PageType, String PageURL){

		System.out.println("Start Loading " + PageType + ": " + PageURL);
		driver.get(PageURL);
		wait20.until(ExpectedConditions.urlToBe(PageURL));
		System.out.println("End Loading " + PageType + ": " + PageURL);
		waitInSeconds(5);
	}

	public void loadPage(String PageType, String PageURL){

		System.out.println("Start Loading " + PageType + ": " + PageURL);
		driver.get(PageURL);
		waitInSeconds(10);
		System.out.println("End Loading " + PageType + ": " + PageURL);

	}

	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	   
	   public Boolean ContainsCheck(String ContainsIn, String ContainsWhat) {
		   Boolean ContainsYesNo = null;
		   waitInSeconds(5);
		   if (ContainsIn.contains(ContainsWhat)){
			   ContainsYesNo = true;
		   }
		   else {
			   ContainsYesNo = false;
		   }
		   return ContainsYesNo;
	   }
	   
	   public void ReadXMLAndDriverSetup (String Local_BS) throws Exception {
		   ReadObjectRepositoryXML();
		   if (isRDR(baseUrl) ) {
				ReadObjectRepositoryXML_RDR();
			}
		   if (!Local_BS.contains("Local")) {
			   BsLocal_Setup();
		   }
	   }

	   public void Reading_AdobeTokensFromConsoleData() {
			System.out.println("Start: Reading Console Data");
			waitInSeconds(15);
			ConsoleData = null;
			//String scriptToExecute1 = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
			String ScriptToExecute1 = "var ConsoleParameters = adobeTokens; return ConsoleParameters;";
     	    ConsoleData = ((JavascriptExecutor)driver).executeScript(ScriptToExecute1).toString();
			System.out.println("Network Data: " + ConsoleData);
			System.out.println("End: Reading Console Data");
		
		}

		public void setMobileDimension(int width, int height){

		System.out.println("Set browser dimension");
		driver.manage().window().setSize(new Dimension(width,height));
		System.out.println("New browser dimension successfully set");

		}

	public void DAPSAddressSet() {
		System.out.println("Started to set up DAPS address");
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='streetNumber']")));
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='streetName']")));
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='phoneNumber']")));
		driver.findElement(By.xpath("//*[@id='streetNumber']")).sendKeys("streetNumber");
		driver.findElement(By.xpath("//*[@id='streetName']")).sendKeys("streetName");
		driver.findElement(By.xpath("//*[@id='phoneNumber']")).sendKeys("1234567890");
		System.out.println("Completed to set up DAPS address");
	}


	public void acceptTermsContinue() {
		System.out.println("Started submit of DAPS form");
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='MuiFormControlLabel-root']")));
		driver.findElement(By.xpath("//label[@class='MuiFormControlLabel-root']")).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submitDetails']")));
		driver.findElement(By.xpath("//*[@id='submitDetails']")).click();
		System.out.println("Completed submit of DAPS form");
		waitInSeconds(20);
	}

	public void closeTab() {
	   	waitInSeconds(10);
		System.out.println("Close current tab");
		driver.close();
	}

	public void usePromoCode() {
		System.out.println("Filling voucher Code");
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='voucherCode']")));
		driver.findElement(By.xpath("//input[@id='voucherCode']")).sendKeys("Aug10");
		System.out.println("Apply voucher Code");
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@ng-click='vm.applyVoucher()']")));
		driver.findElement(By.xpath("//a[@ng-click='vm.applyVoucher()']")).click();
		System.out.println("Successfully applied voucher Code");
	}

	public void isEnabled(By elementXpath) {
	   	try{
	   	wait20.until(ExpectedConditions.visibilityOfElementLocated(elementXpath));
	}
	   	catch (TimeoutException ex){
	   	throw new SkipException("Functionality Is not available or turned off");
		}
	}

	public void refreshPage() {
		System.out.println("Starting page refresh");
	   	driver.navigate().refresh();
		System.out.println("Completed page refresh");
	}

	public void waitForInput() {
	   	wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));

	}

	public void AemSignInPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("atolok");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("testing123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));
		driver.findElement(By.id("submit-button")).click();
	}

	public void AemAutomateAnonymous() {
		String AemAutomateAnonymousURL = "https://author-stage.smgdigitaldev.com/content/thestar/configuration/automate-anonymous.html";
		driver.manage().window().maximize();
		driver.navigate().to(AemAutomateAnonymousURL);
	}

	public void AemAutomateRegistered() {
		String AemAutomateRegisteredURL = "https://author-stage.smgdigitaldev.com/content/thestar/configuration/automate-registered.html";
		driver.manage().window().maximize();
		driver.navigate().to(AemAutomateRegisteredURL);
	}

	public void AemRDR() {
		String AemRDR = "https://author-dev.smgdigitaldev.com/cf#/content/thespec/configuration/TheSpec-Automation.html";
		driver.manage().window().maximize();
		driver.navigate().to(AemRDR);
		driver.switchTo().frame(0);
	}

	public void RDRAemSignInPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("sgupta");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		driver.findElement(By.id("password")).sendKeys("letmein123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));
		driver.findElement(By.id("submit-button")).click();
	}

	public void isRDRSkip(String url){
		if (url.contains("thespec") || url.contains("therecord") || url.contains("thepeterboroughexaminer")
		|| url.contains("wellandtribune") || url.contains("niagarafallsreview")|| url.contains("stcatharinesstandard")) {
			throw new SkipException("This test case not valid for RDR");
		}
	}

	public void isWellandtribuneSkip(String url){
		if (url.contains("wellandtribune")) {
			throw new SkipException("This test case not valid for RDR");
		}
	}

	public void niagaraSkipTest(String url){
		if (url.contains("niagarafallsreview")) {
			throw new SkipException("This test case not valid for RDR");
		}
	}

	public boolean isRDR(String url){
		if (url.contains("thespec") || url.contains("therecord") ) {
			System.out.println("RDR env");
			return true;
		}
		return false;
	}

	public void findAndVerifyAnalyticsFrame() {
		System.out.println("Start: Asserting Analytics script");
		String expectedScript = "<amp-analytics type=\"adobeanalytics_nativeConfig\" class=\"i-amphtml-element i-amphtml-layout-fixed i-amphtml-layout-size-defined i-amphtml-layout\" i-amphtml-layout=\"fixed\" style=\"width: 1px; height: 1px;\" aria-hidden=\"true\" hidden=\"\">\n" +
				"      <script type=\"application/json\">\n" +
				"        {\n" +
				"          \"requests\": {\n" +
				"            \"base\": \"https://amp-uat.smgdigitaldev.com\",\n" +
				"            \"iframeMessage\":";
		System.out.println(driver.getPageSource().contains(expectedScript));
		System.out.println("End: Asserting Analytics script");
	}

	public void triggerValidation(String url) {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"input-content style-scope paper-input-container\"]")));
		driver.findElement(By.xpath("//div[@class=\"input-content style-scope paper-input-container\"]")).click();
		waitInSeconds(5);
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"input-content style-scope paper-input-container\"]")));
		driver.findElement(By.xpath("//div[@class=\"input-content style-scope paper-input-container\"]")).sendKeys(url);
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"validateButton\"]")));
		driver.findElement(By.xpath("//*[@id=\"validateButton\"]")).click();
	}

	public void subscribeNewsLetter() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEWSLETTER_CHECK.toString())));
		driver.findElement(By.xpath(Variables.NEWSLETTER_CHECK.toString())).click();
		waitInSeconds(5);
	}

	public void unSubscribeNewsLetter() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEWSLETTER_CHECK.toString())));
		driver.findElement(By.xpath(Variables.NEWSLETTER_CHECK.toString())).click();
		waitInSeconds(5);
	}

	public boolean isRDRNiagara(String url) {
		if (url.contains("niagarafallsreview") || url.contains("stcatharinesstandard") || url.contains("wellandtribune")) {
			System.out.println("RDR env");
			return true;
		}
		return false;
	}

	public boolean isRDRPE(String url) {
		if (url.contains("thepeterboroughexaminer")) {
			System.out.println("RDR env");
			return true;
		}
		return false;
	}

	public void expendComponent(BaseTestPageAndObjects localObj) {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Show')]")));
		hover(driver.findElement(By.xpath("//span[contains(text(),'Show')]")));
		for(int i=0;i<2;i++){
			waitInSeconds(1);
			scrollPage(0, 2000);
		}
		wait20.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Show')]")));
		waitInSeconds(5);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Show')]"))).click().build().perform();
	}

	public void collapseComponent(BaseTestPageAndObjects localObj) {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hide')]")));
		waitInSeconds(5);
		driver.findElement(By.xpath("//span[contains(text(),'Hide')]")).click();
	}

	public void setup(BaseTestPageAndObjects localObj) {
		waitInSeconds(10);
		if(localObj.checkObjectIsPresent(By.xpath("//*[@id='root']/div/div[4]/div/div/div/form/div/input"))){
			driver.findElement(By.xpath("//*[@id='root']/div/div[4]/div/div/div/form/div/input")).sendKeys(AUTOMATE_ACCESS_KEY);
			wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[4]/div/div/div/form/div/button")));
			driver.findElement(By.xpath("//*[@id='root']/div/div[4]/div/div/div/form/div/button")).click();
			System.out.println("SUCCESSFULLY PASSED!!!!!!!!!!!!");
		}
		else {
			wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div/div[2]/div[2]/div[1]/span")));
			System.out.println("Already connected");
		}
	}

    public void nextPromoPage() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEXT_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.NEXT_BUTTON.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.BACK_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.BACK_BUTTON.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.NEXT_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.NEXT_BUTTON.toString())).click();
    }

	public void textMeAPP() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.TEXT_ME_APP_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.TEXT_ME_APP_BUTTON.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.MOBILE_INPUT.toString())));
		driver.findElement(By.xpath(Variables.MOBILE_INPUT.toString())).sendKeys("613-555-0158");
		driver.findElement(By.xpath(Variables.TEXT_ME_APP_BUTTON.toString())).click();
	}

	public void openMenu() {
		wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.OPEN_MENU_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.OPEN_MENU_BUTTON.toString())).click();
		try {
			driver.findElement(By.xpath(Variables.OPEN_MENU_BUTTON.toString())).click();
			driver.findElement(By.xpath(Variables.OPEN_MENU_BUTTON.toString())).click();
		}
		catch (ElementClickInterceptedException ex){
			System.out.println("Already clicked");
		}
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.MANAGE_PROFILE_BUTTON.toString())));
	}

	public void openSearch() {
		wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.OPEN_SEARCH_BUTTON.toString())));
		hover(driver.findElement(By.xpath(Variables.OPEN_SEARCH_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.OPEN_SEARCH_BUTTON.toString())).click();
	}

	public void searchText(String searchText) {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SEARCH_INPUT.toString())));
		driver.findElement(By.xpath(Variables.SEARCH_INPUT.toString())).sendKeys(searchText);
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SEARCH_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.SEARCH_BUTTON.toString())).click();
	}

	public void assertSearchURL(String url) {
		waitInSeconds(5);
		wait20.until(ExpectedConditions.urlToBe(url));
		System.out.println("End Verifying  " + url);
	}

	public void sortSearchOldest() {
	   	Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_SORT.toString())));
	   	sortSearch.selectByValue(Variables.SEARCH_SORT_OLDEST.toString());
	}

	public void sortSearchNewest() {
		Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_SORT.toString())));
		sortSearch.selectByValue(Variables.SEARCH_SORT_NEWEST.toString());
	}

	public void sortSearchRelevance() {
		Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_SORT.toString())));
		sortSearch.selectByValue(Variables.SEARCH_SORT_RELEVANCE.toString());
	}

	public void filterVideo() {
		Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_FILTER_CONTENT.toString())));
		sortSearch.selectByValue(Variables.SEARCH_FILTER_VIDEO.toString());
	}

	public void filterPhoto() {
		Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_FILTER_CONTENT.toString())));
		sortSearch.selectByValue(Variables.SEARCH_FILTER_PHOTO.toString());
	}

	public void filterVideoPhoto() {
		Select sortSearch = new Select(driver.findElement(By.xpath(Variables.SEARCH_FILTER_CONTENT.toString())));
		sortSearch.selectByValue(Variables.SEARCH_FILTER_PHOTO_VIDEO.toString());
	}

	public void switchBetweenGifts() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SELECT_GIFT.toString())));
		List<WebElement> gifts = driver.findElements(By.xpath(Variables.SELECT_GIFT.toString()));
		System.out.println(gifts.size());
		System.out.println("Select gift 2");
		gifts.get(1).click();
		System.out.println("Select gift 3");
		gifts.get(2).click();
		System.out.println("Select gift 1");
		gifts.get(0).click();
	}


	public void openHTML5Component() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.HTML_CLICK_TO_OPEN.toString())));
		driver.findElement(By.xpath(Variables.HTML_CLICK_TO_OPEN.toString())).click();
		SwitchToFrame(0);
	}

	public void openAMPMenu() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.AMP_SIDE_BAR.toString())));
		driver.findElement(By.xpath(Variables.AMP_SIDE_BAR.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.CLOSE_SIDE_BAR.toString())));
	}

	public void proceedToPurchaseDetails() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SUBMIT_GIFT.toString())));
		driver.findElement(By.xpath(Variables.SUBMIT_GIFT.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.EDIT_GIFT_PACKAGE.toString())));
	}

	public void editPackage() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.EDIT_GIFT_PACKAGE.toString())));
		driver.findElement(By.xpath(Variables.EDIT_GIFT_PACKAGE.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SELECT_GIFT.toString())));
	}

	public void submitPurchaseDetailsPage() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SEARCH_BUTTON.toString())));
		scrollPage(0,1600);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(Variables.SEARCH_BUTTON.toString()))).click().build().perform();
	}

	public void enterPurchaseDetailsInfo(String fromEmail, String forEmail) {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.GIFT_MESSAGE.toString())));
		driver.findElement(By.xpath(Variables.GIFT_FOR_EMAIL.toString())).sendKeys(forEmail);
		driver.findElement(By.xpath(Variables.GIFT_FROM_FIRST_NAME.toString())).sendKeys("GIFT_FROM_FIRST_NAME");
		driver.findElement(By.xpath(Variables.GIFT_FROM_LAST_NAME.toString())).sendKeys("GIFT_FROM_LAST_NAME");
		driver.findElement(By.xpath(Variables.GIFT_FOR_FULL_NAME.toString())).sendKeys("TestingTesting TestingTesting");
		driver.findElement(By.xpath(Variables.GIFT_MESSAGE.toString())).sendKeys("GIFTMESSAGETEXT");
		driver.findElement(By.xpath(Variables.GIFT_FROM_EMAIL.toString())).sendKeys(fromEmail);
	}

	public String getActivationLink() {
	   	String currentUrl = driver.getCurrentUrl();
		String urlRegex = "\\?(.*)";
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(currentUrl);
		if (matcher.find())
		{
			System.out.println(matcher.group(1));
			return matcher.group(1);
		}
		return currentUrl;
	}

	public void selectToronto() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".o-nav-location-desktop .o-two-row-paragraph:nth-child(1")));
		driver.findElement(By.cssSelector(".o-nav-location-desktop .o-two-row-paragraph:nth-child(1")).click();
	}

	public void waitGorGiftPage() {
		wait50.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SELECT_GIFT.toString())));
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.GIFT_CONTACT_US.toString())));
	}

	public void signOut() {
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SIGN_OUT_BUTTON.toString())));
		driver.findElement(By.xpath(Variables.SIGN_OUT_BUTTON.toString())).click();
		wait20.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Variables.SIGN_IN_BUTTON_TEXT.toString())));
	}
}
