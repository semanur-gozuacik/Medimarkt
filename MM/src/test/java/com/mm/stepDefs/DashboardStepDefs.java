package com.mm.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Then("The User waits until the Analysis element is visible with a timeout of {int} seconds")
    public void theUserWaitsUntilTheAnalysisElementIsVisibleWithATimeoutOfSeconds(Integer timeout) {
        pages.dashboard().verifyAnalysisElement(timeout);

    }

    @Given("The user is on the Analysis KPIPanel")
    public void theUserIsOnTheAnalysisKPIPanel() {
        pages.dashboard().onTheKPIPanelPage();
    }

    @When("The user KPIPanel page verifies")
    public void theUserCocpitPageVerifies() {
        pages.dashboard().overviewVerifies();
    }
    @When("The user KPIPanel page verifies - Hakediş")
    public void theUserKPIPanelPageVerifiesHakediş() {
        pages.dashboard().overviewVerifiesHakedis();
    }

    @When("The user KPIPanel page verifies-Aylık Satış")
    public void theUserKPIPanelPageVerifiesAylıkSatış() {
        pages.dashboard().overviewVerifiesAylıkSatıs();
    }

    @When("The user KPIPanel page verifies- Prim Analizi")
    public void theUserKPIPanelPageVerifiesPrimAnalizi() {
        pages.dashboard().overviewVerifiesAPrim_Analizi();
    }

    @When("The user KPIPanel page verifies- Harita")
    public void theUserKPIPanelPageVerifiesHarita() {
        pages.dashboard().overviewVerifiesHarita();
    }

    @When("The user KPIPanel page verifies- Satış Analizi")
    public void theUserKPIPanelPageVerifiesSatışAnalizi() {
        pages.dashboard().overviewVerifiesSatışAnalizi();
    }
}
