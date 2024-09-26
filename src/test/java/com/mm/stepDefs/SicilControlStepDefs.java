package com.mm.stepDefs;

import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class SicilControlStepDefs extends BaseStep{
    Map<String, String> sicilsAndStoreCodes = new HashMap<>();

    @When("The user gets data from database")
    public void theUserGetsDataFromDatabase() {
        sicilsAndStoreCodes = pages.sicilControlPage().getDataFromDataBase();
    }

    @When("The user verifies that sicilNumbers has correct storeCode")
    public void theUserVerifiesThatSicilNumbersHasCorrectStoreCode() {
        pages.sicilControlPage().verifySicilNumbersHasCorrectStoreCode(sicilsAndStoreCodes);
    }
}
