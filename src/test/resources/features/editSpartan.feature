@SmokeTests @Update @WIP
Feature: Update a spartan by Id
  Background:
    Given I use a valid API key
    Given I have a valid spartan ID

  @Happy
  Scenario: If there is an id in the system I want to update the spartan
    When I make a valid PUT request to an existing Id
    Then the spartan should be updated

  @Happy @Status
  Scenario: If there is an id in the system I want to get back a 200 response code
    When I make a valid PUT request to an existing Id
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: If there is an id in the system I want to get back a message that the spartan has been updated
    When I make a valid PUT request to an existing Id
    Then I get back an error message ""

  @Sad @Status
  Scenario:  If there isn't an id in the system I want to get back a 404 response code
    When I make a valid PUT request to a non-existing Id
    Then I get back a 404 response code

  @Sad @Error
  Scenario:  If there isn't an id in the system I want to get back a 404 response code
    When I make a valid PUT request to a non-existing Id
    Then I get back an error message ""