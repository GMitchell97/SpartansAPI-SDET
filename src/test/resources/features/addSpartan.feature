Feature: Add a Spartan to the database

  @Happy
  Scenario: Add a new entry in spartan collection with all valid fields, status code 200 received
    When I make a request to add a spartan with correct fields
    Then I should get back a 200 response code

  @Happy
  Scenario: Add a new entry in spartan collection with all valid fields
    When I make a request to add a spartan with correct fields
    Then I should get back a message that "spartanId" has been added

  @Sad
  Scenario: Trying to add a Spartan with an invalid field values, status code 400 received
    When I make a request to add a spartan with incorrect fields
    Then I should get back a 400 response code

  @Sad
  Scenario: Trying to add a Spartan with an invalid field values, error message received
    When I make a request to add a spartan with incorrect fields
    Then I should get back a message that the entry is invalid