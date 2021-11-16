Feature: Filter by start date

  Scenario: Querying by start date by year and month
    When I make a valid request by year and month "2021 11"
    Then the a list of all Sparta trainees who joined within that month and year and after should be returned

  Scenario: Querying by start date by year, month, and day
    When I make a valid request by year month and day "2021 11 16"
    Then It should only contain spartans who have started on and after "2021 11 16"

    Scenario: Querying by start date by year
    When I make a valid request by year "2021"
    Then A list of spartans who joined from or after a specified year should be returned