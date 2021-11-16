Feature: Filter by start date

  Scenario: Querying by start date by year and month
    When I make a valid request by year and month "2021 11"
    Then I get back a Json array of Spartans that joined on or after "2021 11"

  Scenario: Querying Response code of start date by year and month
    When I make a valid request by year and month "2021 11"
    Then I get back a 200 response code

  Scenario: Querying by start date by year, month, and day
    When I make a valid request by year month and day "2021 11 16"
    Then I get back a Json array of Spartans that joined on or after "2021 11 16"

  Scenario: Querying Response code of start date by year, month, and day
    When I make a valid request by year month and day "2021 11 16"
    Then I get back a 200 response code

    Scenario: Querying by start date by year
    When I make a valid request by year "2021"
    Then I get back a Json array of Spartans that joined on or after "2021"

  Scenario: Querying Response code of start date by year
    When I make a valid request by year "2021"
    Then I get back a 200 response code