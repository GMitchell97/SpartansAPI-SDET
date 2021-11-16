Feature: Filter Spartan by stream name

  Scenario: Querying a Spartan with a valid stream name
    When I have made a valid request to valid Stream name
    Then I should get back a JSON response containing all Spartans with that String in their streamname

  Scenario: Querying a Spartan with a Capitalized stream name
    When I have made a request to a valid Stream with an existing capitalized streamname
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a Spartan with a non-Capitalized stream name
    When I have made a request to a valid Stream with an existing non-capitalized streamname
    Then I should get back a JSON response containing all Spartans with that name

    Scenario: Querying a Spartan with an invalid stream name
      When I have made invalid a request to Stream
      Then I should get back a JSON response return an 204 statuscode with and empty array