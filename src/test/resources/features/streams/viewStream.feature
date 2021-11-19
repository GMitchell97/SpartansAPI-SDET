@SmokeTests @ViewAll
Feature: View all Streams
  @Happy @Status
  Scenario: Querying a Response code with view all spartans
    When I make a GET request to all streams
    Then I get back a 200 response code

  @Happy @View
  Scenario: I make a valid request to view all spartans, I receive a JSON response with all the spartans in the database
    When I make a GET request to all streams
    Then receive a list of all "streams" in a json format