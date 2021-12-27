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

  @Checkout_2 #failed
  Scenario: User checkout booking without booking_id using OVO
    Given I am logged in user
    When I am set body failed without booking_id request checkout with ovo
    Then I am get statuscode 404
    And validate checkout failed response body message "Please Input Your Booking" status "failed"

  @Checkout_3 #failed
  Scenario: User checkout booking without phone using OVO
    Given I am logged in user
    When I am set body failed without phone request checkout with ovo
    Then I am get statuscode 404
    And validate checkout failed response body message "Please Input Your OVO Number" status "failed"

  @Checkout_4 #success
  Scenario: User checkout booking other than ovo
    Given I am logged in user
    When I am set body request checkout other than ovo
    Then I am get statuscode 200
    And validate checkout with other than ovo response body code 200 message "Your CheckOut Success"

  @Checkout_5 #failed
  Scenario: User checkout booking other than ovo without booking_id
    Given I am logged in user
    When I am set body request checkout other than ovo without booking_id
    Then I am get statuscode 404
    And validate checkout failed response body message "Please Input Your Booking" status "failed"

  @Checkout_6 #failed
  Scenario: User checkout booking other than ovo without checkout_method
    Given I am logged in user
    When I am set body request checkout other than ovo without checkout_method
    Then I am get statuscode 400
    And validate checkout with failed response body code 400 message "You Must Choose Payment Method"