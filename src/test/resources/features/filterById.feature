@FilterId @WIP
Feature: Filtering By Id
  @Happy @Status
  Scenario: If there is an id in the system I want to get back a 200 reponse code
    When I make a valid request by id "validid"
    And That id is in the database
    Then I get back a 200 response code

  @Happy
    Scenario: If there is an id in the system I want to get back the Spartan with the correct ID
    When I make a valid request by id "validid"
    And That id is in the database
    Then I get back a  Spartan that contain the id "validid"


  @Sad @Status
  Scenario: If there isnt an id in the system I want to get back a 204 response code
    When I make a valid request by id "validid"
    And that id isnt in the database
    Then I get back a 204 response code

  @Sad
  Scenario: If there isnt an id in the system I want to get back an empty json array
  When I make a valid request by id "validid"
  And that id isnt in the database
  Then I Should get back an empty json array