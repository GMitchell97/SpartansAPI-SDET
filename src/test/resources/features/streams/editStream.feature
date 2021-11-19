@SmokeTests @Update @WIP
Feature: Update a stream by Id

  Background:
    Given I use a valid API key
    Given I have a valid stream ID

  @Happy
  Scenario: If there is an id in the system I want to update the stream
    When I make a valid PUT request to an existing streamId
    Then I get back a response message "Record updated"

  @Happy @Status
  Scenario: If there is an id in the system I want to get back a 200 response code
    When I make a valid PUT request to an existing streamId
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: If there is an id in the system I want to get back a message that the stream has been updated
    When I make a valid PUT request to an existing streamId
    Then I get back a response message "Record updated"

  @Sad @Status
  Scenario:  If there isn't an id in the system I want to get back a 204 response code
    When I make a valid PUT request to a non-existing streamId
    Then I get back a 200 response code

  @Sad @Error
  Scenario:  If there isn't an id in the system
    When I make a valid PUT request to a non-existing streamId
    Then I get back an error message "No record found"