package com.thestar.sanity;

import com.thestar.base.AssertObjectsOnPages;
import com.thestar.base.BaseTestPageAndObjects;
import com.thestar.base.ReadExternalData;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class NationalExpansionCity_TestCase {

    BaseTestPageAndObjects BaseTestObj = new BaseTestPageAndObjects();
    AssertObjectsOnPages assertObjectsOnPagesObj = new AssertObjectsOnPages();

    @BeforeClass
    @Parameters({"browser", "url", "name"})
    public void FileReadBrowserLaunch(@Optional("Local_Chrome") String browser, @Optional("https://reactqa2.smgdigitaldev.com") String url, @Optional("Not Required from Local") String name) throws MalformedURLException, InterruptedException {
        System.out.println("Started Testing National Expansion City test case");
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
        BaseTestObj.LaunchBrowser_Local_OR_BrowserStack(browser, BaseTestObj.baseUrl+BaseTestObj.signinpage, name);
        BaseTestObj.SignIn(BaseTestObj.usernamebasic, BaseTestObj.passwordbasic);

    }


    @Test(priority = 0, description = "Checking Reader Choice Awards Tab")
    public void Calgary_Sports() throws InterruptedException {

        BaseTestObj.SelectLocation("Calgary");
        BaseTestObj.SelectCategory("Sports");
        assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Sports", BaseTestObj, BaseTestObj.baseUrl);

    }

    @Test(priority = 1)
    public void Calgary_Politics() throws InterruptedException {

        BaseTestObj.SelectCategory("Politics");
        assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Politics", BaseTestObj, BaseTestObj.baseUrl);

    }

    @Test(priority = 2)
    public void Edmonton_Provincial_Politics() throws InterruptedException {
        BaseTestObj.loadURL("Article 5", BaseTestObj.baseUrl + ReadExternalData.article5);
        BaseTestObj.SelectLocation("Edmonton");
        BaseTestObj.SelectCategory("Politics");
        BaseTestObj.selectSubCategory("Provincial Politics");
        assertObjectsOnPagesObj.AssertPageURL(BaseTestObj.Check_URL(), "Provincial Politics", BaseTestObj, BaseTestObj.baseUrl);

    }

    @AfterTest
    @AfterClass
    public void TerminateTestCase() {
        System.out.println("Completed Testing IAN-224");
        BaseTestObj.QuitBrowser();

    }


}
