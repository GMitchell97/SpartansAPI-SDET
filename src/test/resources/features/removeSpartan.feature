@SmokeTests @WIP @Remove
Feature: Remove a Spartan by Id
  Given I have a valid spartan ID
  @Happy @Status
  Scenario: Trying to remove a Spartan with a valid Id, status code 200 received
    When I make a request to remove a spartan with valid ID
    Then I get back a 200 response code

  @Happy @Confirm
  Scenario: Trying to remove a Spartan with a valid Id, correct message returned
    When I make a request to remove a spartan with valid ID
    Then I get back an error message

  @Sad @Status
  Scenario: Trying to remove a Spartan with an invalid Id, status code 400 received
    When I make a request to remove a spartan with invalid ID
    Then I get back a 400 response code

  @Sad @Error
  Scenario: Trying to remove a Spartan with an invalid Id, error message returned
    When I make a request to remove a spartan with invalid ID
    Then I get back an error message