@SmokeTests @Update @WIP
Feature: Update a course by Id

  Background:
    Given I use a valid API key
    Given I have a valid course ID

  @Happy
  Scenario: If there is an id in the system I want to update the course
    When I make a valid PUT request to an existing courseId
    Then the course should be updated

  @Happy @Status
  Scenario: If there is an id in the system I want to get back a 200 response code
    When I make a valid PUT request to an existing courseId
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: If there is an id in the system I want to get back a message that the course has been updated
    When I make a valid PUT request to an existing courseId
    Then I get back a response message "Record updated"

  @Sad @Status
  Scenario:  If there isn't an id in the system I want to get back a 200 response code
    When I make a valid PUT request to a non-existing courseId
    Then I get back a 200 response code

  @Sad @Error
  Scenario:  If there isn't an id in the system
    When I make a valid PUT request to a non-existing courseId
    Then I get back an error message "No record found"