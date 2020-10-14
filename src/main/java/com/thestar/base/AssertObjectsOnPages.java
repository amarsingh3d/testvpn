package com.thestar.base;

import com.google.errorprone.annotations.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;


public class AssertObjectsOnPages {

	 public void assertTopHatContainer(BaseTestPageAndObjects localObj){
			 
		 System.out.println("Start: Asserting Grey Banner");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.className("o-tophat-container")));
		 System.out.println("End: Asserting Grey Banner");
			   
	 }
	 
	 public void AssertSubscribeButton(BaseTestPageAndObjects localObj){
		 waitInSeconds(5);
		 System.out.println("Start: Asserting Subscribe button");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//a[@class='c-button c-button--subscribe alcta c-button--subscribe--desktop c-button--subscribe--visible']")));
		 System.out.println("End: Asserting Subscribe button");
	 }

	 public void AssertSubscribeButtonBasic(BaseTestPageAndObjects localObj){
		 System.out.println("Start: Asserting Subscribe button");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//p[contains(text(),'Newsletters')]")));
		 System.out.println("End: Asserting Subscribe button");
			   
	 }
	 
	 public void AssertSignIn_Button(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Sign In button");
		 Assert.assertTrue(localObj.check_object_Wait(30, By.id("signin")));
		 System.out.println("End: Asserting Sign In button");
	 }
	 
	 public void AssertChangeLocationIcon(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Change Location Icon");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".o-nav-location-desktop .material-icons")));
		 System.out.println("End: Asserting Change Location Icon");
	 }
	 
	 public void AssertChangeLocationText(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Change Location Text");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".o-nav-location-desktop .o-two-row-paragraph--subtitle")));
		 System.out.println("End: Asserting Change Location Text");
			   
	 }
	 
	 public void AssertToaster(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Toaster");
		 try {
			 Assert.assertTrue(localObj.check_object_Wait(10, By.className("c-meter")));
		 }
		 catch (NoSuchElementException ex){
		 	throw new SkipException("Looks like this env turned off toaster on home page report an issue if not");
		 }
		 System.out.println("End: Asserting Toaster");
		   }
	 
	 public void AssertTheStarLogo(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting The Star Logo");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='o-hero-header-container']")));
		 System.out.println("End: Asserting The Star Logo");
			   
		   }
	 
	 public void AssertAlertBanner(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Alert Banner");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".alert-banner-container__alert-banner-category")));
		 System.out.println("End: Asserting Alert Banner");
			   
		   }
	 
	 public void AssertWidgetSection(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Widget Section");
		 Assert.assertTrue(localObj.check_object(By.xpath("//div[@class='ont-units-widget-container']")));
		 System.out.println("End: Asserting Widget For You Section");
			   
	 }

	 
	 public void AssertSearchOption(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Search Option");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(".c-button--search > .material-icons")));
		 System.out.println("End: Asserting Search Option");
			   
		   }
	 
	 public void AssertOpinion(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting Right Rail");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[contains(text(),'Opinion')]")));
		 System.out.println("End: Asserting Right Rail");
			   
		   }

	 public void AssertSocialIcons(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting Social Icons");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(".o-site-footer__social-icons")));
		 System.out.println("End: Asserting Social Icons");
			   
		   }
	 
	 public void AssertAppStoreIcon(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting App Store Icon");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(".o-site-footer__social-icons--app-store > img")));
		 System.out.println("End: Asserting App Store Icon");
			   
		   }
	 
	 public void AssertPlayStoreIcon(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting Play Store Icon");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(".o-site-footer__social-icons--play-store > img")));
		 System.out.println("End: Asserting Play Store Icon");
			   
		   }
	 
	 public void AssertCopyrightText(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting Copyright Text");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(".c-legal-footer__copyright:nth-child(1)")));
		 System.out.println("End: Asserting Copyright Text");
			   
		   }
	 	 
	 public void AssertAddressText(BaseTestPageAndObjects localObj){
			
		 System.out.println("Start: Asserting Address Text");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".c-legal-footer__copyright:nth-child(2)")));
		 System.out.println("End: Asserting Address Text");

		   }

	 public void AssertMarketingPanel(BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Marketing Panel");
		Assert.assertTrue(localObj.check_object(By.xpath("//strong[@class='c-engagement-panel__card-title']")));
		Assert.assertTrue(localObj.check_object(By.xpath("//p[@class='c-engagement-panel__card-description']")));
		Assert.assertTrue(localObj.check_object(By.xpath("//p[@class='c-engagement-panel__card-description']")));
		Assert.assertTrue(localObj.check_object(By.xpath("//div[@class='c-engagement-panel c-engagement-panel--horizontal']")));
		System.out.println("End: Asserting AssertMarketing Panel");

	       }
	
	 public static void AssertOverlay(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Overlay");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='overlayRightPanel']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='overlayDigitalAccess']")));
		 System.out.println("End: Asserting Overlay");
			   
		   }
	 
	 public void assertMeterArticle(BaseTestPageAndObjects localObj){
	
		 System.out.println("Start: Asserting Meter on Article 1 to 4");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='c-article-meter-banner']")));
		 System.out.println("End: Asserting Meter on Article 1 to 4");
			   
		   }
	 
	 public void assertHardWall(BaseTestPageAndObjects localObj){
		
		 System.out.println("Start: Asserting Hard Wall");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.className("basic-paywall-new")));
		 System.out.println("End: Asserting Hard Wall");
		   }

	public void assertAMPHardWall(BaseTestPageAndObjects localObj){
		System.out.println("Start: Asserting AMP Hard Wall");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//section[@amp-access=\"NOT authorized AND wallType = 'manual'\"]")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//p[@class='c-paywall__paragraph2']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//p[@class='c-paywall__paragraph1']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//h2[@class='c-paywall__heading2']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//h3[@class='c-paywall__heading1']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//footer[@class='c-paywall__footer-text']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//a[@class='c-paywall__subscribe-button']")));
		System.out.println("End: Asserting AMP Hard Wall");
		}
	 
	 
	 public void AssertMeteredWall(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Metered Wall");
		 Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//div[@class='paragraph_2']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='paragraph_1']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='paragraph_3']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//a[@class='paywallButton c-button--meter-wall alcta']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='basic-paywall-new']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//a[@class='homeBarLink']")));
		 System.out.println("End: Asserting Metered Wall");
		  }
	 
	 public void AssertPremiumwall(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Premium Wall");
		 Assert.assertTrue(localObj.check_object_Wait(30, By.id("signin")));
		 System.out.println("End: Asserting Premium Wall");
		 Assert.assertTrue(localObj.check_object(By.className("premium-wrap")));
			   
	 }
	 
	 public void AssertToaster_False(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Toaster as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.className("meter-banner")));
		 System.out.println("End: Asserting Toaster as False");
			   
		   }
	 
	 public void AssertOverlay_true(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Overlay as True");
		 Assert.assertFalse((localObj.checkObjectIsPresent(By.className("digitalAccessOverlayContainer"))));
		 System.out.println("End: Asserting Overlay as True");
			   
		   }
	 
	 public void AssertMeterArticle_1to4_false(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Meter on Article 1 to 4 as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.className("meterText")));
		 System.out.println("End: Asserting Meter on Article 1 to 4 as False");
			   
		   }
	 
	 public void AssertMeterArticle_5_false(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Meter on Article 5 as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.className("meterCotentBox")));
		 System.out.println("End: Asserting Meter on Article 5 as False");
			   
		   }
	 
	 public void AssertHardwall_true(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Hard Wall as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.className("basic-paywall-new")));
		 System.out.println("End: Asserting Hard Wall as False");
			   
		   }
	 
	 public void AssertPremiumwall_False(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Premium Wall as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.className("premium-wrap")));
		 System.out.println("End: Asserting Premium Wall as False");
			   
		   }

	 public void AssertSubscribeButton_False(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Subscribe Button as False");
		 Assert.assertFalse(localObj.checkObjectIsPresent(By.cssSelector(".c-button:nth-child(4) .c-button__text--title")));
		 System.out.println("End: Asserting Subscribe Button as False");
			   
		   }

	 public void AssertNewsLetters(BaseTestPageAndObjects localObj) {
		 System.out.println("Start: Asserting NewsLetter page ");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='newsletter-subscription-title']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='newsletter-section-title']")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='selector']")));
		 System.out.println("End: Asserting NewsLetter page");

	 }

	public void AssertNewsLettersSubscribedNotPreset(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting NewsLetter page ");
		Assert.assertFalse(localObj.checkObjectIsPresent(By.xpath("//div[@class='newsletter-subscription-update-form__validation-message']")));
		Assert.assertFalse(localObj.checkObjectIsPresent(By.xpath("//h2[@class='newsletter-subscription-update-form__paragraph1']")));
		Assert.assertFalse(localObj.checkObjectIsPresent(By.xpath("//*[@id='email']")));
		Assert.assertFalse(localObj.checkObjectIsPresent(By.xpath("//span[@class='MuiButton-label']")));
		System.out.println("End: Asserting NewsLetter page");

	}

	public void AssertNewsLettersSignIn(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting NewsLetter sign up form ");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='newsletter-subscription-update-form__validation-message']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//h2[@class='newsletter-subscription-update-form__paragraph1']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id='email']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//span[@class='MuiButton-label']")));
		System.out.println("End: Asserting NewsLetter sign up form");

	}
	 
	 public void AssertNewsLettersSubscribed(BaseTestPageAndObjects localObj) {
		 
		 System.out.println("Start: Asserting All News Letters Are Subscribed");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//span[@class=\"paragraph2\"]")), "First paragraph not present");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//span[@class=\"paragraph1\"]")), "Second paragraph not present");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"body-content\"]/div/div/div[1]/div/a")), "Success button not present");
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class=\"component\"]")), "Privacy component not present");
		 System.out.println("End: Asserting All News Letters Are Subscribed");
	 }
	 
	public void AssertYMBII_8orLess(BaseTestPageAndObjects localObj) {
		 
		System.out.println("Start: Asserting YMBII 8 or Less");
		String SSObjName = "articles-related-footer-container"; 
		
		switch (localObj.signinpage) {
		case "https://reactqa2.smgdigitaldev.com/sign-in":
			Assert.assertEquals(localObj.check_object_Class(By.xpath("//*[@id=\"body-content\"]/div[1]/div[4]")), SSObjName);
			break;
		case "https://uat2.thestar.com/sign-in":
			Assert.assertEquals(localObj.check_object_Class(By.xpath("//*[@id=\"body-content\"]/div[1]/div[5]")), SSObjName);
			break;
			
			
	}
		System.out.println("End: Asserting YMBII 8 or Less");
	}
	

	public void AssertPageURL(String currentURL, String URLFor, BaseTestPageAndObjects localObj, String url) {

		String expectedURL = localObj.Page_URL(URLFor,url);
		waitInSeconds(3);
		System.out.println("Asserting URL for" + URLFor);
		Assert.assertEquals(currentURL, expectedURL);
			
	}
	
	public void AssertReaderChoicePage_Login_Vote(BaseTestPageAndObjects localObj) {
		
		String objectclass = "";
		waitInSeconds(6);
		Boolean objectpresent = localObj.checkObjectIsPresent(By.cssSelector(".fa-check-circle > path"));
		
		System.out.println("Object is    " + objectpresent);
		
		if (objectpresent == true) {
			System.out.println("Confirmed user already voted");
			Assert.assertTrue(objectpresent);
		}
		else if(objectpresent == false){
			//objectclass = "NoName";
			System.out.println("Checking if user can vote");
			localObj.clickVote();
			Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".fa-check-circle > path")));
			System.out.println("Confirmed user can vote");
		}
		else {
			System.out.println("Checking if user can vote");
			localObj.clickVote();
			Assert.assertEquals(localObj.check_object_Class(By.className("success-wrapper")), "success-wrapper");
			System.out.println("Confirmed user can vote");
		}
		
		}

	public void AssertEmailFieldValue(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Email Field is Auto Populated on Express Checkout Page");
		Assert.assertEquals(localObj.check_object_Value(By.xpath("//input[@name='email']")), localObj.usernamereg);
			
	}
	
	public void assertEmailFieldReadOnly(BaseTestPageAndObjects localObj) {

		System.out.println("Asserting Email Field is Read Only on Express Checkout Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.EXPRESS_CHECKOUT_EMAIL_FIELD_READ_ONLY.toString())));
		Assert.assertNotEquals(localObj.check_object_Value(By.xpath(Variables.EXPRESS_CHECKOUT_EMAIL_INPUT.toString())), "newvalue");
			
	}
	
	public void AssertConversationWidget(BaseTestPageAndObjects localObj)   {
		 
		 String BadgeText = "JOIN THE CONVERSATION(0)";
		 System.out.println("Asserting Time Stamp is Above Badge");
		 Assert.assertEquals(localObj.scroll_check_object_Text(By.xpath("//*[@id=\"conversations\"]/div[1]")), BadgeText);
		 Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//*[@id=\"conversations\"]/div[2]/p")));
		 Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"conversations\"]/div[1]")));

	}

	
	public void AssertCompleteProfilePage (BaseTestPageAndObjects localObj) {

		System.out.println("Start: Asserting Complete Profile Page is loaded");
		Assert.assertFalse(localObj.checkObjectIsPresent(By.className("content-form__header")));
		System.out.println("End: Asserting Complete Profile Page is loaded");

	}

	
	public void AssertYMBIIArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting YMBII on Article Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.YMBII_ARTICLE_BLOCK.toString())));
		System.out.println("End: Asserting YMBII on Article Page");

	}
	
	public void assertEndOfArticleComponent(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting end of article component");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"end-of-article\"]")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"end-of-article\"]/div[2]/div[1]/a/span[1]")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"end-of-article\"]/div[2]/div[2]/button/span[1]")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//span[contains(text(),'Show')]")));
		System.out.println("End: Asserting end of article component");

	}
	
	public void AssertShareTextArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Share Text on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".share-label-text")));
		System.out.println("End: Asserting Share Text on Article Page");

	}
	
	public void AssertShareFacebookArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Facebook Icon on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".share-icon-anchor > .staricon-facebook-basic")));
		System.out.println("End: Asserting Facebook Icon on Article Page");

	}
	
	public void AssertShareTwitterArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Twiter Icon on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".share-icon-anchor > .staricon-twitter-basic")));
		System.out.println("End: Asserting Twiter Icon on Article Page");

	}
	
	public void AssertShareEmailArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Email Icon on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".staricon-email-basic")));
		System.out.println("End: Asserting Email Icon on Article Page");

	}
	
	public void AssertConversationWidgetArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Conversation Widget on Article Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".c-conversation-title")));
		System.out.println("End: Asserting Conversation Widget on Article Page");

	}
	
	public void AssertReportAnErrorArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Report An Error on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".trust-item-report-error")));
		System.out.println("End: Asserting Report An Error on Article Page");

	}
	
	public void AssertAboutTheStarArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting About The Star on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".trust-item-about-star")));
		System.out.println("End: Asserting About The Star on Article Page");

	}
	
	public void AssertSeeMoreArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting See More on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".c-more-articles > .article-list-heading")));
		System.out.println("End: Asserting See More on Article Page");

	}
	
	public void AssertTopStoriesArticlePage(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Top Stories on Article Page");
		Assert.assertTrue(localObj.check_object(By.cssSelector(".c-top-articles > .article-list-heading")));
		System.out.println("End: Asserting Top Stories on Article Page");

	}
	
	public void AssertEmailCreated(String EmailMessage) {
		System.out.println("Start: Asserting Email Created");
		Assert.assertEquals(EmailMessage, "Success", "Message is not success");
		System.out.println("End: Asserting Email Created");

	}
	
	public void assertEmailVerificationLinkSent(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Email Verification Link Sent");
		Assert.assertTrue(localObj.check_object(By.cssSelector("#emailVerificationRequired .janrain_header")));
		System.out.println("End: Asserting Email Verification Link Sent");

	}
	
	public void AssertRegistrationSuccess(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Registration Success");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//button[@class='c-rsb__button c-rsb__button--thestar']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//h1[@class='c-rsb__head1']")));
		//below property can be configurated from AEM
		//Assert.assertTrue(localObj.check_object(By.xpath("//button[@class='c-registration-success-daps__button c-registration-success-daps__button--thestar']"))); not avalible in prod
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='o-contact-us-dropdown-button']")));
		System.out.println("End: Asserting Registration Success");

	}
	
	public void AssertBrandLogo(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.check_object(By.cssSelector(".logo")));
	}
	
	public void AssertRCLogo(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.check_object(By.cssSelector(".styled__Logo-ppk3y2-1")));
	}
	
	public void assertSignInButton(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Sign in")));
	}

	
	public void AssertFAQ(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("FAQ")));
	}
	
	public void AssertPrivacyPolicy(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Privacy Policy")));
	}
	
	public void AssertTandC(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Terms & Conditions")));
	}
	
	public void AssertLeaderBoard(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div[1]")));
		
	}
	
	public void AssertBusinessSearchBox(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".react-autosuggest__input")));
	}
	
	public void AssertAutomotive(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Automotive Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Automotive")));
	}
	
	public void AssertEntertainment(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Entertainment Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Entertainment")));
	}
	
	public void AssertFood_Drink_Grocery(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Food / Drink / Grocery Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Food / Drink / Grocery")));
	}
	
	public void AssertHealth_Fitness_Wellness_Beauty(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Health / Wellness / Fitness / Beauty Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Health / Wellness / Fitness / Beauty")));
	}
	
	public void AssertHome_HomeImprovement(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Home / Home Improvement Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Home / Home Improvement")));
	}
	
	public void AssertPeople_Professionals(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting People / Professionals Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("People / Professionals")));
	}
	
	public void AssertProfessionalServices(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Professional Services Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Professional Services")));
	}
	
	public void AssertRestaurant(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Restaurant Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Restaurant")));
	}
	
	public void AssertShopping(BaseTestPageAndObjects localObj) {
		System.out.println("Asserting Shopping Link on RC Page");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.linkText("Shopping")));
	}
	
	public void AssertVotingOpened(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Votting is Opened on RC Page");
		if(localObj.check_object_Text(By.xpath("//h2")).equals("Official selection on now")){
			String votingMessage = "Official selection on now";
			Assert.assertEquals(localObj.check_object_Text(By.xpath("//h2")), votingMessage);
		}
		else {
			String votingMessage = "Voting Now Open";
			Assert.assertEquals(localObj.check_object_Text(By.xpath("//h2")), votingMessage);
		}
		System.out.println("End: Asserting Votting is Opened on RC Page");
	}
	
	public void AssertSubCategoryRCLogo(BaseTestPageAndObjects localObj) {
		
		Assert.assertTrue(localObj.check_object(By.cssSelector(".sc-bdVaJa img")));
				
	}
	
	public void AssertSubCategoryLeaderBoard(BaseTestPageAndObjects localObj) {
	
		Assert.assertTrue(localObj.check_object(By.xpath("//*[@id=\"__next\"]/div/div/header/div/div[1]")));
	
	}
	
	public void assertBorderColorText(BaseTestPageAndObjects localObj){
		waitInSeconds(10);
		String BorderColor = "rgba(51, 51, 51, 1)";
		Assert.assertEquals(localObj.Color_Match(By.linkText("Dutch investigators"), "border-bottom-color"), BorderColor);
		
	}
	
	public void assertBackgroundColorText(BaseTestPageAndObjects localObj) {
		waitInSeconds(10);
		String BackGroundColor = "rgba(100, 205, 245, 0.45)";
		Assert.assertEquals(localObj.Color_Match(By.linkText("Dutch investigators"), "background-color"), BackGroundColor);
		
	}
	
	public void Assert_PixelParsely_PageView(BaseTestPageAndObjects localObj) {
		
		String pageview = localObj.parsely_pageview();
		//System.out.println(pageview);
		Assert.assertEquals("action=pageview", pageview);
	
	}
	
	public void Assert_QueryPetametrics_stuck_10s(BaseTestPageAndObjects localObj) {
		
		String stuck_10s = localObj.petametrics_stuck_10s();
		Assert.assertEquals("e=stuck_10s", stuck_10s);
	
	}
	
	public void Assert_QueryPetametrics_widget_shown(BaseTestPageAndObjects localObj) {
		
		String widget_shown = localObj.petametrics_widget_shown();
		Assert.assertEquals("e=widget_shown", widget_shown);
	
	}
	
	public void Assert_torontodnnlocalqa(BaseTestPageAndObjects localObj) {
		
		System.out.println("Start: Asserting torontodnnlocalqa");
		String torontodnnlocalqa = localObj.torontodnnlocalqa();
		Assert.assertEquals(torontodnnlocalqa, localObj.find_torontodnnlocal);
		System.out.println("End: Asserting Assert_torontodnnlocalqa");
	
	}
	
	public void Assert_thestardesktopdev(BaseTestPageAndObjects localObj) {
		
		System.out.println("Start: Asserting Athestardesktopdev");
		String torontodnnlocaldev = localObj.thestardesktopdev();
		Assert.assertEquals(torontodnnlocaldev, localObj.find_thestardesktop);
		System.out.println("End: Asserting Athestardesktopdev");
	
	}
	
	public void assertSignInPageLoaded(BaseTestPageAndObjects localObj) {
		
		System.out.println("Start: Asserting Sign In Page Loaded");
		Assert.assertTrue(localObj.check_object_Wait(10, By.id("capture_signIn_signInEmailAddress")));
		System.out.println("End: Asserting Sign In Page Loaded");
	
	}
	
	public void Assert_Trust_Label(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Trust label");
		 Assert.assertTrue(localObj.check_object(By.cssSelector(" .staricon-trust-icon")));
		 System.out.println("End: Asserting Trust label");
		
	}
	
	public void Assert_Search_Box(BaseTestPageAndObjects localObj){
		 
		 System.out.println("Start: Asserting Doctor Search Box");
		 Assert.assertTrue(localObj.check_object(By.id("DoctorDatabaseSearchInput")));
		 System.out.println("End: Asserting Doctor Search Box");
			   
	}
	
		public void Assert_Doctor_Found(BaseTestPageAndObjects localObj){
		 
			System.out.println("Start: Asserting Doctor Found");
			Assert.assertTrue(localObj.check_object(By.cssSelector(".rt-tr-group:nth-child(2) .rt-td:nth-child(2)")));
			System.out.println("End: Asserting Doctor Found");
			   
		}
		
		public void Assert_thespec_email(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Email Field");
			Assert.assertTrue(localObj.check_object(By.xpath("//input[@placeholder='Email']")));
			System.out.println("End: Asserting Email Field");
		}
		
		public void assertAMPPageStarLogo(BaseTestPageAndObjects localObj) {
			 
			System.out.println("Start: Asserting Amp Page is Loaded by checking Star Logo");
			Assert.assertTrue(localObj.check_object_Wait(10, By.cssSelector(".main-logo .i-amphtml-fill-content")));
			System.out.println("End: Asserting Amp Page is Loaded by checking Star Logo");
		 }
		
		public void assertPaymentPageLoaded(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Payment Page Loaded");
			Assert.assertTrue(localObj.check_object_Wait(140, By.id("number")));
			System.out.println("End: Asserting Payment Page Loaded");
		}
		
		public void Assert_PayPal_SignIn_Page(Boolean PayPalSignInPageLoaded) {
			System.out.println("Start: Asserting Pay Pal SignIn Page Loaded");
			Assert.assertTrue(PayPalSignInPageLoaded);
			System.out.println("End: Asserting Pay Pal SignIn Page Loaded");
		}
		
		public void Assert_SignedIn_InTo_PayPal (Boolean Signedin) {
			System.out.println("Start: Asserting Signed In InTo Pay Pal Account");
			Assert.assertTrue(Signedin);
			System.out.println("End: Asserting Signed In InTo Pay Pal Account");
			
		}
		
		public void AssertTopicHeadlingLink(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Heading Link on Topic Page");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".article-list-heading__link")));
			System.out.println("End: Asserting Heading Link on Topic Page");

		}
		
		public void AssertTopicArticleListContainer(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Article List Container on Topic Page");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector(".c-feature-article-list")));
			System.out.println("End: Asserting Article List Container on Topic Page");

		}
		
		public void AssertTopicMediaCardHeadLine(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Media Card Head Line on Topic Page");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.TOPIC_MEDIA_CARD_HEADING.toString())));
			System.out.println("End: Asserting Media Card Head Line on Topic Page");

		}
		
		public void AssertTopicMediaCardAbstract(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Media Card Abstarct on Topic Page");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.TOPIC_MEDIA_CARD_IMAGE.toString())));
			System.out.println("End: Asserting Media Card Abstract on Topic Page");

		}
		
		public void AssertTopicArticleList2Columns(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Article List 2 Columns on Topic Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-article-list-flex--2columns")));
			System.out.println("End: Asserting Article List 2 Columns on Topic Page");

		}
		
		public void AssertTopicGoogleAdSlot(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Google Ad Slot on Topic Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-googleadslot__heading")));
			System.out.println("End: Asserting Google Ad Slot on Topic Page");

		}
		
		public void AssertTopicSearchForMoreStoriesOnTheTopic(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting 'Search For More Stories On The Topic' on Topic Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.linkText("Search for more stories on this topic")));
			System.out.println("End: Asserting 'Search For More Stories On The Topic' on Topic Page");

		}
		
		public void AssertAutorTitle(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Autor Title on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-author-profile-name")));
			System.out.println("End: Asserting Autor Title on Author Page");

		}
		
		public void AssertAutorImage(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Autor Image on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-author-badge__img")));
			System.out.println("End: Asserting Autor Image on Author Page");

		}
		
		public void AssertAuthorProfileName(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Autor Profile Name on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-author-profile-name")));
			System.out.println("End: Asserting Autor Profile Name on Author Page");

		}
		
		public void AssertAuthorProfileDescription(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Autor Profile Description on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-author-profile-container-items > span")));
			System.out.println("End: Asserting Autor Profile Description on Author Page");

		}
		
		public void AssertArticlesByAuthor(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Article By Author on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".article-list-heading-text")));
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-author-information-articlelist-container")));
			System.out.println("End: Asserting Article By Author on Author Page");

		}
		
		public void AssertAuthorGoogleAdSlot(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Google Ad Slot on Author Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".article-list-heading-text")));
			System.out.println("End: Asserting Google Ad Slot on Author Page");

		}
		
		public void AssertAuthorViewMore(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting 'View More");
			Assert.assertTrue(localObj.check_object_Wait(20, By.linkText("View More")));
			System.out.println("End: Asserting 'View More");

		}
		
		public void AssertTheStarEditionDropDown(Boolean DropDown) {
			System.out.println("Start: Asserting The Star Edition City Drop Down");
			Assert.assertTrue(DropDown);
			System.out.println("End: Asserting The Star Edition City Drop Down");

		}
		
		public void AssertCitiesInDropDown(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Cities In Drop Down");
			
			System.out.println("Start: Toronto");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Toronto')]")));
			System.out.println("End: Toronto");
			
			System.out.println("Start: Vancouver");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Vancouver')]")));
			System.out.println("End: Vancouver");
			
			System.out.println("Start: Calgary");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Calgary')]")));
			System.out.println("End: Calgary");
			
			System.out.println("Start: Edmonton");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Edmonton')]")));
			System.out.println("End: Edmonton");
			
			System.out.println("Start: Winnipeg");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Winnipeg')]")));
			System.out.println("End: Winnipeg");
			
			System.out.println("Start: Ottawa");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Ottawa')]")));
			System.out.println("End: Ottawa");
			
			System.out.println("Start: Halifax");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//button[contains(.,'Halifax')]")));
			System.out.println("End: Halifax");
						
			System.out.println("End: Asserting Cities In Drop Down");

		}
		
		public void AssertCartoonEditorialCartoonLabel(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Editorial Cartoon Label on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".label-flag")));
			System.out.println("End: Asserting Editorial Cartoon Label on Cartoon Page");

		}
		
		public void AssertCartoonArticleHeadLine(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Article Head Line on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.xpath("//h1[contains(.,'Theo Moudakis: Pants on fire')]")));
			System.out.println("End: Asserting Article Head Line on Cartoon Page");

		}
		
		public void AssertCartooImageBody(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Image Body on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".image__body > img")));
			System.out.println("End: Asserting Image Body on Cartoon Page");

		}
		
		public void AssertCartoonRelatedArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Related Articles on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-related-articles .article-list-heading-text")));
			System.out.println("End: Asserting Related Articles on Cartoon Page");

		}
		
		public void AssertCartoonMoreArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting More Articles on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-more-articles .article-list-heading-text")));
			System.out.println("End: Asserting More Articles on Cartoon Page");

		}
		
		public void AssertCartoonPartnerArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Partner Articles/More From on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-partner-articles .article-list-heading-text")));
			System.out.println("End: Asserting Parnter Articles/More From on Cartoon Page");

		}
		
		public void AssertCartoonTopStories(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Top Stories on Cartoon Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-top-articles .article-list-heading-text")));
			System.out.println("End: Asserting Top Stories on Cartoon Page");

		}
		
		public void AssertProfilePageCompleted(Boolean ProfilePageCompleted) {
			System.out.println("Start: Asserting Profile Page is Completed");
			Assert.assertTrue(ProfilePageCompleted);
			System.out.println("End: Asserting Profile Page is Completed");

		}
		
		public void AssertAutoLogin(BaseTestPageAndObjects localObj) {
			
			System.out.println("Start: Asserting AutoLogin");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.HOME_PAGE_USER.toString())));
			System.out.println("End: Asserting AutoLogin");

		}
		
		public void AssertVideoYMBIINotPresent(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting YMBII Not Present on Video Page");
			Assert.assertFalse(localObj.checkObjectPresentImpliedWait(5, By.cssSelector(".c-related-articles .article-list-heading-text")));
			System.out.println("End: Asserting YMBII Not Present on Video Page");

		}
		
		public void AssertVideoLeaderBoardAd(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Leader Board Ad on Video page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-googleadslot--728x90 .c-googleadslot__heading")));
			System.out.println("End: Asserting Leader Board Ad on Video page");

		}
		
		public void AssertVideoMoreArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting More Articles on Video Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-more-articles .article-list-heading-text")));
			System.out.println("End: Asserting More Articles on Video Page");

		}
		
		public void AssertVideoPartnerArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Partner Articles/More From on Video Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-partner-articles .article-list-heading-text")));
			System.out.println("End: Asserting Parnter Articles/More From on Video Page");

		}
		
		public void AssertVideoTopStories(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Top Stories on Video Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-top-articles .article-list-heading-text")));
			System.out.println("End: Asserting Top Stories on Video Page");

		}
		
		public void AssertSlideShowLeaderBoardAd(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Leader Board Ad on SlideShow page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-googleadslot--728x90 .c-googleadslot__heading")));
			System.out.println("End: Asserting Leader Board Ad on SlideShow page");

		}
		
		public void AssertSlideShowMoreArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting More Articles on SlideShow Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-more-articles .article-list-heading-text")));
			System.out.println("End: Asserting More Articles on SlideShow Page");

		}
		
		public void AssertSlideShowPartnerArticles(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Partner Articles/More From on SlideShow Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-partner-articles .article-list-heading-text")));
			System.out.println("End: Asserting Parnter Articles/More From on SlideShow Page");

		}
		
		public void AssertSlideShowTopStories(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Top Stories on SlideShow Page");
			Assert.assertTrue(localObj.check_object_Wait(20, By.cssSelector(".c-top-articles .article-list-heading-text")));
			System.out.println("End: Asserting Top Stories on SlideShow Page");

		}
		
		public void AssertSponsoredArticlePayWallNotPresent(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting Pay Wall Is Not Present on Sponsored Article Page");
			Assert.assertFalse(localObj.checkObjectPresentImpliedWait(5, By.className("basic-paywall-new")));
			System.out.println("End: Asserting Pay Wall Is Not Present on Sponsored Article Page");

		}
		
		public void AssertUserSignedInSuccessfully(BaseTestPageAndObjects localObj) {
			
			System.out.println("Start: Asserting User Signed In SuccessFully");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.HOME_PAGE_USER.toString())));
			System.out.println("End: Asserting User Signed In SuccessFully");
			
		
		}
		
		public void AssertInvalidURL404NotFound(BaseTestPageAndObjects localObj) {
			System.out.println("Start: Asserting 404 Not Found Appears For Invalid URL");
			Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath(Variables.PAGE_NOT_FOUND.toString())));
			System.out.println("End: Asserting 404 Not Found Appears For Invalid URL");
			waitInSeconds(3);
		
		}
		
		public void AssertPageNotInvalid(BaseTestPageAndObjects localObj){
			
			System.out.println("Start: Asserting Page is Not Invalid");
			Assert.assertFalse(localObj.checkObjectPresentImpliedWait(5, By.xpath("//h1[contains(text(),'Sorry, the page you were looking for is not available')]")));
			System.out.println("End: Asserting Page is Not Invalid");
			waitInSeconds(3);
		
		}
		
		public void AssertMeteredWall_false(BaseTestPageAndObjects localObj){
			 
			 System.out.println("Start: Asserting Metered Wall on Article 5 as False");
			 Assert.assertFalse(localObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_FORM.toString())));
			 System.out.println("End: Asserting Metered Wall on Article 5 as False");
				   
		}
		
		public void AssertEmeterCall(BaseTestPageAndObjects localObj) {
			
			System.out.println("Start: Asserting Emeter Call");
			String Parameter = "emeter";
			Assert.assertTrue(localObj.ContainsCheck(localObj.newnetData, Parameter));
			System.out.println("End: Asserting Emeter Call");
		
		}
		
		public void assertAdobeTokenProperty(BaseTestPageAndObjects localObj, String Asserting, String Property) {
			System.out.println("AdobeTokens data " + localObj.ConsoleData+"\n");
			System.out.println("data for assert   "+ Property);
			System.out.println("Start: Asserting: " + Asserting);
			Assert.assertTrue(localObj.ContainsCheck(localObj.ConsoleData, Property));
			System.out.println("End: Asserting: " + Asserting);
		
		}


	public void assertSubscriptionIsAdded(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting Subscription added block");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//h3[contains(text(),'Digital Access')]")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='order-description']")));
		System.out.println("End: Asserting Grey Banner");
	}
	public void assertDAPSSubscriptionIsAdded(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting Subscription added block");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//h3[contains(text(),'Home Delivery Subscriber')]")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='order-description']")));
		System.out.println("End: Asserting Grey Banner");
	}

	public void assertMobileInlayTrue(BaseTestPageAndObjects baseTestObj){
		System.out.println("Start: Asserting MobileInlay on Article as True");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.MOBILE_INLAY_SIGN_IN_LINK.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.MOBILE_INLAY_CLOSE_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.MOBILE_INLAY_P1.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.MOBILE_INLAY_P2.toString())));
		System.out.println("End: Asserting Meter on Article 1 to 4 as False");

	}

	public void assertDAPSPageLoaded(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting DAPS page");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath("//div[@class=\"o-daps-form-main\"]")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class=\"c-daps-form-banner\"]")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='c-daps-form-details']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-contact-us-dropdown-container']")));
		System.out.println("End: Asserting DAPS page");
	}

	public void assertDAPSSuccessPage(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting DAPS subscription success page");
		waitInSeconds(5);
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='subscription-success-subscription-created']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='subscription-success-next-step']")));
		//Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//button[@class='c-ssns-button']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-contact-us-dropdown-container']")));
		System.out.println("End: Asserting DAPS subscription success page");
	}

	public void AssertPromoCode(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting Promo code");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//strong[contains(text(),'Promotion applied:')]")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//a[@ng-click='vm.removeVoucher()']")));
		System.out.println("End: Asserting Promo code");
	}

	public void assertShopPageRegionalization(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Shop Page Regionalization");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='header-minimal']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='profile-dropdown']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='subscribe|hero-banner']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='subscribe|benefits']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='subscribe|other-options']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@data-lpos='footer']")));
		System.out.println("End: Asserting Shop Page Regionalization");
	}

	public void assertAEMDataShopPagePackageComponent(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Start: Asserting AEM Data Shop Page");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//h1[@class='o-shop-package-header__title']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//h2[@class='o-shop-package-header__sub-title']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-shop-package-list']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-shop-package-item__h1']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-shop-package-item__h2']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//span[@class='o-shop-package-item__h2-price']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//span[@class='o-shop-package-item__h2-regular-price-group']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='o-shop-package-item__h3']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//button[@class='o-shop-package-item__btn']")));
		System.out.println("End: Asserting AEM Data Shop Page");
	}

	public void assertAMPNormalWall(BaseTestPageAndObjects localObj){
		System.out.println("Start: Asserting AMP Meter Wall");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//section[@amp-access=\"NOT authorized AND wallType = 'metered'\"]")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > p.c-paywall__paragraph2")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > p.c-paywall__paragraph1")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > h3")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > h2")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > footer")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.cssSelector("body > div.page > div.article.container-gutters > div > section:nth-child(4) > div.c-paywall.c-paywall--thestar > a.c-paywall__subscribe-button")));
		System.out.println("End: Asserting AMP Meter Wall");
	}

	public void assertRightRail(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Editors pick");
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//div[@class='c-two-column-layout']")));
		Assert.assertTrue(localObj.checkObjectIsPresent(By.xpath("//a[@data-test-id='mediacard']")));
		System.out.println("End: Asserting Editors pick");
	}

	public void assertMediaCard(BaseTestPageAndObjects localObj) {
		System.out.println("Start: Asserting Breaking News section");
		Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//img[@data-test-id='medicard-image']")));
		Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//span[@data-test-id='mediacard-headline']")));
		Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//span[@class='label-trust-text']")));
		Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath("//span[@class='article__published-date']")));
		System.out.println("End: Asserting Breaking News section");
	}

	public static void AssertGreyBannerTextAnonymous(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Grey Banner Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(30, By.cssSelector("#app > div > div.o-tophat > div > a.c-subscription-message.alcta")));
		System.out.println("End: Asserting Grey Banner Text");


	}

	public static void AssertGreyBannerText_RDR(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Grey Banner Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.linkText("RDR-Banner-desktop paragraph 1")));
		System.out.println("End: Asserting Grey Banner Text");

	}

	public static void AssertSubscribeButtonText(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Subscribe Button Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.xpath("//p[@class='c-button__text c-button__text--title']")));
		System.out.println("End: Asserting Subscribe Button Text");

	}

	public static void AssertToasterText(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Toaster Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.cssSelector(".c-meter-banner__text--desktop")));
		System.out.println("End: Asserting Toaster Text");

	}

	public static void AssertOverlayText(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Overlay Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.cssSelector(".overlayLargePanel > .overlayFirstMonthText")));
		System.out.println("End: Asserting Overlay Text");

	}

	public static void AssertMeterText(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Meter Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(30, By.xpath("//div[@class=\"meterText\"]")));
		System.out.println("End: Asserting Meter Text");

	}

	public static void AssertManualPayWallText(String TextAEM, BaseTestPageAndObjects localObj){

		System.out.println("Start: Asserting Hard/Manual Paywall Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.className("c-manual-wall__paragraph2")));
		System.out.println("End: Asserting Hard/Manual Paywall Text");

	}

	public static void AssertNormalPayWallText(String TextAEM, BaseTestPageAndObjects localObj) {

		System.out.println("Start: Asserting Normal Paywall Text");
		Assert.assertEquals(TextAEM, localObj.check_object_UnTrimmed_Text_Wait(60, By.cssSelector("#app > div > div.basic-paywall-new > div.articleMeterWall.subArticleMeterWall.articleMeterWall--thestar.subArticleMeterWall--thestar > div.paragraphTexts > div.paragraph_2")));
		System.out.println("End: Asserting Normal Paywall Text");

	}

	public void assertAMPPageSlideShow(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting that SlideShow is present");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='amp-carousel-button amp-carousel-button-prev']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='amp-carousel-button amp-carousel-button-next']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//img[@class='i-amphtml-fill-content i-amphtml-replaced-content']")));
		System.out.println("End asserting that SlideShow is present");
	}

	public void assertAMPPageVideo(BaseTestPageAndObjects baseTestObj) {
	 	System.out.println("Asserting that Player is present");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//*[@id='player']")));
		System.out.println("End asserting that Player is present");
	}

	public void assertAMPPageEditorialCartoon(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting that EditorialCartoon is present");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//a[@href='/opinion/editorial_cartoon']")));
		System.out.println("End asserting that EditorialCartoon is present");
	}

	public void assertAMPPageArticle(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting that Article is present");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='amp-carousel-button amp-carousel-button-prev']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//div[@class='amp-carousel-button amp-carousel-button-next']")));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//img[@class='i-amphtml-fill-content i-amphtml-replaced-content']")));
		System.out.println("End asserting that Article is present");
	 }

	public void assertAMPPageValid(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath("//span[contains(text(),'PASS')]")));
	}

	public void waitInSeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

    public void assertNewsLettersSubscribed(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting user subscribed");
	 	waitInSeconds(5);
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.NEWSLETTER_TOASTER_MESSAGE.toString())));
		String BadgeText = "All newsletters added";
		Assert.assertEquals(baseTestObj.scroll_check_object_Text(By.xpath(Variables.NEWSLETTER_TOASTER_MESSAGE.toString())), BadgeText);
		System.out.println("End asserting user unsubscribed");
	 }

	public void assertNewsLettersUnsubscribed(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting user subscribed");
		waitInSeconds(5);
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.NEWSLETTER_TOASTER_MESSAGE.toString())));
		String BadgeText = "All newsletters removed";
		Assert.assertEquals(baseTestObj.scroll_check_object_Text(By.xpath(Variables.NEWSLETTER_TOASTER_MESSAGE.toString())), BadgeText);
		System.out.println("End asserting user unsubscribed");
