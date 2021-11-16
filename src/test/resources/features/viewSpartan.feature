Feature: View all spartans
  @Happy
  Scenario: I make a valid request to view all spartans,
  I receive a JSON response with all the spartans in the database
    When I make a GET request to /all
    Then I should get back a 200 code
    And receive a list of all spartans in a json format

Feature: View all spartans
  @Sad
  Scenario: I make an invalid request to view all spartans,
  I receive a 400 status code and receive an error message
    When I make a GET request to /all
    Then I should get back a 400 code
    And receive the following error message "message"