@SmokeTests @WIP @FilterName
Feature:  Filter Spartan By Spartan Name

  @Happy @Status
  Scenario: Search request with a non-existing name
    When I make a valid request by a non-existing name
    Then I get back a 204 response code

  @Happy @Error
  Scenario: Search request with a non-existing name body checker
    When I make a valid request by a non-existing name
    Then I get back an error message

  @Happy @Status
  Scenario: Search request with an empty name
    When I make valid request by an empty name
    Then I get back a 204 response code

  @Happy @Error
  Scenario: Search request with an empty name body checker
    When I make valid request by an empty name
    Then I get back an error message

  @Happy @View
  Scenario: Search request with full name un-capitalised returns correct json
    When I make a valid request by full name "Daniel David White"
    Then I get back a Json array of Spartans that contain the full name "Daniel David White"

  @Sad @Error
  Scenario: Search request with full name un-capitalised returns correct json
    When I make a valid request by full name "daniel david white"
    Then I get back an error message

  @Sad @Error
  Scenario: Search request with full name capitalised returns correct json
    When I make a valid request by full name "DANIEL DAVID WHITE"
    Then I get back an error message

  @Happy @View
  Scenario: Search request with first name un-capitalised returns correct json
    When I make a valid request by first name "Daniel"
    Then I get back a Json array of Spartans that contain the first name "Daniel"

  @Sad @Error
  Scenario: Search request with first name un-capitalised returns correct json
    When I make a valid request by first name "daniel"
    Then I get back an error message

  @Sad @Error
  Scenario: Search request with first name capitalised returns correct json
    When I make a valid request by first name "DANIEL"
    Then I get back an error message

  @Happy @View
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "Daniel White"
    Then I get back a Json array of Spartans that contain the first and last name "Daniel White"

  @Sad @Error
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "daniel white"
    Then I get back an error message

  @Sad @Error
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "DANIEL WHITE"
    Then I get back an error message


  @FullName @Happy @Status
  Scenario Outline: Search request with full name capitalised returns correct status code
    When I make a valid request by full name "<Name>"
    Then I get back a <Response> response code
    Examples:
      | Name              |  Response  |
      | DANIEL DAVID WHITE|   204 |
      | daniel david white|   204 |
      | Daniel David White|   200 |
      | an av it          |   200 |
      | zzzzzzzzz zz zz |   204 |

  @FirstName @Happy @Status
  Scenario Outline: Search request with first name returns correct status code
    When I make a valid request by first name "<Name>"
    Then I get back a <Response> response code
    Examples:
    | Name    |  Response  |
    |DANIEL   |   204      |
    |daniel   |   204      |
    |Daniel   |   200      |
    |an       |   200      |
    |zzzzzzzzz|   204      |

  @FirstAndLastName @Happy @Status
  Scenario Outline: Search request with first and last name returns correct status code
    When I make a valid request by first and last name "<Name>"
    Then I get back a <Response> response code
    Examples:
      | Name    |  Response  |
      |DANIEL WHITE  |   204      |
      |daniel white  |   204      |
      |Daniel White  |   200      |
      |an it         |   200      |
      |zzzzz zzz     |   204      |


