@WIP @FilterStream
Feature: Filter Spartan by stream name

  @Happy @View
  Scenario Outline: Querying a Spartan with a first-letter capitalised stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a JSON response containing all Spartans with that String in their stream name "<stream1>"

    Examples:
    | stream | stream1 |
    | Java%20Dev | Java Dev|
    | C#%20Dev   | C# Dev  |
    | Java%20SDET | Java SDET|

  @Happy @Status
  Scenario Outline: Querying a Response code with a first-letter capitalised stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a <response> response code

    Examples:
      | stream | response |
      | Java%20Dev | 200    |
      | C#%20Dev   | 200    |
      | Java%20SDET | 200   |
      | java      | 200   |
      | JAVA      | 200   |
      | Ruby      | 200   |

  @Sad @Error
  Scenario Outline: Querying a Spartan with an invalid stream name
    When I make a valid request by stream name "<stream>"
    Then I get back an error message "Field format invalid"

    Examples:
      | stream |
      | 345678;  |
      | asd dsa  |

  @Sad @Status
  Scenario Outline: Querying a Response with an invalid stream name
    When I make a valid request by stream name "<stream>"
    Then I get back a <response> response code

    Examples:
      | stream | response |
      | 345678;  | 400    |
      | asd dsa  | 400    |
