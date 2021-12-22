@PostBooking
Feature: POST create booking for user
  As a user
  I want to create bbooking
  So that I am success create booking

  @TC_1 #Success
  Scenario Outline: User want create booking
    Given I am logged in as user
    And I am set body request product_id "<product_id>" time_in "<time_in>" time_out "<time_out>" qty "<qty>"
    When I am hit endpoint create booking method post
    Then I am get status code 200 create booking
    And validate response success create booking "success create new booking"
    Examples:
      | product_id | time_in    | time_out   | qty |
      | 5          | 2021-12-21 | 2021-12-25 | 3   |

  @TC_2 #Success
  Scenario Outline: User want create booking from personal rental booking
    Given I am logged in as user
    And I am set body request product_id "<product_id>" time_in "<time_in>" time_out "<time_out>" qty "<qty>"
    When I am hit endpoint create booking method post
    Then I am get status code 400 create booking
    And validate response success create booking "failed create booking"
    Examples:
      | product_id | time_in    | time_out   | qty |
      | 5          | 2021-12-21 | 2021-12-25 | 3   |

  @TC_3
  Scenario Outline:


