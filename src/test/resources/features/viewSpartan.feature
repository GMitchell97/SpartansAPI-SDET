Feature: View all spartans
  @Happy
  Scenario: I make a valid request to view all spartans,
  I receive a a 200 response code
    When I make a GET request to /all
    Then I should get back a 200 code

Feature: View all spartans
  @Happy
  Scenario: I make a valid request to view all spartans,
  I receive a JSON response with all the spartans in the database
    When I make a GET request to /all
    Then receive a list of all spartans in a json format

  @Sad
  Scenario: I make an invalid request to view all spartans, receive an 204 status code
    When I make a GET request to /all
    Then I should get back a 204 code

  @Sad
  Scenario: I make an invalid request to view all spartans, receive an error message
    When I make a GET request to /all
    Then I should get back a message that {spartanId} does not exist