package com.mm.utulities;

import com.mm.pages.Analysis.Dashboard;
import com.mm.pages.Analysis.SicilControlPage;
import com.mm.pages.HomePage;
import com.mm.pages.LoginPage;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private Dashboard dashboard;
    private SicilControlPage sicilControlPage;

    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.dashboard = new Dashboard();
        this.sicilControlPage = new SicilControlPage();
    }


    public HomePage homePage() {return homePage;}
    public LoginPage loginPage(){return loginPage;}
    public Dashboard dashboard(){return dashboard;}
    public SicilControlPage sicilControlPage() {return sicilControlPage;}

}