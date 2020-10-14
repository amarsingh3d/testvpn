package com.thestar.base;

import org.openqa.selenium.By;

public class ObtainObjectsTextAEM{
	
	public String OverlayDesktopP1 = "";
	public String OverlayDesktopP2 = "";
	public String OverlayDesktopP3 = "";
	public String OverlayDesktopP4 = "";
	
	public String ExpressCheckoutDesktopH1 = "";
	
	public String SubscribeNowDesktopP1 = "";
	public String SubscribeNowDesktopP2 = "";
	
	public String BannerDesktopP1 = "";
	
	public String ToasterDesktopP1 = "";
	public String ToasterDesktopSUB = "";
	
	public String MeterDesktopP1 = "";
	public String MeterDesktopSUB = "";
	
	public String NormalPaywallDesktopP1 = "";
	public String NormalPaywallDesktopP2 = "";
	public String NormalPaywallDesktopP3 = "";
	public String NormalPaywallDesktopP4 = "";
	public String NormalPaywallDesktopP5 = "";
	public String NormalPaywallDesktopP6 = "";
	public String NormalPaywallDesktopP7 = "";
	public String NormalPaywallDesktopP8 = "";
	public String NormalPaywallDesktopSUB = "";
	
	public String ManualPaywallDesktopP1 = "";
	public String ManualPaywallDesktopP2 = "";
	public String ManualPaywallDesktopP3 = "";
	public String ManualPaywallDesktopP4 = "";
	public String ManualPaywallDesktopP5 = "";
	public String ManualPaywallDesktopP6 = "";
	public String ManualPaywallDesktopP7 = "";
	public String ManualPaywallDesktopP8 = "";
	public String ManualPaywallDesktopSUB = "";
	public String ManualPaywallHeading1 ="";
	public String ManualPaywallHeading2 = "";
	public String ManualPaywallParagraph1 = "";
	public String ManualPaywallParagraph2 = "";
	public String ManualPaywallButtonText ="";
	public String ManualPaywallButtonLink = "";
	public String ManualPaywallFooter = "";
	public String ManualPaywallSignInText = "";
	public String ManualPaywallSignInLink = "";
	public String ManualPaywallHomeText = "";
	public String ManualPaywallHomeLink = "";
	public String ManualPaywallBackgroundDesktop = "";
	public String ManualPaywallBackgroundTablet = "";


	public String PremiumPaywallDesktopP1 = "";
	public String PremiumPaywallDesktopP2 = "";
	public String PremiumPaywallDesktopP3 = "";
	public String PremiumPaywallDesktopP4 = "";
	public String PremiumPaywallDesktopP5 = "";
	public String PremiumPaywallDesktopP6 = "";
	public String PremiumPaywallDesktopP7 = "";
	public String PremiumPaywallDesktopP8 = "";
	public String PremiumPaywallDesktopSUB = "";
	
	public void AEMAnonymousObjectText(BaseTestPageAndObjects localObj){
		 
		 
		System.out.println(localObj);
		System.out.println("Obtaining ExpressCheckout Text from AEM");
		ExpressCheckoutDesktopH1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ExpressCheckout-desktop heading 1')]")); 
		
		System.out.println("Obtaining Overlay Text from AEM");
		OverlayDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AA-Overlay-desktop paragraph 1')]"));
		OverlayDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AA-Overlay-desktop paragraph 2')]"));
		OverlayDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AA-Overlay-desktop paragraph 3')]"));
		OverlayDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AA-Overlay-desktop paragraph 4')]"));
		 
		System.out.println("Obtaining Subscribe Now Text from AEM");
		SubscribeNowDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(text(),'Value: AA-SubscribeNow-desktop paragraph 1')]"));
		SubscribeNowDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AA-SubscribeNow-desktop paragraph 2')]"));
		
		 
		System.out.println("Obtaining Banner from AEM");
		BannerDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AA-Banner-desktop paragraph 1')]"));
		
		System.out.println("Obtaining Toaster Text from AEM");
		ToasterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-Toaster-desktop paragraph 1')]"));
		ToasterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-Toaster-desktop subscribe')]"));
		
		System.out.println("Obtaining Meter Text from AEM");
		MeterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-Meter-desktop paragraph 1')]"));
		MeterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-Meter-desktop subscribe')]"));
		
