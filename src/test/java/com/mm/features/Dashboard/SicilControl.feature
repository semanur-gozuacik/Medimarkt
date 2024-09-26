@mm2
Feature: Sicil Control

  Background:
    Given The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    And   The User waits until the Analysis element is visible with a timeout of 120 seconds

  Scenario: Sicil Control
    When The user gets data from database
    When The user verifies that sicilNumbers has correct storeCode
