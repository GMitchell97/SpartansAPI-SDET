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
    Then I get back a <response> response code

    Examples:
      | stream | response |
      | Java%20Dev | 200    |
      | C#%20Dev   | 200    |
      | Java%20SDET | 200   |
      | java      | 204   |
      | JAVA      | 204   |
      | Ruby      | 204   |

  @Sad @Error
  Scenario Outline: Querying a Spartan with an invalid stream name
    When I make a valid request by stream name "<stream>"
    Then I get back an error message

    Examples:
      | stream |
      | afad1324 |
      | 345678;  |
      | asd dsa  |

  @Sad @Status
  Scenario Outline: Querying a Response with an invalid stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a <response> response code

    Examples:
      | stream | response |
      | afad1324 | 500    |
      | 345678;  | 500    |
      | asd dsa  | 500    |
      | hi... | 500 |