Feature: Update a spartan by Id
  Background:
    Given I use a valid API key
  @Happy
  Scenario: If there is an id in the system I want to get back a 200 response code and update the spartan
    When I make a valid POST request to an existing Id
    Then the spartan should be updated
    And I should get back a 200 code
    And I should get back a message that the spartan has been updated

  @Sad
  Scenario:  If there isn't an id in the system I want to get back a 404 response code
    When I make a valid POST request to a  non-existing Id
    Then I should get back a 404 code
    And I should get back a message that the Id is not found