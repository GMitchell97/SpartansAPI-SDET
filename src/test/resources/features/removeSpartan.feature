Feature: Remove a Spartan by Id

  @Happy
  Scenario: Trying to remove a Spartan with a valid Id
    Given I have made a POST request to /spartan?id={spartanId} with a valid spartanId to delete that spartan's records
    Then I should receive a 200 code status
    And a message saying the spartan with that Id has been deleted

  @Sad
  Scenario: Trying to remove a Spartan with an invalid Id
    Given I have made a POST request to /spartan?id={spartanId} with an invalid spartanId to delete that spartan's records
    Then should receive a 404 code status
    And a message saying the spartan id is invalid or not found