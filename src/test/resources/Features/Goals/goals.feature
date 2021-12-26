@Goals
Feature: User booking goals to mvp
  As a user booking
  I want to goals mvp
  So that I am success goals mvp

  @GoalsOVO
  Scenario: User performs an mvp success by using ovo
    Given I am logged as user rental
    And Or I am logged as user booking
    When I am set body request create product as user rental
    And I am set body request booking product as user booking
    And I am set body request checkout booking with ovo
    Then I am get statucscode 200 goals mvp
    And validate success checkout with ovo response code 200 and message "Your CheckOut Success"

  @GoalsOtherOVO
  Scenario: user performs an mvp success by using other ovo
    Given I am logged as user rental
    And Or I am logged as user booking
    When I am set body request create product as user rental
    And I am set body request booking product as user booking
    And I am set body request checkout booking with other ovo
    Then I am get statucscode 200 goals mvp
    And validate success checkout with other ovo response code 200 and message "Your CheckOut Success"