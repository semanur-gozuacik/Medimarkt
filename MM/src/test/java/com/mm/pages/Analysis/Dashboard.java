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
}
