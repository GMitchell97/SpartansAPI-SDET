@SmokeTests @FilterCourse @WIP
Feature: Filter Spartan by course name

  @Happy @View
  Scenario Outline: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "<course>"
    Then I get back a list of Spartans that contain the course name "<course1>"

    Examples:
      | course |  course1 |
      | Engineering%2095 | Engineering 95 |
      | Business%2067   | Business 67     |
      | Engineering%2096 | Engineering 96 |

  @Happy @Status
  Scenario Outline: Querying a Response code with course name
    When I make a valid request by course name "<course>"
    Then I get back a <response> response code

    Examples:
      | course | response |
      | Engineering%2095 | 200 |
      | Business%2067   | 200  |
      | Engineering%2096 | 200 |
      | ENGINEERING%2095 | 204 |
      | engineering%2096 | 204 |
      | BUSINESS%2067 | 204    |
      | engineering | 204    |
      | Maths       | 204    |

  @Happy @Error
  Scenario Outline: Querying a Spartan with an valid course name
    When I make a valid request by course name "<course>"
    Then I get back an error message "No record found"

    Examples:
      | course |
      | ENGINEERING%2095 |
      | engineering%2096 |
      | BUSINESS%2067 |
      | engineering |
      | asdfghjkl  |
      | Maths      |

    @Sad @Error
      Scenario Outline: Querying a response with an invalid course name
        When I make a valid request by course name "<course>"
        Then I get back an error message "Field format invalid"

      Examples:
        | course |
        | 345678;  |
        | asd dsa  |

  @Sad @Status
  Scenario Outline: Querying a response with an invalid course name
    When I make a valid request by course name "<course>"
    Then I get back a <response> response code

    Examples:
      | course | response |
      | 345678;  | 400    |
      | asd dsa  | 400    |


