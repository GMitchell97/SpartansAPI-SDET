Feature: Filter by end date

  Background: I have a valid API key and use it when making a query
    Given I use a valid API key

  @Happy
  Scenario: Search for Spartans who end their contract on specific date
    When I search for Spartans who end their contract on a specified full date
    Then I get a list of Spartans who end their contract on the specified full date

  Scenario: Search for Spartans who end their contract within a specific date range
    When I search for Spartans who end their contract who end their contract within a specified date range
    Then I get a list of Spartans who end their contract within the specified date range

  @Sad
  Scenario: Search for Spartans who end their contract using an invalid date
    When I search for Spartans who end their contract on an invalid full date
    Then I should get a error response