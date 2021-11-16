Feature: Filtering By Id
  @Happy
  Scenario: If there is an id in the system I want to be able to search by that ID
    When I make a valid request by id
    And that id is in the database
    Then i should get back a 200 response code and the Spartan with the correct id is returned

  @Sad
  Scenario: If there isnt an id in the system I want to be able to search by that ID
    When I make a valid request by id
    And that id isnt in the database
    Then I should get back a 204 response code and an empty json arry is returned