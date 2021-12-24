@BookingProduct
Feature: POST create booking for user
  As a user
  I want to create booking
  So that I am success create booking

  @PostBooking1 #Success
  Scenario: User want create booking
    Given I am logged in as user
    And I am set body request create booking
    When I am hit endpoint create booking method post
    Then I get status code 200
    And validate success create booking response message "success create new booking" status "success"

  @PostBooking2 #FAILED
  Scenario: User want create booking from personal rental booking
    Given I am logged in as user
    And I am set body request create booking from personal rental booking
    When I am hit endpoint create booking method post
    Then I get status code 400
    And validate failed create booking response body code 400 message "Cannot booking own products"

  @PostBooking3 #Sukses
  Scenario: User want create booking at the same request time_in and time_out
    Given I am logged in as user
    And I am set body request at the same request time_in and time_out
    When I am hit endpoint create booking method post
    Then I get status code 200
    And validate success create booking response message "success create new booking" status "success"

  @PostBooking4 #Sukses
  Scenario Outline: User checks availability booking
    Given I am logged in as user
    And I am set body request time_in "<time_in>" time_out "<time_out>"
    When I am hit endpoint search booking method post by ID_Booking
    Then I get status code 200
    And validate success search booking code 200 message "Item available"
    Examples:
      | time_in    | time_out   |
      | 2022-12-25 | 2022-12-22 |

  @GetBooking #Sukses
  Scenario: User want get booking by ID_Booking
    Given I am logged in as user
    When I am hit endpoint get booking method get by ID_Booking
    Then I get status code 200
    And validate success get booking code 200 message "Successful Operation"

  @DeleteBooking #Sukses
  Scenario: User want Cancel Booking
    Given I am logged in as user
    When I am hit endpoint cancel booking method delete by ID_Booking
    Then I get status code 200
    And validate success delete booking code 200 message "Successful Operation"