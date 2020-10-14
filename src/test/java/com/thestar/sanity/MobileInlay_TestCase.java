package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import com.thestar.base.Variables;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class MobileInlay_TestCase {

    BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
    AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();

    @BeforeClass
    @Parameters({"browser", "url", "name"})
    public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://qa4.thestar.com") String url, @Optional("Not Required from Local") String name) throws Exception {
        System.out.println("Started Testing MobileInlay on iPhone X dimension");
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
        BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl, name);
        BaseTestObj.setMobileDimension(375,812);
    }

    @Test (priority = 1, description = "Verify that mobileInlayPresent present on mobile view on second article")
    public void mobileInlayPresent() {
        BaseTestObj.loadPage("Article 1 ", BaseTestObj.baseUrl + ReadExternalData.article1);
        BaseTestObj.scrollPage(0,3600);
        assertObjectsOnPagesObj.assertMeterArticle(BaseTestObj);
        BaseTestObj.loadPage("Article 2 ", BaseTestObj.baseUrl + ReadExternalData.article2);
        BaseTestObj.scrollPage(0,3600);
        BaseTestObj.isEnabled(By.xpath(Variables.MOBILE_INLAY_SIGN_IN_LINK.toString()));
        assertObjectsOnPagesObj.assertMobileInlayTrue(BaseTestObj);

    }

    @AfterTest
    @AfterClass
    public void TerminateTestCase(){
        System.out.println("Completed Testing MobileInlay Objects");
        BaseTestObj.QuitBrowser();
    }

}
