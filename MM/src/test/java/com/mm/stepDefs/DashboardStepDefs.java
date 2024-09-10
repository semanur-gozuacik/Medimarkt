package com.mm.stepDefs;

import io.cucumber.java.en.When;

public class DashboardStepDefs extends BaseStep{

    @When("The User opens the browser with the given url")
    public void the_user_opens_the_browser_with_the_given_url() {

    }
    @When("The User inputs a valid username {string}")
    public void the_user_inputs_a_valid_username(String username) {
        pages.loginPage().setUsernameField(username);
    }

    @When("The User inputs a valid password {string}")
    public void the_user_inputs_a_valid_password(String password) {
        pages.loginPage().setPasswordField(password);

    }
    @When("The User clicks the Submit button")
    public void the_user_clicks_the_submit_button() {
        pages.loginPage().clickLoginButton();
    }
}