//	 	waitInSeconds(5);
//		System.out.println("Asserting user unsubscribed");
//		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.ALL_NEWSLETTER_SUBSCRIBED_TOASTER.toString())));
//		System.out.println("End asserting user unsubscribed");
	}

	public void assertAEMFieldsOnBoarding(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting onboarding page");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_ONBOARDING_PAGE.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_ONBOARDING_HEADING.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_ONBOARDING_HEAD_PARAGRAPH.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_ONBOARDING_MAIN_PARAGRAPH.toString())));
		System.out.println("End asserting onboarding page");

	}

	public void assertAEMDataOtherOffers(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting shop page other offers section ");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.SHOP_PAGE_OTHER_OFFER_CARD.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.SHOP_PAGE_OTHER_OFFER_COMPONENT.toString())));
		System.out.println("End asserting shop page other offers section  ");
	}

	public void assertAEMDataBenefitsComponent(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting shop page benefits section ");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.SHOP_PAGE_BENEFIT_COMPONENT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.SHOP_PAGE_BENEFIT_COMPONENT_IMAGE.toString())));
		System.out.println("End asserting shop page benefits section ");
	}

	public void assertRecommendForYouNewsletter(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting recommend for you section ");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.NEWSLETTER_FEATURED.toString())));
		String BadgeText = "Featured";
		Assert.assertEquals(baseTestObj.scroll_check_object_Text(By.xpath(Variables.NEWSLETTER_FEATURED_TEXT.toString())), BadgeText);
		System.out.println("End asserting recommend for you section ");
	}

    public void assertRegWall(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting registration wall");
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_1.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_2.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_3.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_CTA_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_4.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_FORM.toString())));
		System.out.println("End asserting registration wall");
    }

	public void assertNoRegWall(BaseTestPageAndObjects baseTestObj) {
		System.out.println("Asserting there are no registration wall");
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_1.toString())));
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_2.toString())));
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_3.toString())));
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_CTA_BUTTON.toString())));
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_PARAGRAPH_4.toString())));
		Assert.assertFalse(baseTestObj.checkObjectIsPresent(By.xpath(Variables.REG_WALL_FORM.toString())));
		System.out.println("Asserting there are no registration wall");
	}

	public void assertDAPSLinkExpressCheckout(BaseTestPageAndObjects localObj) {
		String BadgeText = "Home Delivery Subscriber?\n" +
				" Redeem your digital access.";
		System.out.println("Asserting DAPS link");
		Assert.assertEquals(localObj.scroll_check_object_Text(By.xpath(Variables.DAPS_LINK_TEXT_EXPRESS_CHECKOUT.toString())), BadgeText);
		Assert.assertTrue(localObj.checkObjectIsPresent( By.xpath(Variables.DAPS_LINK_EXPRESS_CHECKOUT.toString())));
	}

	public void assertMarketingId(String data) {
		System.out.println("Asserting marketing id ");
		Assert.assertEquals(data.length(), 38, "Length is incorrect");
	}

	public void assertBannerListHeader(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.NEWSLETTER_ICON_HOME_PAGE.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.PODCASTS_ICON_HOME_PAGE.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.PAPER_ICON_HOME_PAGE.toString())));
	}

	public void asertOnBoardingPage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.CONTINUE_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.CONTINUE_READING.toString())));
	}

	public void assertAEMFieldPromoPage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_HERO_ONBOARDING.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_HEADER.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_ONBOARDING_APP.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_CONTACT_US.toString())));
	}

	public void asertOnBoardingMobilePromoPageObjects(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.MOBILE_INPUT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.TEXT_ME_APP_BUTTON.toString())));
	}

	public void assertSuccessMessage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SMS_SUCCESS_MESSAGE.toString())));
	}

	public void assertMenuItems(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.OPEN_MENU_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.MANAGE_PROFILE_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SUBSCRIPTION_ORDERS.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.BILLING_INFORMATION.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.NEWSLETTERS_MENU_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SIGN_OUT_BUTTON.toString())));
	}

	public void asertSearchInput(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_BUTTON.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.CLOSE_SEARCH.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_INPUT.toString())));
	}

	public void asertSearchPage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_SEARCH_FILTERS.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_SEARCH_PAGINATION.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_SEARCH_RESULT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.REG_SEARCH_ID.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_PRINT_ARCHIVES.toString())));

	}

	public void asertSortResults(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_SORT.toString())));

	}

	public void asertFilterContent(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_FILTER_CONTENT.toString())));
	}

	public void asertFilterAuthor(BaseTestPageAndObjects baseTestObj) {
	 	waitInSeconds(5);
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SEARCH_FILTER_AUTHOR.toString())));
	}

	public void asertGiftPage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SELECT_GIFT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_HERO.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SUBMIT_GIFT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_KEY_POINT1.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_KEY_POINT2.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_OFFER_TERMS.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_CONTACT_US.toString())));
	}

	public void assertHTML5Component(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.HTML_CLICK_TO_OPEN.toString())));
	}

	public void assertHTML5ComponentExtended(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.EXPENDED_HTML5_COMPONENT.toString())));
	}

	public void assertAMPSideBar(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.CLOSE_SIDE_BAR.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SB_SOCIAL_SECTION.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SB_CITY_SECTION.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SB_MENU_SECTION.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SB_VIEW_ALL.toString())));
	}

	public void asertPurchaseDetailsPage(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SUBMIT_GIFT_SELECT_FORM.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_MESSAGE.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FOR_EMAIL.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FOR_FULL_NAME.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FROM_FIRST_NAME.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FROM_LAST_NAME.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FROM_EMAIL.toString())));
	}

	public void asertGiftProcessBar(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_PROGRESS_BAR.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_PROGRESS_BAR_STEP_1.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_PROGRESS_BAR_STEP_2.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_PROGRESS_BAR_STEP_3.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_PROGRESS_BAR_STEP_4.toString())));
	}

	public void asertTermsComponent(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_TERMS.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_CONTACT_US.toString())));
	}

	public void asertFAQComponent(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_FAQ.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_CONTACT_US.toString())));
	}

	public void asertActivationCode(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_ACTIVATION_CODE_INPUT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SUBMIT_GIFT.toString())));
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.GIFT_ACTIVATION_CODE_HEADER.toString())));
	}

	public void asertHowItWorks(BaseTestPageAndObjects baseTestObj) {
	}

	public void assertSignedOut(BaseTestPageAndObjects baseTestObj) {
		Assert.assertTrue(baseTestObj.checkObjectIsPresent( By.xpath(Variables.SIGN_IN_BUTTON_TEXT.toString())));
	}
}
