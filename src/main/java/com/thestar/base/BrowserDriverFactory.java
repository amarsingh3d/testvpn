package com.thestar.base;
import com.browserstack.local.Local;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.Level;


public class BrowserDriverFactory extends ReadExternalData{
		
	protected WebDriver driver;
	protected String driverPath = "";
	public static final String AUTOMATE_USERNAME = "alex9379";
	public static final String AUTOMATE_ACCESS_KEY = "YvxgmQrJLMq1AgAWCRKQ";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public WebDriverWait wait20 = null;
	public WebDriverWait wait10 = null ;
	public WebDriverWait wait50 = null ;
	public WebDriverWait wait5 = null;
	public WebDriverWait wait = null;
	public int impwait5 = 5;
	public int impwait10 = 10;
	public int ImpliedWait = 1;
	Local BsLocal = new Local();
	

	public void LaunchBrowserLocal(String URL) {
		
		System.out.println("Launching Browser Local");
		if (System.getProperty("os.name").contains("Mac")){
			driverPath = "src/main/resources/Drivers/chromedriver";
		}
		else {
			System.out.print(System.getProperty("os.name"));
			driverPath = "src/main/resources/Drivers/chromedriver.exe";
		}
		if(System.getProperty("os.name").contains("Linux")){
			driverPath = "src/main/resources/Drivers/Linux/chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--fast");
		options.addArguments("window-size=1936,1056");
		options.addArguments("--user-agent=Chrome Web app testing");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		//options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.navigate().to(URL);
				  
		System.out.println("Initiating Explicit wait varialbes");
		wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		impwait5 = 5;
		impwait10 = 10;
		System.out.println("Wait Variables initiated");
	}
	
	
	public void LaunchBrowserLocal_Firefox(String URL) {
		System.out.println("Launching Browser Local");
		if (System.getProperty("os.name").contains("Mac")){
			driverPath = "src/main/resources/Drivers/geckodriver";
		}
		else {
			System.out.print(System.getProperty("os.name"));
			driverPath =  "src/main/resources/Drivers/geckodriver.exe";
		}
	  	System.setProperty("webdriver.gecko.driver", driverPath);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		FirefoxOptions option=new FirefoxOptions();
		firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
		option.setProfile(firefoxProfile);
		driver = new FirefoxDriver(option);
		driver.manage().window().maximize();
		driver.get(URL);
			  
		System.out.println("Initiating Explicit wait varialbes");
		wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
		impwait5 = 5;
		impwait10 = 10;
		System.out.println("Wait Variables initiated");
	}
  	
	public void QuitBrowser() {
		try {
			BsLocal_Close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
  	}

	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}

