package com.mm.pages.Analysis;

import com.mm.pages.BasePage;
import com.mm.utulities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {
    @FindBy(xpath = "//a[@id='analysisTab']")
    private WebElement analysis;
    @FindBy(xpath = "//a[@href='/Enrich/EmbedDashboard?dashboardName=mm-admin-dashboard']")
    private WebElement KPIPanel;
    @FindBy(xpath = "//*[@id=\"TABS-li6nms2WjL-tab-TAB-0x89UPbcj\"]/div/div")
    private WebElement overview;
    @FindBy(xpath = "//*[@id='TABS-li6nms2WjL-tab-TAB-MPBFIpv_KH']/div/div")
    private WebElement hakedis;
    @FindBy(xpath = "//*[@id='TABS-li6nms2WjL-tab-TAB-3jtQ-FJX-']/div/div")
    private WebElement aylıksatıs;
    @FindBy(xpath = "//*[@id='TABS-li6nms2WjL']/div[1]/div[1]/div/div[4]")
    private WebElement primAnalizi;
    @FindBy(xpath = "//*[@id='TABS-li6nms2WjL']/div[1]/div[1]/div/div[5]")
    private WebElement harita;
    @FindBy(xpath = "//*[@id='TABS-li6nms2WjL']/div[1]/div[1]/div/div[5]")
    private WebElement satışAnalizi;

    public void verifyAnalysisElement(int timeout) {
        BrowserUtils.waitForVisibility(analysis, timeout);
        Assert.assertTrue(analysis.isDisplayed());
        analysis.click();
    }
    public void onTheKPIPanelPage() {
        BrowserUtils.wait(5);
        KPIPanel.click();
    }
    public void overviewVerifies(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(overview,25);
        Assert.assertTrue(overview.isDisplayed());
        driver.switchTo().defaultContent();
    }

    public void overviewVerifiesHakedis(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(overview,25);
        Assert.assertTrue(hakedis.isDisplayed());
        hakedis.click();
        BrowserUtils.wait(5);
        driver.switchTo().defaultContent();
    }
    public void overviewVerifiesAylıkSatıs(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(overview,25);
        Assert.assertTrue(aylıksatıs.isDisplayed());
        aylıksatıs.click();
        BrowserUtils.wait(6);
        driver.switchTo().defaultContent();
    }

    public void overviewVerifiesAPrim_Analizi(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(overview,25);
        Assert.assertTrue(primAnalizi.isDisplayed());
        primAnalizi.click();
        BrowserUtils.wait(6);
        driver.switchTo().defaultContent();
    }
    public void overviewVerifiesHarita(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(harita,25);
        Assert.assertTrue(harita.isDisplayed());
        harita.click();
        BrowserUtils.wait(6);
        driver.switchTo().defaultContent();
    }
    public void overviewVerifiesSatışAnalizi(){
        BrowserUtils.wait(5);
        driver.switchTo().frame(0);
        BrowserUtils.waitForVisibility(satışAnalizi,25);
        Assert.assertTrue(harita.isDisplayed());
        satışAnalizi.click();
        BrowserUtils.wait(6);
        driver.switchTo().defaultContent();
    }
}
