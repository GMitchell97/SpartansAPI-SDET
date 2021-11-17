@SmokeTests @WIP @FilterName
Feature:  Filter Spartan By Spartan Name

  @Happy @Status
  Scenario: Search request with a non-existing name
    When I make a valid request by a non-existing name
    Then I get back a 204 response code

  @Happy @Error
  Scenario: Search request with a non-existing name body checker
    When I make a valid request by a non-existing name
    Then I get back an error message "No records found"

  @Happy @Status
  Scenario: Search request with an empty name
    When I make valid request by an empty name
    Then I get back a 204 response code

  @Happy @Error
  Scenario: Search request with an empty name body checker
    When I make valid request by an empty name
    Then I get back an error message "No records found"

  @Happy @View
  Scenario: Search request with full name returns correct json
    When I make a valid request by full name "Luigi%20Vincenzo%20Puma"
    Then I get back a Json array of Spartans that contain the full name "Luigi Vincenzo Puma"

  @Sad @Error
  Scenario: Search request with full name un-capitalised returns correct json
    When I make a valid request by full name "luigi vincenzo puma"
    Then I get back an error message "No records found"

  @Sad @Error
  Scenario: Search request with full name capitalised returns correct json
    When I make a valid request by full name "LUIGI VINCENZO PUMA"
    Then I get back an error message "No records found"

  @Happy @View
  Scenario: Search request with first name returns correct json
    When I make a valid request by first name "Luigi"
    Then I get back a Json array of Spartans that contain the first name "Luigi"

  @Sad @Error
  Scenario: Search request with first name un-capitalised returns correct json
    When I make a valid request by first name "luigi"
    Then I get back an error message "No records found"

  @Sad @Error
  Scenario: Search request with first name capitalised returns correct json
    When I make a valid request by first name "LUIGI"
    Then I get back an error message "No records found"


  @Happy @View
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "Luigi%20Puma"
    Then I get back a Json array of Spartans that contain the first and last name "Luigi Puma"

  @Sad @Error
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "luigi puma"
    Then I get back an error message "No records found"

  @Sad @Error
  Scenario: Search request with first and last name un-capitalised returns correct json
    When I make a valid request by first and last name "LUIGI PUMA"
    Then I get back an error message "No records found"

  @FullName @Happy @Status
  Scenario Outline: Search request with full name capitalised returns correct status code
    When I make a valid request by full name "<Name>"
    Then I get back a <Response> response code
    Examples:
      | Name                | Response |
      | LUIGI VINCENZO PUMA | 204      |
      | luigi vincenzo puma | 204      |
      | Luigi Vincenzo Puma | 200      |
      | ui in um            | 200      |
      | zzzzzzzzz zz zz     | 204      |

  @FirstName @Happy @Status
  Scenario Outline: Search request with first name returns correct status code
    When I make a valid request by first name "<Name>"
    Then I get back a <Response> response code
    Examples:
      | Name      | Response |
      | LUIGI     | 204      |
      | luigi     | 204      |
      | Luigi     | 200      |
      | ui        | 200      |
      | zzzzzzzzz | 204      |

  @FirstAndLastName @Happy @Status
  Scenario Outline: Search request with first and last name returns correct status code
    When I make a valid request by first and last name "<Name>"
    Then I get back a <Response> response code
    Examples:
      | Name       | Response |
      | LUIGI PUMA | 204      |
      | luigi puma | 204      |
      | Luigi Puma | 200      |
      | ui am      | 200      |
      | zzzzz zzz  | 204      |


