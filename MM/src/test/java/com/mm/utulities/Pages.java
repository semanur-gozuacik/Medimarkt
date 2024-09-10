package com.mm.utulities;

import com.mm.pages.Analysis.Dashboard;
import com.mm.pages.HomePage;
import com.mm.pages.LoginPage;

public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private Dashboard dashboard;

    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.dashboard= new Dashboard();
    }
    public HomePage homePage() {
        return homePage;
    }
    public LoginPage loginPage(){
        return loginPage;
    }
    public Dashboard dashboard(){return dashboard;}
}