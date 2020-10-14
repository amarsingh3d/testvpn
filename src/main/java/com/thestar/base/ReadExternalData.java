package com.thestar.base;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXWriter;
public class  ReadExternalData{
	
//The Star and Generic variables	
	
	public String baseUrl = "";
	public static String article1 = "";
	public static String freeArticle = "";
	public static String faq = "";
	public static String article2 = "";
	public static String article3 = "";
	public static String article4 = "";
	public static String article5 = "";
	public static String article6 = "";
	public String articleHardwall = "";
	public String articlePremiumwall = "";
	public String signinpage = "";
	public String subscriptionsOrdersPage = "";
	public String usernamereg = "";
	public String passwordreg = "";
	public String usernamebasic = "";
	public String passwordbasic = "";
	public String usernamepremium = "";
	public String passwordpremium = "";
	public String city = "";
	public String cityarticle1 = "";
	public String cityarticle2 = "";
	public String email = "";
	public String recomendNewsletter = "";
	public String p11 = "";
	public String p12 = "";
	public String p8less = "";
	public String p9to13 = "";
	public String p13to26 = "";
	public String p27more = "";
	public String rcloginpage = "";
	public String rcpage = "";
	public String sportspageurl = "";
	public String politicspageurl = "";
	public String provincialpoliticspageurl = "";
	public String videoPage = "";
	public String slideshowPage = "";
	public String expresscheckoutpage = "";
	public String conversationpage = "";
	public String epcpage = "";
	public String emailfield = "";
	public String yopmail = "";
	public String mailinator = "";
	public String subscribepage = "";
	public String blueLine = "";
	public String doctordb = "";
	public String trustlabel = "";
	public String thespecsubscribe = "";
	public String facebookusername = "";
	public String facebookpassword = "";
	public String gmailusername = "";
	public String gmailpassword = "";
	public String slideshowamppage = "";
	public String videoamppage = "";
	public String editorialcartoonamppage = "";
	public String articleamppage = "";
	public String ampHardWallPage = "";
	public String googleValidation = "";
	public String ampPageFive = "";
	public String ampPageSix = "";
	public String ampPageHTML5 = "";
	public String topicpage = "";
	public String authorPage = "";
	public String torontopage = "";
	public String vancouverpage = "";
	public String calgarypage = "";
	public String edmontonpage = "";
	public String winnipegpage = "";
	public String ottawapage = "";
	public String halifaxpage = "";
	public String cartoonPage = "";
	public String VideoPage2 = "";
	public String SlideShowPage2 = "";
	public String SponsoredArticle = "";
	public String InvalidURL = "";
	public String PayPalEmail = "";
	public String PayPalPassword = "";
	public String VancouverHome = "";
	public String QAHomePage = "";
	public String dapsPage = "";
	public String onboardingPage = "";
	public String giftsPage = "";
	public String giftRedeemPage = "";
	public String browseroption = "";

	//Home Finder variables
	
	public String hf_homepage = "";

	//RDR variables
	public String RDR_article1 = "";
	public String RDR_faq = "";
	public String RDR_freeArticle = "";
	public String RDR_article2 = "";
	public String RDR_article3 = "";
	public String RDR_article4 = "";
	public String RDR_article5 = "";
	public String RDR_article6 = "";
	public String RDR_articleHardwall = "";
	public String RDR_articlePremiumwall = "";
	public String RDR_usernamereg = "";
	public String RDR_passwordreg = "";
	public String RDR_usernamebasic = "";
	public String RDR_passwordbasic = "";
	public String RDR_topicpage = "";
	public String RDR_authorpage = "";
	public String RDR_cartoonpage = "";
	public String RDR_VideoPage2 = "";
	public String RDR_SlideShowPage2 = "";
	public String RDR_SponsoredArticle = "";
	public String RDR_InvalidFromTS = "";
	
