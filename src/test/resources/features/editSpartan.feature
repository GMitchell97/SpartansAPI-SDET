Feature: Update a spartan by Id

  @Happy
  Scenario: Editing a spartan that exists
      Given I have made a request to /spartan?id={spartanId} with an existin
      Then I should get a 200 code
      And I should get a message that Id has been updated

  @Sad
  Scenario: Trying to edit a spartan that doesn't exist
    Given I have made a request to /spartan?id={spartanId} with an non-existing Id
    Then I should get a 404 code
    And I should get a message that spartan id is invalid or not found