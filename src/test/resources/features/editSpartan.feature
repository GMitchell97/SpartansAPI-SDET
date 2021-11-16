Feature: Update a spartan by Id

  @Happy
  Scenario: If there is an id in the system I want to get back a 200 response code and update the spartan
    Given I use a valid API key
    When I make a POST request to /spartan?id={spartanId} with an existing Id
    Then the field should be updated
    And I should get back a 200 code
    And I should get back a message that {spartanId} has been updated

  @Sad
  Scenario:  If there isn't an id in the system I want to get back a 404 response code
    Given I use a valid API key
    When I make a POST request to /spartan?id={spartanId} with an non-existing Id
    Then I should get back a 404 code
    And I should get back a message that {spartan id} is invalid or not found