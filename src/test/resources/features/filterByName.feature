Feature:  Filter Spartan By Spartan Name

Scenario: Querying a Spartan with a name
  Given I have made a request to /spartan?name={name} with an existing full name
  Then I should get back a JSON response containing all Spartans with that nam