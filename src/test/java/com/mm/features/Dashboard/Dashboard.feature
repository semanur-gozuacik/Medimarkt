@mm
Feature: General Dashboard
  Background:
    When   The User opens the browser with the given url
    And   The User inputs a valid username "validUsername"
    And   The User inputs a valid password "validPassword"
    And   The User clicks the Submit button
    Then  The User waits until the Analysis element is visible with a timeout of 120 seconds
    Given The user is on the Analysis KPIPanel

  Scenario:KPIPanel Overview tab Verify
    When  The user KPIPanel page verifies

  Scenario:KPIPanel Overview tab Verify Hakediş Ekranı
    When  The user KPIPanel page verifies - Hakediş

  Scenario:KPIPanel Overview tab Verify Aylık Satış
    When  The user KPIPanel page verifies-Aylık Satış

  Scenario:KPIPanel Overview tab Verify Prim Analizi
    When  The user KPIPanel page verifies- Prim Analizi

  Scenario:KPIPanel Overview tab Verify Harita
    When  The user KPIPanel page verifies- Harita

  Scenario:KPIPanel Overview tab Verify Satış Analizi
    When  The user KPIPanel page verifies- Satış Analizi