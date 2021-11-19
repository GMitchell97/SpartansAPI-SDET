@SmokeTests @Add @WIP
Feature: Add a stream to the database

  @Happy @Status
  Scenario: Add a new entry in stream collection with all valid fields, status code 200 received
    When I make a request to add a stream with correct fields
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: Add a new entry in stream collection with all valid fields
    When I make a request to add a stream with correct fields
    Then I get back a message "Record added"

  @Sad @Status
  Scenario: Trying to add a stream with an invalid field values, status code 400 received
    When I make a request to add a stream with incorrect fields
    Then I get back a 400 response code


  @Sad @Error
  Scenario: Trying to add a stream with an invalid field values, error message received
    When I make a request to add a stream with incorrect fields
    Then I get back an error message "Field format invalid"