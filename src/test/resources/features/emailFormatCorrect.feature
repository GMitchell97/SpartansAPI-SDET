Feature:
  Scenario: Querying the api will return a result with an email ending in @spartaglobal.com
    When I make a GET request to all
    Then The email should end with @spartaglobal.com