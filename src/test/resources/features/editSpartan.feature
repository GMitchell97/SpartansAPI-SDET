Feature: Update a spartan by Id

  @Happy
  Scenario: As a use I want to edit a spartan that exists
    Given I use a valid API key
    When I make a POST request to /spartan?id={spartanId} with an existing Id
    Then the field should be updated
    And I should get back a 200 code
    And I should get back a message that {spartanId} has been updated

  @Sad
  Scenario: As a user I want an error to occur if I try edit a wrong spartan
    Given I use a valid API key
    When I make a POST request to /spartan?id={spartanId} with an non-existing Id
    Then I should get back a 404 code
    And I should get back a message that {spartan id} is invalid or not found