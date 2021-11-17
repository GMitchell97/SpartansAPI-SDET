@SmokeTests @FilterCourse @WIP
Feature: Filter Spartan by course name

  @Happy @View
  Scenario Outline: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "<course>"
    Then I get back a list of Spartans that contain the course name "<course>"

    Examples:
      | course |
      | Engineering 95 |
      | Business 67   |
      | Engineering 96 |

  @Happy @Status
  Scenario Outline: Querying a Response code with course name
    When I make a valid request by course name "<course>"
    Then I get back a <response> response code

    Examples:
      | course | response |
      | Engineering 95 | 200 |
      | Business 67   | 200  |
      | Engineering 96 | 200 |
      | ENGINEERING 95 | 204 |
      | engineering 96 | 204 |
      | BUSINESS 67 | 204    |
      | engineering | 204    |
      | Maths       | 204    |

  @Happy @Error
  Scenario Outline: Querying a Spartan with an valid course name
    When I make a valid request by course name "<course>"
    Then I get back an error message

    Examples:
      | course |
      | ENGINEERING 95 |
      | engineering 96 |
      | BUSINESS 67 |
      | engineering |
      | asdfghjkl  |
      | Maths      |

    @Sad @Error
      Scenario Outline: Querying a response with an invalid course name
        When I make a valid request by course name "<course>"
        Then I get back an error message

      Examples:
        | course |
        | afad1324 |
        | 345678;  |
        | asd dsa  |

  @Sad @Status
  Scenario Outline: Querying a response with an invalid course name
    When I make a valid request by course name "<course>"
    Then I get back a <response> response code

    Examples:
      | course | response |
      | afad1324 | 500    |
      | 345678;  | 500    |
      | asd dsa  | 500    |
      | hi... | 500 |