	@Parameters({"browser", "url", "name"})
	public void LaunchBrowser_Local_OR_BrowserStack(@Optional("browser") String browserXML, @Optional("url") String urlXML, @Optional("url") String name) throws MalformedURLException {

		try {
			BsLocal_Setup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Browser: " + browserXML + "  Environment: " + urlXML);
		System.out.println("Launching Browser");
  
  
		switch (browserXML) {
			//Any new caps can be generated here https://www.browserstack.com/automate/capabilities
		  
		  	case "Windows10_Edge":
				DesiredCapabilities caps = new DesiredCapabilities();
		  		System.out.println("Browser and OS-   " + browserXML);
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Edge");
				caps.setCapability("browser_version", "86.0 beta");
				caps.setCapability("browserstack.local", "true");
				caps.setCapability("browserstack.video", "true");
				caps.setCapability("resolution", "1280x1024");
				caps.setCapability("browserstack.selenium_version", "3.5.2");
				driver = new RemoteWebDriver(new URL(URL), caps);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
		  		
		  
		  	case "Windows10_Chrome":
				DesiredCapabilities caps1 = new DesiredCapabilities();
		  		System.out.println("Browser and OS-   " + browserXML);
				caps1 = new DesiredCapabilities();
				caps1.setCapability("os_version", "10");
				caps1.setCapability("resolution", "1920x1080");
				caps1.setCapability("browser", "Chrome");
				caps1.setCapability("browser_version", "latest");
				caps1.setCapability("os", "Windows");
				caps1.setCapability("browserstack.local", "true");
				caps1.setCapability("browserstack.video", "true");
				driver = new RemoteWebDriver(new URL(URL), caps1) {
				};
				System.out.println("Initiating Explicit wait varialbes");
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
		  
		  	case "Windows10_Firefox":
				DesiredCapabilities caps2 = new DesiredCapabilities();
		  		System.out.println("Browser and OS-   " + browserXML);
				caps2.setCapability("os", "Windows");
				caps2.setCapability("os_version", "10");
				caps2.setCapability("browser", "Firefox");
				caps2.setCapability("resolution", "1280x1024");
				caps2.setCapability("browser_version", "latest");
				caps2.setCapability("browserstack.local", "true");
				caps2.setCapability("browserstack.selenium_version", "3.10.0");
		  		driver = new RemoteWebDriver(new URL(URL), caps2);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
		  	case "Catalina_Safari":
				DesiredCapabilities caps3 = new DesiredCapabilities();
		  		System.out.println("Browser and OS-   " + browserXML);
				caps3.setCapability("os", "OS X");
				caps3.setCapability("os_version", "Catalina");
				caps3.setCapability("browser", "Safari");
				caps3.setCapability("browser_version", "13.1");
				caps3.setCapability("resolution", "1280x1024");
				caps3.setCapability("browserstack.local", "true");
				caps3.setCapability("browserstack.selenium_version", "3.14.0");
		  		driver = new RemoteWebDriver(new URL(URL), caps3);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;

			case "Catalina_Chrome":
				DesiredCapabilities caps4 = new DesiredCapabilities();
				System.out.println("Browser and OS-   " + browserXML);
				caps4.setCapability("os", "OS X");
				caps4.setCapability("os_version", "Catalina");
				caps4.setCapability("browser", "Chrome");
				caps4.setCapability("browser_version", "86.0 beta");
				caps4.setCapability("resolution", "1280x1024");
				caps4.setCapability("browserstack.local", "true");
				caps4.setCapability("browserstack.selenium_version", "3.14.0");
				driver = new RemoteWebDriver(new URL(URL), caps4);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
			case "Windows10_IE11":
				DesiredCapabilities caps5 = new DesiredCapabilities();
				System.out.println("Browser and OS-   " + browserXML);
				caps5.setCapability("os", "Windows");
				caps5.setCapability("os_version", "10");
				caps5.setCapability("browser", "IE");
				caps5.setCapability("browser_version", "11.0");
				caps5.setCapability("browserstack.local", "true");
				caps5.setCapability("browserstack.selenium_version", "3.5.2");
				driver = new RemoteWebDriver(new URL(URL), caps5);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
			case "Local_Chrome": 
				System.out.println("Browser: " + browserXML);
				if (System.getProperty("os.name").contains("Mac")){
					driverPath = "src/main/resources/Drivers/chromedriver";
				}
				else {
					System.out.print(System.getProperty("os.name"));
					driverPath = "src/main/resources/Drivers/chromedriver.exe";
				}
				if(System.getProperty("os.name").contains("Linux")){
					driverPath = "src/main/resources/Drivers/Linux/chromedriver";
				}
				System.setProperty("webdriver.chrome.driver", driverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--fast");
				options.addArguments("window-size=1936,1056");
				options.addArguments("--user-agent=Chrome Web app testing");
				options.addArguments("enable-automation");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-infobars");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--disable-browser-side-navigation");
				options.addArguments("--disable-gpu");
				//options.addArguments("--headless");
				driver = new ChromeDriver(options);
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
			case "Local_Edge": 
				System.out.println("Browser: " + browserXML);
				if (System.getProperty("os.name").contains("Mac")){
					throw new SkipException("This OS doesn't allow to run Edge");
				}
				else {
					System.out.print(System.getProperty("os.name"));
					driverPath = "src/main/resources/Drivers/msedgedriver.exe";
				}
				driverPath = "src/main/resources/Drivers/msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", driverPath);
				driver = new EdgeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
			case "Local_Firefox": 
				System.out.println("Browser: " + browserXML);
				if (System.getProperty("os.name").contains("Mac")){
					driverPath = "src/main/resources/Drivers/geckodriver";
				}
				else {
					System.out.print(System.getProperty("os.name"));
					driverPath =  "src/main/resources/Drivers/geckodriver.exe";
				}
			  	System.setProperty("webdriver.gecko.driver", driverPath);
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				FirefoxOptions option=new FirefoxOptions();
				firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
				option.setProfile(firefoxProfile);
				driver = new FirefoxDriver(option);
				driver.manage().window().maximize();
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;

			case "Local_Safari":
				System.out.println("Browser: " + browserXML);
				if (System.getProperty("os.name").contains("Mac")){
					driverPath = "/usr/bin/safaridriver";
				}
				else {
					System.out.print(System.getProperty("os.name"));
					throw new SkipException("This OS doesn't allow to run Safari");
				}
				SafariOptions safariOptions = new SafariOptions();
				safariOptions.getAutomaticProfiling();
				driver = new SafariDriver(safariOptions);
				driver.manage().window().maximize();
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
			case "Local_Chrome_Console": 
				System.out.println("Browser: " + browserXML);
				if (System.getProperty("os.name").contains("Mac")){
					driverPath = "src/main/resources/Drivers/chromedriver";
				}
				else {
					System.out.print(System.getProperty("os.name"));
					driverPath = "src/main/resources/Drivers/chromedriver.exe";
				}
				if(System.getProperty("os.name").contains("Linux")){
					driverPath = "src/main/resources/Drivers/Linux/chromedriver";
				}
				System.setProperty("webdriver.chrome.driver", driverPath);
				ChromeOptions optionschrome1 = new ChromeOptions();
				optionschrome1.addArguments("--incognito");
				optionschrome1.addArguments("window-size=1936,1056");
				optionschrome1.addArguments("--fail-never test");
				optionschrome1.addArguments("--headless");
				LoggingPreferences prefs = new LoggingPreferences();
		        prefs.enable(LogType.BROWSER, Level.ALL);
				driver = new ChromeDriver(optionschrome1);
				driver.manage().window().maximize();
				driver.navigate().to(urlXML);
				wait50 = new WebDriverWait(driver, Duration.ofSeconds(50));
				wait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
				impwait5 = 5;
				impwait10 = 10;
				System.out.println("URL-   " + urlXML);
				break;
				
		  	}
	}

	public static void killPreviousProcess(String passToFile) {
		try {
			File file = new File(passToFile);
			file.setWritable(true);
			file.setReadable(true);
			file.setExecutable(true);
			Process proc = Runtime.getRuntime().exec("src/main/resources/Drivers/bs_stop.sh");
			BufferedReader read = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));

			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void BsLocal_Setup() throws Exception {
		killPreviousProcess("src/main/resources/Drivers/bs_stop.sh");
		killPreviousProcess("src/main/resources/Drivers/bs_stop_port_45690.sh");
		System.out.println("Setting Up Browser Stack Local Connection");
		HashMap<String, String> BsLocalArgs = new HashMap<String, String>();
		BsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);
		BsLocal.start(BsLocalArgs);
		System.out.println("Browser Stack Is Running: " + BsLocal.isRunning());
	
	}
	
	public void BsLocal_Close() throws Exception {
		System.out.println("Start: Closing Browser Stack Local Setup");
		BsLocal.stop();
		killPreviousProcess("src/main/resources/Drivers/bs_stop.sh");
		killPreviousProcess("src/main/resources/Drivers/bs_stop_port_45690.sh");
		System.out.println("End: Closing Browser Stack Local Setup");

	}


		
}


