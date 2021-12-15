@Login
Feature: Login
  As a Rentz Web API
  I want to see items from Rentz Web
  So I can checkout the item then I pay for my rent

@Success
  Scenario: Login Success
    Given I am on the login page
    When I enter my email and password correctly
    And I click 'Submit' button
    Then I am taken to the HomePage