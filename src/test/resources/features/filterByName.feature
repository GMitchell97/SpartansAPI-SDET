Feature:  Filter Spartan By Spartan Name

  Scenario: Search request with a non-existing name
    When I make a valid request by a non-existing name
    Then I get back a 204 response code

  Scenario: Search request with a non-existing name body checker
    When I make a valid request by a non-existing name
    Then I get an empty list

  Scenario: Search request with an empty name
    When I make valid request by an empty name
    Then I get back a 204 response code

  Scenario: Search request with an empty name body checker
    When I make valid request by an empty name
    Then I get an empty list

  Scenario: Search request with full name un-capitalised returns correct json
    When I make a valid request by full name "Daniel David White"
    Then I get back a Json array of Spartans that contain the full name "Daniel David White"

  Scenario: Search request with full name un-capitalised returns correct json
    When I make a valid request by full name "daniel david white"
    Then I get back a Json array of Spartans that contain the full name "daniel david white"

  Scenario: Search request with full name capitalised returns correct json
    When I make a valid request by full name "DANIEL DAVID WHITE"
    Then I get back a Json array of Spartans that contain the full name "DANIEL DAVID WHITE"

  Scenario: Search request with first name un-capitalised returns correct json
    When I make a valid request by first name "Daniel"
    Then I get back a Json array of Spartans that contain the first name "Daniel"

  Scenario: Search request with first name un-capitalised returns correct json
    When I make a valid request by first name "daniel"
    Then I get back a Json array of Spartans that contain the first name "daniel"

  Scenario: Search request with first name capitalised returns correct json
    When I make a valid request by first name "DANIEL"
    Then I get back a Json array of Spartans that contain the first name "DANIEL"

  Scenario: Search request with last name un-capitalised returns correct json
    When I make a valid request by last name "White"
    Then I get back a Json array of Spartans that contain the last name "White"

  Scenario: Search request with last name un-capitalised returns correct json
    When I make a valid request by last name "white"
    Then I get back a Json array of Spartans that contain the last name "white"

  Scenario: Search request with last name un-capitalised returns correct json
    When I make a valid request by last name "WHITE"
    Then I get back a Json array of Spartans that contain the last name "White"

  Scenario: Search request with full name un-capitalised returns correct status code
    When I make a valid request by full name "daniel david white"
    Then I get back a 200 response code

  Scenario: Search request with full name un-capitalised returns correct status code
    When I make a valid request by full name "Daniel David White"
    Then I get back a 200 response code

  Scenario: Search request with full name capitalised returns correct status code
    When I make a valid request by full name "DANIEL DAVID WHITE"
    Then I get back a 200 response code

  Scenario: Search request with first name un-capitalised returns correct status code
    When I make a valid request by first name "Daniel"
    Then I get back a 200 response code

  Scenario: Search request with first name un-capitalised returns correct status code
    When I make a valid request by first name "daniel"
    Then I get back a 200 response code

  Scenario: Search request with first name capitalised returns correct status code
    When I make a valid request by first name "DANIEL"
    Then I get back a 200 response code

  Scenario: Search request with last name un-capitalised returns correct status code
    When I make a valid request by last name "White"
    Then I get back a 200 response code

  Scenario: Search request with last name un-capitalised returns correct status code
    When I make a valid request by last name "white"
    Then I get back a 200 response code

  Scenario: Search request with last name un-capitalised returns correct status code
    When I make a valid request by last name "WHITE"
    Then I get back a 200 response code

