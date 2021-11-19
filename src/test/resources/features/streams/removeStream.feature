@SmokeTests @WIP @Remove
Feature: Remove a stream by Id
  Background:
    Given I have a valid stream ID
  @Happy @Status
  Scenario: Trying to remove a stream with valid Id, status code 200 received
    When I make a request to remove a stream with valid ID
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: Trying to remove a stream with a valid Id, correct message returned
    When I make a request to remove a stream with valid ID
    Then I get back an error message "Record deleted"

  @Sad @Status
  Scenario: Trying to remove a stream with an invalid Id, status code 200 received
    When I make a request to remove a stream with invalid ID
    Then I get back a 200 response code

  @Sad @Error
  Scenario: Trying to remove a stream with an invalid Id, error message returned
    When I make a request to remove a stream with invalid ID
    Then I get back an error message "No record found"