	public void ReadObjectRepositoryXML() {
	    File inputFile = new File(System.getProperty("user.dir") + "/ExternalObjects_environment.xml");
	    SAXReader saxReader = new SAXReader();	
	    SAXWriter abc = new SAXWriter();
	    Document document;
		try {
			document = saxReader.read(inputFile);
			//baseUrl = document.selectSingleNode("/globalvariablesor/faq").getText();
			ampPageHTML5 = document.selectSingleNode("/globalvariablesor/amphtml5").getText();
			googleValidation = document.selectSingleNode("/globalvariablesor/googleValidation").getText();
			freeArticle = document.selectSingleNode("//globalvariablesor/freeArticle").getText();
			faq = document.selectSingleNode("//globalvariablesor/faq").getText();
			article1 = document.selectSingleNode("//globalvariablesor/article1or").getText();
			article2 = document.selectSingleNode("//globalvariablesor/article2or").getText();
			article3 = document.selectSingleNode("//globalvariablesor/article3or").getText();
			article4 = document.selectSingleNode("//globalvariablesor/article4or").getText();
			article5 = document.selectSingleNode("//globalvariablesor/article5or").getText();
			article6 = document.selectSingleNode("//globalvariablesor/article6or").getText();
			articleHardwall = document.selectSingleNode("//globalvariablesor/articlehardwallor").getText();
			articlePremiumwall = document.selectSingleNode("//globalvariablesor/articlepremiumwallor").getText();
			signinpage = document.selectSingleNode("//globalvariablesor/signinpageor").getText();
			subscriptionsOrdersPage = document.selectSingleNode("//globalvariablesor/orders").getText();
			browseroption = document.selectSingleNode("//globalvariablesor/browseroptionor").getText();
			usernamereg = document.selectSingleNode("//globalvariablesor/usernameregor").getText();
			passwordreg = document.selectSingleNode("//globalvariablesor/passwordregor").getText();
			usernamebasic = document.selectSingleNode("//globalvariablesor/usernamebasicor").getText();
			passwordbasic = document.selectSingleNode("//globalvariablesor/passwordbasicor").getText();
			usernamepremium = document.selectSingleNode("//globalvariablesor/usernamepremiumor").getText();
			passwordpremium = document.selectSingleNode("//globalvariablesor/passwordpremiumor").getText();
			city =  document.selectSingleNode("//globalvariablesor/cityor").getText();
			cityarticle1 = document.selectSingleNode("//globalvariablesor/cityarticle1or").getText();
			cityarticle2 = document.selectSingleNode("//globalvariablesor/cityarticle2or").getText();
			email = document.selectSingleNode("//globalvariablesor/emailor").getText();
			recomendNewsletter = document.selectSingleNode("//globalvariablesor/recomendnewsletteror").getText();
			p11 = document.selectSingleNode("//globalvariablesor/p11or").getText();
			p12 = document.selectSingleNode("//globalvariablesor/p12or").getText();
			p8less =  document.selectSingleNode("//globalvariablesor/p8lessor").getText();
			p9to13 = document.selectSingleNode("//globalvariablesor/p9to13or").getText();
			p13to26 = document.selectSingleNode("//globalvariablesor/p13to26or").getText();
			p27more = document.selectSingleNode("//globalvariablesor/p27moreor").getText();
			rcloginpage = document.selectSingleNode("//globalvariablesor/rcloginpageor").getText();
			rcpage = document.selectSingleNode("//globalvariablesor/rcpageor").getText();
			sportspageurl = document.selectSingleNode("//globalvariablesor/sportspageurlor").getText();
			politicspageurl = document.selectSingleNode("//globalvariablesor/politicspageurlor").getText();
			provincialpoliticspageurl = document.selectSingleNode("//globalvariablesor/provincialpoliticspageurlor").getText();
			videoPage = document.selectSingleNode("//globalvariablesor/videopageor").getText();
			slideshowPage = document.selectSingleNode("//globalvariablesor/slideshowpageor").getText();
			expresscheckoutpage = document.selectSingleNode("//globalvariablesor/expresscheckoutpageor").getText();
			conversationpage = document.selectSingleNode("//globalvariablesor/conversationpageor").getText();
			epcpage = document.selectSingleNode("//globalvariablesor/epcpageor").getText();
			emailfield = document.selectSingleNode("//globalvariablesor/emailfieldor").getText();
			yopmail = document.selectSingleNode("//globalvariablesor/yopmailor").getText();
			mailinator = document.selectSingleNode("//globalvariablesor/mailinatoror").getText();
			subscribepage = document.selectSingleNode("//globalvariablesor/subscribepageor").getText();
			blueLine = document.selectSingleNode("//globalvariablesor/bluelineor").getText();
			doctordb = document.selectSingleNode("//globalvariablesor/doctordbor").getText();
			trustlabel =  document.selectSingleNode("//globalvariablesor/trustlabelor").getText();
			thespecsubscribe = document.selectSingleNode("//globalvariablesor/thespecsubscribeor").getText();
			facebookusername = document.selectSingleNode("//globalvariablesor/facebookusernameor").getText();
			facebookpassword = document.selectSingleNode("//globalvariablesor/facebookpasswordor").getText();
			gmailusername = document.selectSingleNode("//globalvariablesor/gmailusernameor").getText();
			gmailpassword = document.selectSingleNode("//globalvariablesor/gmailpasswordor").getText();
			slideshowamppage = document.selectSingleNode("//globalvariablesor/slideshowamppageor").getText();
			videoamppage = document.selectSingleNode("//globalvariablesor/videoamppageor").getText();
			editorialcartoonamppage = document.selectSingleNode("//globalvariablesor/editorialcartoonamppageor").getText();
			articleamppage = document.selectSingleNode("//globalvariablesor/articleamppageor").getText();
			ampHardWallPage = document.selectSingleNode("//globalvariablesor/amphardwallpageor").getText();
			topicpage = document.selectSingleNode("//globalvariablesor/topicpageor").getText();
			authorPage =  document.selectSingleNode("//globalvariablesor/authorpageor").getText();
			torontopage = document.selectSingleNode("//globalvariablesor/torontopageor").getText();
			vancouverpage = document.selectSingleNode("//globalvariablesor/vancouverpageor").getText();
			calgarypage = document.selectSingleNode("//globalvariablesor/calgarypageor").getText();
			edmontonpage = document.selectSingleNode("//globalvariablesor/edmontonpageor").getText();
			winnipegpage = document.selectSingleNode("//globalvariablesor/winnipegpageor").getText();
			ottawapage = document.selectSingleNode("//globalvariablesor/ottawapageor").getText();
			halifaxpage = document.selectSingleNode("//globalvariablesor/halifaxpageor").getText();
			cartoonPage =  document.selectSingleNode("//globalvariablesor/cartoonpageor").getText();
			VideoPage2 = document.selectSingleNode("//globalvariablesor/VideoPage2OR").getText();
			SlideShowPage2 = document.selectSingleNode("//globalvariablesor/SlideShowPage2OR").getText();
			SponsoredArticle = document.selectSingleNode("//globalvariablesor/SponsoredArticleOR").getText();
			InvalidURL = document.selectSingleNode("//globalvariablesor/InvalidURLOR").getText();
			PayPalEmail = document.selectSingleNode("//globalvariablesor/PayPalEmailOR").getText();
			PayPalPassword = document.selectSingleNode("//globalvariablesor/PayPalPasswordOR").getText();
			VancouverHome = document.selectSingleNode("//globalvariablesor/VancouverHomeOR").getText();
			QAHomePage = document.selectSingleNode("//globalvariablesor/QAHomePageOR").getText();
			dapsPage = document.selectSingleNode("//globalvariablesor/dapspageor").getText();
			ampPageFive = document.selectSingleNode("//globalvariablesor/articleamppage5or").getText();
			ampPageSix = document.selectSingleNode("//globalvariablesor/articleamppage6or").getText();
			hf_homepage = document.selectSingleNode("//globalvariablesor/hf_homepage_or").getText();
			onboardingPage = document.selectSingleNode("//globalvariablesor/onboardingpageor").getText();
			giftsPage =  document.selectSingleNode("//globalvariablesor/gift").getText();
			giftRedeemPage =document.selectSingleNode("//globalvariablesor/giftRedeemPage").getText();
			System.out.println("The Star-File Read Completed");
						
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ReadObjectRepositoryXML_RDR(){
	    File inputFile = new File(System.getProperty("user.dir") + "/ExternalObjects_environment_rdr.xml");
	    //File inputFile = new File(System.getProperty("user.dir") + "\\ExternalObjectsUAT2.xml");
	    SAXReader saxReader = new SAXReader();	
	    SAXWriter abc = new SAXWriter();
	    Document document;
		try {
			document = saxReader.read(inputFile);
			//baseUrl = document.selectSingleNode("/globalvariablesor/faq").getText();
			RDR_faq =  document.selectSingleNode("//globalvariablesor/faq").getText();
			RDR_freeArticle = document.selectSingleNode("//globalvariablesor/rdr_freeArticle").getText();
			RDR_article1 = document.selectSingleNode("//globalvariablesor/rdr_article1or").getText();
			RDR_article2 = document.selectSingleNode("//globalvariablesor/rdr_article2or").getText();
			RDR_article3 = document.selectSingleNode("//globalvariablesor/rdr_article3or").getText();
			RDR_article4 = document.selectSingleNode("//globalvariablesor/rdr_article4or").getText();
			RDR_article5 = document.selectSingleNode("//globalvariablesor/rdr_article5or").getText();
			RDR_article6 = document.selectSingleNode("//globalvariablesor/rdr_article6or").getText();
			RDR_articleHardwall = document.selectSingleNode("//globalvariablesor/rdr_articlehardwallor").getText();
			RDR_articlePremiumwall =  document.selectSingleNode("//globalvariablesor/rdr_articlepremiumwallor").getText();
			RDR_usernamereg = document.selectSingleNode("//globalvariablesor/rdr_usernameregor").getText();
			RDR_passwordreg = document.selectSingleNode("//globalvariablesor/rdr_passwordregor").getText();
			RDR_usernamebasic = document.selectSingleNode("//globalvariablesor/rdr_usernamebasicor").getText();
			RDR_passwordbasic = document.selectSingleNode("//globalvariablesor/rdr_passwordbasicor").getText();
			RDR_topicpage = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_topicpageor").getText();
			RDR_authorpage = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_authorpageor").getText();
			RDR_cartoonpage = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_cartoonpageor").getText();
			RDR_VideoPage2 = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_VideoPage2OR").getText();
			RDR_SlideShowPage2 = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_SlideShowPage2OR").getText();
			RDR_SponsoredArticle = baseUrl + document.selectSingleNode("//globalvariablesor/rdr_SponsoredArticleOR").getText();
			RDR_InvalidFromTS = document.selectSingleNode("//globalvariablesor/rdr_InvalidFromTSOR").getText();
			giftsPage =  document.selectSingleNode("//globalvariablesor/gift").getText();
			giftRedeemPage = document.selectSingleNode("//globalvariablesor/giftRedeemPage").getText();
			
			System.out.println("RDR-File Read Completed");
			
			System.out.println("Assigning RDR Articles to Star Variables");
			article1 = RDR_article1;
			article2 = RDR_article2;
			article3 = RDR_article3;
			article4 = RDR_article4;
			article5 = RDR_article5;
			article6 = RDR_article6;
			freeArticle = RDR_freeArticle;
			faq = RDR_faq;
			articleHardwall = RDR_articleHardwall;
			articlePremiumwall = RDR_articlePremiumwall;
			usernamereg = RDR_usernamereg;
			passwordreg = RDR_passwordreg;
			usernamebasic = RDR_usernamebasic;
			passwordbasic = RDR_passwordbasic;
			topicpage = RDR_topicpage;
			authorPage = RDR_authorpage;
			cartoonPage = RDR_cartoonpage;
			VideoPage2 = RDR_VideoPage2;
			SlideShowPage2 = RDR_SlideShowPage2;
			SponsoredArticle = RDR_SponsoredArticle;
					
					
			System.out.println("Assigned RDR Articles to Star Variables");
			
			
						
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}

	public void ReadObjectRepositoryXML_RDR_OTHER(){
		File inputFile = new File(System.getProperty("user.dir") + "/ExternalObjects_environment_rdr_extra.xml");
		SAXReader saxReader = new SAXReader();
		SAXWriter abc = new SAXWriter();
		Document document;
		try {
			document = saxReader.read(inputFile);
			///baseUrl = document.selectSingleNode("/globalvariablesor/amphtml5").getText();
			RDR_freeArticle = document.selectSingleNode("//globalvariablesor/rdr_freeArticle").getText();
			RDR_article1 = document.selectSingleNode("//globalvariablesor/rdr_article1or").getText();
			RDR_article2 =  document.selectSingleNode("//globalvariablesor/rdr_article2or").getText();
			RDR_article3 =  document.selectSingleNode("//globalvariablesor/rdr_article3or").getText();
			RDR_article4 =  document.selectSingleNode("//globalvariablesor/rdr_article4or").getText();
			RDR_article5 =  document.selectSingleNode("//globalvariablesor/rdr_article5or").getText();
			RDR_article6 =  document.selectSingleNode("//globalvariablesor/rdr_article6or").getText();
			RDR_articleHardwall =  document.selectSingleNode("//globalvariablesor/rdr_articlehardwallor").getText();
			RDR_articlePremiumwall =  document.selectSingleNode("//globalvariablesor/rdr_articlepremiumwallor").getText();
			RDR_usernamereg = document.selectSingleNode("//globalvariablesor/rdr_usernameregor").getText();
			RDR_passwordreg = document.selectSingleNode("//globalvariablesor/rdr_passwordregor").getText();
			RDR_usernamebasic = document.selectSingleNode("//globalvariablesor/rdr_usernamebasicor").getText();
			RDR_passwordbasic = document.selectSingleNode("//globalvariablesor/rdr_passwordbasicor").getText();
			RDR_topicpage =  document.selectSingleNode("//globalvariablesor/rdr_topicpageor").getText();
			RDR_authorpage =  document.selectSingleNode("//globalvariablesor/rdr_authorpageor").getText();
			RDR_cartoonpage =  document.selectSingleNode("//globalvariablesor/rdr_cartoonpageor").getText();
			RDR_VideoPage2 =  document.selectSingleNode("//globalvariablesor/rdr_VideoPage2OR").getText();
			RDR_SlideShowPage2 =  document.selectSingleNode("//globalvariablesor/rdr_SlideShowPage2OR").getText();
			RDR_SponsoredArticle =  document.selectSingleNode("//globalvariablesor/rdr_SponsoredArticleOR").getText();
			RDR_InvalidFromTS = document.selectSingleNode("//globalvariablesor/rdr_InvalidFromTSOR").getText();
			giftsPage =  document.selectSingleNode("//globalvariablesor/gift").getText();
			giftRedeemPage =document.selectSingleNode("//globalvariablesor/giftRedeemPage").getText();

			System.out.println("RDR-File Read Completed");

			System.out.println("Assigning RDR Articles to Star Variables");
			article1 = RDR_article1;
			article2 = RDR_article2;
			article3 = RDR_article3;
			article4 = RDR_article4;
			article5 = RDR_article5;
			article6 = RDR_article6;
			freeArticle = RDR_freeArticle;
			articleHardwall = RDR_articleHardwall;
			articlePremiumwall = RDR_articlePremiumwall;
			usernamereg = RDR_usernamereg;
			passwordreg = RDR_passwordreg;
			usernamebasic = RDR_usernamebasic;
			passwordbasic = RDR_passwordbasic;
			topicpage = RDR_topicpage;
			authorPage = RDR_authorpage;
			cartoonPage = RDR_cartoonpage;
			VideoPage2 = RDR_VideoPage2;
			SlideShowPage2 = RDR_SlideShowPage2;
			SponsoredArticle = RDR_SponsoredArticle;


			System.out.println("Assigned RDR Articles to Star Variables");



		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public void ReadObjectRepositoryXML_RDR_PE(){
		File inputFile = new File(System.getProperty("user.dir") + "/ExternalObjects_environment_rdr_pe.xml");
		SAXReader saxReader = new SAXReader();
		SAXWriter abc = new SAXWriter();
		Document document;
		try {
			document = saxReader.read(inputFile);
			RDR_freeArticle = document.selectSingleNode("//globalvariablesor/rdr_freeArticle").getText();
			RDR_article1 =  document.selectSingleNode("//globalvariablesor/rdr_article1or").getText();
			RDR_article2 =  document.selectSingleNode("//globalvariablesor/rdr_article2or").getText();
			RDR_article3 =  document.selectSingleNode("//globalvariablesor/rdr_article3or").getText();
			RDR_article4 =  document.selectSingleNode("//globalvariablesor/rdr_article4or").getText();
			RDR_article5 =  document.selectSingleNode("//globalvariablesor/rdr_article5or").getText();
			RDR_article6 =  document.selectSingleNode("//globalvariablesor/rdr_article6or").getText();
			RDR_usernamereg = document.selectSingleNode("//globalvariablesor/rdr_usernameregor").getText();
			RDR_passwordreg = document.selectSingleNode("//globalvariablesor/rdr_passwordregor").getText();
			RDR_usernamebasic = document.selectSingleNode("//globalvariablesor/rdr_usernamebasicor").getText();
			RDR_passwordbasic = document.selectSingleNode("//globalvariablesor/rdr_passwordbasicor").getText();
			RDR_topicpage = document.selectSingleNode("//globalvariablesor/rdr_topicpageor").getText();
			RDR_authorpage =  document.selectSingleNode("//globalvariablesor/rdr_authorpageor").getText();
			RDR_cartoonpage =  document.selectSingleNode("//globalvariablesor/rdr_cartoonpageor").getText();
			RDR_VideoPage2 =  document.selectSingleNode("//globalvariablesor/rdr_VideoPage2OR").getText();
			RDR_SlideShowPage2 =  document.selectSingleNode("//globalvariablesor/rdr_SlideShowPage2OR").getText();
			giftsPage =  document.selectSingleNode("//globalvariablesor/gift").getText();
			giftRedeemPage =document.selectSingleNode("//globalvariablesor/giftRedeemPage").getText();
			System.out.println("RDR-File Read Completed");

			System.out.println("Assigning RDR Articles to Star Variables");
			article1 = RDR_article1;
			article2 = RDR_article2;
			article3 = RDR_article3;
			article4 = RDR_article4;
			article5 = RDR_article5;
			article6 = RDR_article6;
			freeArticle = RDR_freeArticle;
			articleHardwall = RDR_articleHardwall;
			articlePremiumwall = RDR_articlePremiumwall;
			usernamereg = RDR_usernamereg;
			passwordreg = RDR_passwordreg;
			usernamebasic = RDR_usernamebasic;
			passwordbasic = RDR_passwordbasic;
			topicpage = RDR_topicpage;
			authorPage = RDR_authorpage;
			cartoonPage = RDR_cartoonpage;
			VideoPage2 = RDR_VideoPage2;
			SlideShowPage2 = RDR_SlideShowPage2;
			SponsoredArticle = RDR_SponsoredArticle;

			System.out.println("Assigned RDR Articles to Star Variables");

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
