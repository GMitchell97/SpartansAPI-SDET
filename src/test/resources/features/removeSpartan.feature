Feature: Remove a Spartan by Id

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id, status code 200 received
    When I have made a POST request to remove a spartan by id
    And I use a valid id
    Then I should get back a 200 code

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id, correct message returned
    When I have made a POST request to remove a spartan by id
    And I use a valid id
    Then I should get back a message that {spartanId} has been deleted

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id, status code 400 received
    When I have made a POST request to remove a spartan by id
    And I use an invalid id
    Then I should get back a 400 code

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id, error message returned
    When I have made a POST request to remove a spartan by id
    And I use an invalid id
    Then I should get back a message that {spartanId} does not exist or is not valid