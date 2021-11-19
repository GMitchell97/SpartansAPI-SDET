@SmokeTests @Add @WIP
Feature: Add a course to the database

  @Happy @Status
  Scenario: Add a new entry in course collection with all valid fields, status code 200 received
    When I make a request to add a course with correct fields
    Then I get back a 201 response code

  @Happy @Confirm
  Scenario: Add a new entry in course collection with all valid fields
    When I make a request to add a course with correct fields
    Then I get back the new course

  @Sad @Status
  Scenario: Trying to add a course with an invalid field values, status code 400 received
    When I make a request to add a course with incorrect fields
    Then I get back a 400 response code


  @Sad @Error
  Scenario: Trying to add a course with an invalid field values, error message received
    When I make a request to add a course with incorrect fields
    Then I get back an error message "Field format invalid"