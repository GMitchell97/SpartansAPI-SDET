Feature: View all spartans
  @Happy
  Scenario: Querying a Response code with view all spartans
    When I make a GET request to all
    Then I get back a 200 response code

Feature: View all spartans
  @Happy
  Scenario: I make a valid request to view all spartans, I receive a JSON response with all the spartans in the database
    When I make a GET request to all
    Then receive a list of all spartans in a json format

  @Sad
  Scenario: Querying a Response code with an invalid request to view all spartans
    When I make a GET request to al
    Then I get back a 400 response code

  @Sad
  Scenario: I make an invalid request to view all spartans, receive an error message
    When I make a GET request to al
    Then I get back an error message