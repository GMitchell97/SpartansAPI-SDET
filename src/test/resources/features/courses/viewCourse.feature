@SmokeTests @ViewAll
Feature: View all courses
  @Happy @Status
  Scenario: Querying a Response code with view all courses
    When I make a GET request to all courses
    Then I get back a 200 response code

  @Happy @View
  Scenario: I make a valid request to view all courses, I receive a JSON response with all the spartans in the database
    When I make a GET request to all courses
    Then receive a list of all "courses" in a json format