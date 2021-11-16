Feature: Filter Spartan by stream name

  Scenario: Querying a Spartan with a non-Capitalised stream name
    When I make a valid request by stream name "java"
    Then I should get back a JSON response containing all Spartans with that String in their streamname

  Scenario: Querying a Spartan with a capitalised stream name
    When I make a valid request by stream name "JAVA"
    Then I should get back a JSON response containing all Spartans with that name

  Scenario: Querying a response code with a non-Capitalised stream name
    When I make a valid request by stream name "java"
    Then I get back a 200 response code

  Scenario: Querying a response code with a capitalised stream name
    When I make a valid request by stream name "JAVA"
    Then I get back a 200 response code

  Scenario: Querying a Response code with an invalid stream name
    When I make a valid request by stream name "Ruby"
    Then I get back a 204 response code

  Scenario: Querying a Spartan with an invalid stream name
    When I make a valid request by stream name "Ruby"
    Then I get an empty list