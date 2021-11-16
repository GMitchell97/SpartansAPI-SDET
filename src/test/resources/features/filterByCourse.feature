Feature: Filter Spartan by course name

  Scenario: Querying a Spartan with a Capitalized course name
    Given I have made a request to /spartan?coursename={coursename} with an existing capitalized course name
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a Spartan with a non-Capitalized course name
    Given I have made a request to /spartan?coursename={coursename} with an existing non-capitalized course name
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a Spartan with an invalid course name
    When I have made a request to /spartan?coursename={coursename} with an invalid course name
    Then I should receive an empty array

    When I have made a request to /spartan?coursename={coursename} with an invalid course name
    Then I should receive the status code 204