@FilterId @WIP
Feature: Filtering By Id
  @Happy @Status
  Scenario: If there is an id in the system I want to get back a 200 reponse code
    When I make a valid request by id "61928452b0574f2e5c41422e"
    Then I get back a 200 response code

  @Happy @View
    Scenario: If there is an id in the system I want to get back the Spartan with the correct ID
    When I make a valid request by id "61928452b0574f2e5c41422e"
    Then I get back a Spartan that contain the id "61928452b0574f2e5c41422e"


  @Sad @Status
  Scenario: If there isnt an id in the system I want to get back a 204 response code
    When I make a valid request by id "61950614617e722ae9bfb034"
    Then I get back a 200 response code

  @Sad @Error
  Scenario: If there isnt an id I get back an appropriate message
  When I make a valid request by id "61950614617e722ae9bfb034"
  Then I get back an error message "No records found"