		System.out.println("Obtaining NormalPaywall Text from AEM");
		NormalPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 1')]"));
		NormalPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AA-NormalPaywall-desktop paragraph 2')]"));
		NormalPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 3')]"));
		NormalPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 4')]"));
		NormalPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 5')]"));
		NormalPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 6')]"));
		NormalPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 7')]"));
		NormalPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop paragraph 8')]"));
		NormalPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-NormalPaywall-desktop subscribe')]"));
		
		System.out.println("Obtaining ManualPaywall Text from AEM");
		ManualPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 1')]"));
		ManualPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AA-ManualPaywall-desktop paragraph 2')]"));
		ManualPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 3')]"));
		ManualPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 4')]"));
		ManualPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 5')]"));
		ManualPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 6')]"));
		ManualPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 7')]"));
		ManualPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop paragraph 8')]"));
		ManualPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-ManualPaywall-desktop subscribe')]"));
		/*
		System.out.println("Obtaining PremiumPaywall Text from AEM");
		PremiumPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 1')]"));
		PremiumPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 2')]"));
		PremiumPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 3')]"));
		PremiumPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 4')]"));
		PremiumPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 5')]"));
		PremiumPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 6')]"));
		PremiumPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 7')]"));
		PremiumPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop paragraph 8')]"));
		PremiumPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AA-PremiumPaywall-desktop subscribe')]"));*/
		 			   
	}
	
	public void AEMRegisteredObjectText(BaseTestPageAndObjects localObj){
		 
		System.out.println("Obtaining ExpressCheckout Text from AEM");
		ExpressCheckoutDesktopH1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ExpressCheckout-desktop heading 1')]")); 
		
		System.out.println("Obtaining Overlay Text from AEM");
		OverlayDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-Overlay-desktop paragraph 1')]"));
		OverlayDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-Overlay-desktop paragraph 2')]"));
		OverlayDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-Overlay-desktop paragraph 3')]"));
		OverlayDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-Overlay-desktop paragraph 4')]"));
		 
		System.out.println("Obtaining Subscribe Now Text from AEM");
		SubscribeNowDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-SubscribeNow-desktop paragraph 1')]"));
		SubscribeNowDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: AR-SubscribeNow-desktop paragraph 2')]"));
		
		 
		System.out.println("Obtaining Banner from AEM");
		BannerDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-Banner-desktop paragraph 1')]"));
		
		System.out.println("Obtaining Toaster Text from AEM");
		ToasterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-Toaster-desktop paragraph 1')]"));
		ToasterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-Toaster-desktop subscribe')]"));
		
		System.out.println("Obtaining Meter Text from AEM");
		MeterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-Meter-desktop paragraph 1')]"));
		MeterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-Meter-desktop subscribe')]"));
		
		System.out.println("Obtaining NormalPaywall Text from AEM");
		NormalPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 1')]"));
		NormalPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 2')]"));
		NormalPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 3')]"));
		NormalPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 4')]"));
		NormalPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 5')]"));
		NormalPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 6')]"));
		NormalPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 7')]"));
		NormalPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop paragraph 8')]"));
		NormalPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-NormalPaywall-desktop subscribe')]"));
		
		System.out.println("Obtaining ManualPaywall Text from AEM");
		ManualPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 1')]"));
		ManualPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall-desktop paragraph 2')]"));
		ManualPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 3')]"));
		ManualPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 4')]"));
		ManualPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 5')]"));
		ManualPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 6')]"));
		ManualPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 7')]"));
		ManualPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop paragraph 8')]"));
		ManualPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-ManualPaywall-desktop subscribe')]"));
		ManualPaywallHeading1 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall heading1')]"));
		ManualPaywallHeading2 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall heading2')]"));
		ManualPaywallParagraph1 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall paragraph1')]"));
		ManualPaywallParagraph2 = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall paragraph2')]"));
		ManualPaywallButtonText = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall-buttonText')]"));
		ManualPaywallButtonLink = localObj.check_object_Text(By.xpath("//span[contains(text(),'https://reactqa2.smgdigitaldev.com/subscribe')]"));
		ManualPaywallFooter = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall footer')]"));
		ManualPaywallSignInText = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall signInText')]"));
		ManualPaywallSignInLink = localObj.check_object_Text(By.xpath("//span[contains(text(),'https://reactqa2.smgdigitaldev.com/sign-in')]"));
		ManualPaywallHomeText = localObj.check_object_Text(By.xpath("//span[contains(text(),'AR-ManualPaywall-homeText')]"));
		ManualPaywallHomeLink = localObj.check_object_Text(By.xpath("//span[contains(text(),'https://reactqa2.smgdigitaldev.com')]"));
		ManualPaywallBackgroundDesktop = localObj.check_object_Text(By.xpath("//span[contains(text(),'http://www.stage.smgdigitaldev.com/content/dam/thestar/staticimages/hard-paywall-bg.svg')]"));
		ManualPaywallBackgroundTablet = localObj.check_object_Text(By.xpath("//span[contains(text(),'http://www.stage.smgdigitaldev.com/content/dam/thestar/staticimages/hard-paywall-bg-tablet.svg')]"));
		/*
		System.out.println("Obtaining PremiumPaywall Text from AEM");
		PremiumPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 1')]"));
		PremiumPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 2')]"));
		PremiumPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 3')]"));
		PremiumPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 4')]"));
		PremiumPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 5')]"));
		PremiumPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 6')]"));
		PremiumPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 7')]"));
		PremiumPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 8')]"));
		PremiumPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop subscribe')]"));*/
		 			   
	}
	
	
	public void AEMRDRObjectText(BaseTestPageAndObjects localObj){
		
		
		System.out.println("Obtaining ExpressCheckout Text from AEM");
		ExpressCheckoutDesktopH1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-ExpressCheckout-desktop heading 1')]")); 
		
			
		System.out.println("Obtaining Overlay Text from AEM");
		OverlayDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-Overlay-desktop paragraph 1')]"));
		OverlayDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-Overlay-desktop paragraph 2')]"));
		OverlayDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-Overlay-desktop paragraph 3')]"));
		OverlayDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-Overlay-desktop paragraph 4')]"));
		 
		System.out.println("Obtaining Subscribe Now Text from AEM");
		SubscribeNowDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-SubscribeNow-desktop paragraph 1')]"));
		SubscribeNowDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-SubscribeNow-desktop paragraph 2')]"));
		
		 
		System.out.println("Obtaining Banner from AEM");
		BannerDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'Value: RDR-Banner-desktop paragraph 1')]"));
		
		System.out.println("Obtaining Toaster Text from AEM");
		ToasterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-Toaster-desktop paragraph 1')]"));
		ToasterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-Toaster-desktop subscribe')]"));
		
		System.out.println("Obtaining Meter Text from AEM");
		MeterDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-Meter-desktop paragraph 1')]"));
		MeterDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-Meter-desktop subscribe')]"));
		
		System.out.println("Obtaining NormalPaywall Text from AEM");
		NormalPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 1')]"));
		NormalPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 2')]"));
		NormalPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 3')]"));
		NormalPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 4')]"));
		NormalPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 5')]"));
		NormalPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 6')]"));
		NormalPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 7')]"));
		NormalPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop paragraph 8')]"));
		NormalPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-NormalPaywall-desktop subscribe')]"));
		
		System.out.println("Obtaining ManualPaywall Text from AEM");
		ManualPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 1')]"));
		ManualPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 2')]"));
		ManualPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 3')]"));
		ManualPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 4')]"));
		ManualPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 5')]"));
		ManualPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 6')]"));
		ManualPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 7')]"));
		ManualPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop paragraph 8')]"));
		ManualPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'RDR-ManualPaywall-desktop subscribe')]"));
		/*
		System.out.println("Obtaining PremiumPaywall Text from AEM");
		PremiumPaywallDesktopP1 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 1')]"));
		PremiumPaywallDesktopP2 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 2')]"));
		PremiumPaywallDesktopP3 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 3')]"));
		PremiumPaywallDesktopP4 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 4')]"));
		PremiumPaywallDesktopP5 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 5')]"));
		PremiumPaywallDesktopP6 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 6')]"));
		PremiumPaywallDesktopP7 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 7')]"));
		PremiumPaywallDesktopP8 = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop paragraph 8')]"));
		PremiumPaywallDesktopSUB = localObj.check_object_Text(By.xpath("//span[contains(.,'AR-PremiumPaywall-desktop subscribe')]"));
		 		*/	   
	}


}
