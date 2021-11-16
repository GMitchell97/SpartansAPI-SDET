Feature: Remove a Spartan by Id

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id
    When I have made a POST request to remove a spartan by id
    And I use a valid id
    Then I should get back a 200 code
    And I should get back a message that {spartanId} has been deleted

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id
    When I have made a POST request to remove a spartan by id
    And receive the following error message "message"
    And I use an invalid id
    Then I should get back a 204 code
    And I should get back a message that {spartanId} does not exist