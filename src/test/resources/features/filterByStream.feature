Feature: Filter Spartan by stream name

  Scenario: Querying a Spartan with a Capitalized stream name
    Given I have made a request to /spartan?streamname={streamname} with an existing capitalized streamname
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a Spartan with a non-Capitalized stream name
    Given I have made a request to /spartan?streamname={streamname} with an existing non-capitalized streamname
    Then I should get back a JSON response containing all Spartans with that name