Feature: Filter by start date

  Scenario: Querying by start date by year and month
    Given I make a request to /spartan?startdate={year}-{month}
    When I have entered a month and year
    Then the a list of all Sparta trainees who joined within that month and year and after should be returned

  Scenario: Querying by start date by year, month, and day
    Given I make a request to /spartan?startdate={year}-{month}-{day}
    When I receive the response
    Then It should only contain spartans who have started on and after {year}/{month}/{day}

    Scenario: Querying by start date by year
    Given I make a request to /spartan?startdate={year}
    When I enter a year
    Then A list of spartans who joined from or after a specified year should be returned