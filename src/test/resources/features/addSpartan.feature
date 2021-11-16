Feature: Add a Spartan to the database

  @Happy
  Scenario: Add a new entry in spartan collection with all valid fields, status code 200 received
    When I make a POST request to add a spartan
    And all the fields are correct
    Then I should get back a 200 code

  @Happy
  Scenario: Add a new entry in spartan collection with all valid fields
    When I make a POST request to add a spartan
    And all the fields are correct
    Then I should get back a message that {spartanId} has been added

  @Sad
  Scenario: Trying to add a Spartan with an invalid field values, status code 400 received
    When I make a POST request to add a spartan
    And the fields are incorrect
    Then I should get back a 400 code

  @Sad
  Scenario: Trying to add a Spartan with an invalid field values, error message received
    When I make a POST request to add a spartan
    And the fields are incorrect
    Then I should get back a message that the entry is invalid