package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class TopicPage_TestCase {
	BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
	AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();
	
	@BeforeClass
	@Parameters({"browser", "url", "name"})
	public void LaunchBrowser_Local_OR_BrowserStack(@Optional("Catalina_Safari") String browser, @Optional("https://www.thestar.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
		System.out.println("Testing Objects on Topic Page");
		System.out.println(url);
		BaseTestObj.ReadObjectRepositoryXML();
		if (BaseTestObj.isRDR(url)) {
			BaseTestObj.ReadObjectRepositoryXML_RDR();
		}
		if(BaseTestObj.isRDRNiagara(url)){
			BaseTestObj.ReadObjectRepositoryXML_RDR_OTHER();
		}
		if(BaseTestObj.isRDRPE(url)){
			BaseTestObj.ReadObjectRepositoryXML_RDR_PE();
		}
		BaseTestObj.baseUrl = url;
		BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, url + BaseTestObj.topicpage, name);
	}
	
	
    @Test (priority = 0)
	public void HeadingLink(){
		BaseTestObj.waitInSeconds(20);
		assertObjectsOnPagesObj.AssertTopicHeadlingLink(BaseTestObj);
			     
	}
    
    
    @Test (priority = 1)
  	public void ArticleListContainer(){
  		assertObjectsOnPagesObj.AssertTopicArticleListContainer(BaseTestObj);
  			     
  	}
    
    @Test (priority = 2)
  	public void MediaCardHeadLine(){
  		assertObjectsOnPagesObj.AssertTopicMediaCardHeadLine(BaseTestObj);
  			     
  	}
    
    @Test (priority = 3)
  	public void MediaCardAbstract(){
  		assertObjectsOnPagesObj.AssertTopicMediaCardAbstract(BaseTestObj);
  			     
  	}
    
    @Test (priority = 4)
  	public void ArticleList2Columns(){
  		assertObjectsOnPagesObj.AssertTopicArticleList2Columns(BaseTestObj);
  			     
  	}
    
    @Test (priority = 5)
  	public void GoogleAdSlot(){
  		assertObjectsOnPagesObj.AssertTopicGoogleAdSlot(BaseTestObj);
  			     
  	}
    
    @Test (priority = 6)
  	public void SearchForMoreStoriesOnTheTopic(){
  		assertObjectsOnPagesObj.AssertTopicSearchForMoreStoriesOnTheTopic(BaseTestObj);
  			     
  	}
	
	@AfterTest
	@AfterClass
	public void TerminateTestCase(){
		System.out.println("Completed Testing Objects on Topic Page");  
		BaseTestObj.QuitBrowser();
		
	}
	  

}
