Feature: Filter Spartan by course name

  Scenario: Querying a Spartan with a Capitalized course name
    Given I have made a request to /spartan?coursename={coursename} with an existing capitalized coursename
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a Spartan with a non-Capitalized course name
    Given I have made a request to /spartan?coursename={coursename} with an existing non-capitalized coursename
    Then I should get back a JSON response containing all Spartans with that name