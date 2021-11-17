@SmokeTests @WIP @ViewAll
Feature: View all spartans
  @Happy @Status
  Scenario: Querying a Response code with view all spartans
    When I make a GET request to all
    Then I get back a 200 response code

  @Happy @View
  Scenario: I make a valid request to view all spartans, I receive a JSON response with all the spartans in the database
    When I make a GET request to all
    Then receive a list of all spartans in a json format