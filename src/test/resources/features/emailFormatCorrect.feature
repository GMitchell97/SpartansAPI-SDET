Feature:
  Scenario: Querying the api will return the correct email
    When I make a GET request to all
    Then The email should have the correct name end with @spartaglobal.com

