package com.mm.stepDefs;

import com.mm.utulities.Driver;
import com.mm.utulities.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseStep {  // BaseStep, diğer adım (step) sınıfları tarafından genişletilecek temel adım sınıfını temsil eder.
    // Sayfa nesnelerine ve işlevlerine erişimi sağlamak için Pages sınıfından bir nesne oluşturulur.

    protected Pages pages = new Pages();

}