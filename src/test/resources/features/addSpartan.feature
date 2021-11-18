@SmokeTests @Add @WIP
Feature: Add a Spartan to the database

  @Happy @Status
  Scenario: Add a new entry in spartan collection with all valid fields, status code 201 received
    When I make a request to add a spartan with correct fields
    Then I get back a 201 response code

  @Happy @Confirm
  Scenario: Add a new entry in spartan collection with all valid fields
    When I make a request to add a spartan with correct fields
    Then I get back the new spartan

  @Happy @Message
  Scenario: Add a new entry in spartan collection with all valid fields
    When I make a request to add a spartan with correct fields
    Then I get back an error message "Record added"

  @Sad @Status
  Scenario: Trying to add a Spartan with an invalid field values, status code 400 received
    When I make a request to add a spartan with incorrect fields
    Then I get back a 400 response code

  @Sad @Error
  Scenario: Trying to add a Spartan with an invalid field values, error message received
    When I make a request to add a spartan with incorrect fields
    Then I get back an error message "Field format invalid"
    #Field format invalid isn't currently added, however devs are working on it