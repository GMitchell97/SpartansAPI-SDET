@WIP @FilterStream
Feature: Filter Spartan by stream name

  @Happy @View
  Scenario Outline: Querying a Spartan with a first-letter capitalised stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a JSON response containing all Spartans with that String in their stream name "<stream>"

    Examples:
    | stream |
    | Java Dev |
    | C# Dev   |
    | Java SDET |

  @Happy @Status
  Scenario Outline: Querying a Response code with a first-letter capitalised stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a 200 response code

    Examples:
      | stream |
      | Java Dev |
      | C# Dev   |
      | Java SDET |

  @Happy @Status
  Scenario: Querying a response code with a non-Capitalised stream name
    When I make a valid request by stream name "java"
    Then I get back a 204 response code

  @Sad @Error
  Scenario: Querying a Spartan with an invalid stream name
    When I make a valid request by stream name "java"
    Then I get back an error message

  @Happy @Status
  Scenario: Querying a Response code with a capitalised stream name
    When I make a valid request by stream name "JAVA"
    Then I get back a 204 response code

  @Happy @Error
  Scenario: Querying a Spartan with an capitalised stream name
    When I make a valid request by stream name "JAVA"
    Then I get back an error message

  @Happy @Status
  Scenario: Querying a Response code with an invalid stream name
    When I make a valid request by stream name "Ruby"
    Then I get back a 204 response code

  @Sad @Error
  Scenario: Querying a Spartan with an invalid stream name
    When I make a valid request by stream name "Ruby"
    Then I get back an error message