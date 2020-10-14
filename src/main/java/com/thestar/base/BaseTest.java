package com.thestar.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class BaseTest extends BrowserDriverFactory {
	
	protected String campaignwindowhandler = "";
	protected Set<String> signinwindowhandler;
	protected String mainwindowhandler = "";
	protected Set<String> childindowhandler;
	protected Iterator<String> i1;
	protected int impwait5 = 5;
	protected int impwait10 = 10;
	public String newnetData = "";
	public String ConsoleData = "";
	protected String pixel_parsely_pageview = "";
	protected String pixel_parsely_heartbeat = "";
	protected String query_petametrics_widget_shown = "";
	protected String query_petametrics_stuck_10s = "";
	protected String torontodnnlocalqa = "";
	protected String thestardesktopdev = "";
	
	public String find_torontodnnlocal = ""; 
	public String find_thestardesktop = ""; 
	public int last_index_local = 0; 
	public int last_index_desktop = 0;
			
	 public Boolean check_object(By locator){
		 wait50.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 Boolean blnObjectPresent = driver.findElement(locator).isDisplayed();
		 return blnObjectPresent;
		   
	   }

	public String check_object_UnTrimmed_Text_Wait(Integer waittime, By locator){

		WebDriverWait wait = new WebDriverWait(driver, waittime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String strObjectText = driver.findElement(locator).getText();
		System.out.println("Trimmed Text is " + strObjectText);
		strObjectText = "Value: " + strObjectText;
		return strObjectText;

	}
	 
	 public String check_object_Text(By locator){
		 
		 wait20.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 String strObjectText = driver.findElement(locator).getText();
		 System.out.println(strObjectText);
		 return strObjectText;
	   }
	 
	 public String check_object_Trimmed_Text(By locator){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 String strObjectText = driver.findElement(locator).getText();
		 String strtrimedObjectText = strObjectText.substring(7, strObjectText.length());
		 System.out.println("Trimmed Text   " + strtrimedObjectText);
		 return strtrimedObjectText;
		   
	   }
	 
	 public String check_object_Class(By locator){
		 
		 wait20.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 String strObjectText = driver.findElement(locator).getAttribute("Class");
		 System.out.println(strObjectText);
		 return strObjectText;
		   
	   }
	 
	 public boolean findChildElements(By locator){
		 
		 wait20.until(ExpectedConditions.visibilityOfElementLocated(locator));
		 WebElement child1 = driver.findElement(locator);
		 int size = child1.findElements(By.tagName("iframe")).size();
		 System.out.println(size);
		 if (size >=1) {
			 return true;
		 }
		 else {
			 return false;
		 }
		   
	   }

	 
	 public Boolean checkObjectIsPresent(By locator){
		  
		 System.out.println("Checking Object Present: " + locator);
		 driver.manage().timeouts().implicitlyWait(impwait10, TimeUnit.SECONDS);
		   Boolean blnObjectPresent = null;
		   try {
	  		    
			   	System.out.println("Searching for object:" + locator);
			   	driver.findElement(locator).isDisplayed();
			    blnObjectPresent = true;

	  		    	        

		    } catch (NoSuchElementException e) {
		         blnObjectPresent = false;
		         System.out.println("Object Not Found:" + locator);
		    	
		       
		    }	
		    return blnObjectPresent;
		   
 		 
	   }
	 	   
	  	   
	   public String Check_URL(){
		   return driver.getCurrentUrl();
	   }
	 

	   public String check_object_Value(By locator){
			 
		   wait20.until(ExpectedConditions.visibilityOfElementLocated(locator));
		   String strObjectValue = driver.findElement(locator).getAttribute("value");
		   System.out.println(strObjectValue);
		   return strObjectValue;
			   
		   }
	   
	   
	   
	   public String scroll_check_object_Text(By locator){
	 		waitInSeconds(2);
	 		scrollPage(0,1400);
	 		wait20.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 		String strObjectText = driver.findElement(locator).getText();
	 		System.out.println(strObjectText);
	 		return strObjectText;
			   
		   }

	   public void scrollPage(Integer x, Integer y) {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy("+x+", "+y+");");
			waitInSeconds(2);
	   }

	public void hover(WebElement element) {
		String javaScript = "var evObj = document.createEvent('MouseEvents');" +
				"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
				"arguments[0].dispatchEvent(evObj);";
		((JavascriptExecutor)driver).executeScript(javaScript, element);
	}
	   

	   public Boolean check_object_Wait(Integer waitTime, By locator){
		     wait = new WebDriverWait(driver, waitTime);
		     try {
				 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			 }
		     catch (TimeoutException exception){
		     	System.out.println("Time out reached element with " + locator + "not found");
			 }
		     return driver.findElement(locator).isDisplayed();
		   }


	   
	   public Boolean checkObjectPresentImpliedWait(int WaitFor, By locator){
			  
		   ImpliedWait = WaitFor; 	 
		   driver.manage().timeouts().implicitlyWait(ImpliedWait, TimeUnit.SECONDS);
			   Boolean blnObjectPresent = null;
			   try {
		  		    
				    driver.findElement(locator).isDisplayed();
				    blnObjectPresent = true;
		  		    	        

			    } catch (NoSuchElementException e) {
			         blnObjectPresent = false;
			       
			    }	
			    return blnObjectPresent;
	 		 
		   }


	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}

	public String getCookieByName(String name) {
	 	Cookie cookie = null;
	 	try {
			System.out.println("Value of cookie is " + name +" "+ driver.manage().getCookieNamed(name).getValue());
		}
	 	catch (NullPointerException ex){
			System.out.println("Value of cookie is " + String.valueOf(cookie));
			return String.valueOf(cookie);
		}
	 	cookie = driver.manage().getCookieNamed(name);
	 	return cookie.getValue();
	}

	public void addCookie(String name, String value) {
		driver.manage().addCookie(
				new Cookie(name, value));
	}


	public void deleteCookieByName(String name) {
		driver.manage().deleteCookieNamed(name);
	}

	public String getCookieValueByName(String name){
		return driver.manage().getCookieNamed(name).getValue();
	}

	   
}
