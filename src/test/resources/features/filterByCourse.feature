@SmokeTests @FilterCourse @WIP
Feature: Filter Spartan by course name

  @Happy
  Scenario: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "Engineering"
    Then I get back a list of Spartans that contain the course name "Engineering"

  @Happy @Status
  Scenario: Querying a Response code with a non-Capitalized course name
    When I make a valid request by course name "Engineering"
    Then I get back a 200 response code

  @Sad
  Scenario: Querying a Spartan with a Capitalized course name
    When I make a valid request by course name "ENGINEERING"
    Then I get back an error message

  @Happy @Status
  Scenario: Querying a Response code with a Capitalized course name
    When I make a valid request by course name "ENGINEERING"
    Then I get back a 204 response code

  @Happy
  Scenario: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "engineering"
    Then I get back an error message

  @Happy @Status
  Scenario: Querying a Response code with a non-Capitalized course name
    When I make a valid request by course name "engineering"
    Then I get back a 204 response code

  @Happy
  Scenario: Querying a Spartan with an invalid course name
    When I make a valid request by course name "Maths"
    Then I get back an error message

    When I make a valid request by course name "Maths"
    Then I get back a 204 response code