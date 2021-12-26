@CheckoutProduct
Feature: checkout booking for user
  As a user
  I want to checkout booking
  So that I am success checkout booking

  @Checkout_1 #success
  Scenario: User checkout booking with ovo
    Given I am logged in user
    When I am set body request checkout with ovo
    Then I am get statuscode 200
    And validate checkout with ovo response body code 200 message "Your CheckOut Success"

  @Checkout_2 #success
  Scenario: User checkout booking other than ovo
    Given I am logged in user
    When I am set body request checkout other than ovo
    Then I am get statuscode 200
    And validate checkout with other than ovo response body code 200 message "Your CheckOut Success"