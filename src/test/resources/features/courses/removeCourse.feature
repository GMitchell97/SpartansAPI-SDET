@SmokeTests @WIP @Remove
Feature: Remove a course by Id
  Background:
    Given I have a valid course ID

  @Happy @Status
  Scenario: Trying to remove a course with valid Id, status code 200 received
    When I make a request to remove a course with valid ID
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: Trying to remove a course with a valid Id, correct message returned
    When I make a request to remove a course with valid ID
    #Injector defaults to errorDTO, cannot
    Then I get back an error message "Record deleted"

  @Sad @Status
  Scenario: Trying to remove a course with an invalid Id, status code 200 received
    When I make a request to remove a course with invalid ID
    Then I get back a 200 response code

  @Sad @Error
  Scenario: Trying to remove a course with an invalid Id, error message returned
    When I make a request to remove a course with invalid ID
    Then I get back an error message "No record found"