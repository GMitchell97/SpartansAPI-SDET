Feature: Filter Spartan by course name


  Scenario: Querying a Spartan with a Capitalized course name
    When I make a valid request by course name "ENGINEERING"
    Then I get back a list of Spartans that contain the course name "ENGINEERING"

  Scenario: Querying a Response code with a Capitalized course name
    When I make a valid request by course name "ENGINEERING"
    Then I get back a 200 response code

  Scenario: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "engineering"
    Then I get back a list of Spartans that contain the course name "engineering"

  Scenario: Querying a Response code with a non-Capitalized course name
    When I make a valid request by course name "engineering"
    Then I get back a 200 response code

  Scenario: Querying a Spartan with a non-Capitalized course name
    When I make a valid request by course name "Engineering"
    Then I get back a list of Spartans that contain the course name "Engineering"

  Scenario: Querying a Response code with a non-Capitalized course name
    When I make a valid request by course name "Engineering"
    Then I get back a 200 response code

  Scenario: Querying a Spartan with an invalid course name
    When I make a valid request by course name "Maths"
    Then I get an empty list

    When I make a valid request by course name "Maths"
    Then I get back a 204 response code