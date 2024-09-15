package com.mm.pages;

import com.mm.utulities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//img[@id='navLogo']")
    private WebElement basariliLoginDogrulama;
    @FindBy(id = "MDM")
    private WebElement MDM;
    @FindBy(id = "Persons")
    private WebElement Persons;

    public HomePage() {
    }

    public void verifyMDMElement(int timeout) {
        BrowserUtils.waitForVisibility(MDM, timeout);
        Assert.assertTrue(MDM.isDisplayed());
    }

    public void verifyPersonsElement(int timeout) {
        BrowserUtils.waitForVisibility(Persons, timeout);
        Assert.assertTrue(Persons.isDisplayed());
    }
}