Feature: Remove a Spartan by Id

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id, status code 200 received
    When I make a request to remove a spartan with ID "validid"
    Then I should get back a 200 response code

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id, correct message returned
    When I make a request to remove a spartan with ID "validid"
    Then I should get back a message that "validid" has been deleted

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id, status code 400 received
    When I make a request to remove a spartan with ID "invalidid"
    Then I should get back a 400 response code

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id, error message returned
    When I make a request to remove a spartan with ID "invalidid"
    Then I should get back an error message