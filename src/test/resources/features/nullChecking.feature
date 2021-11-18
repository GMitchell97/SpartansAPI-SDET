@SmokeTests @NullChecks @WIP
Feature: Checking SpartanDTO for null fields

  Background: I query the Spartan api and receive a response
    Given I make a GET request to get all spartans

    Scenario: Checking id is not null
      When I check a spartans id
      Then id is not null

    Scenario: Checking first name is not null
      When I check a spartans firstName
      Then firstName is not null

    Scenario: Checking last name is not null
      When I check a spartans lastName
      Then lastName is not null

    Scenario: Checking start date is not null
      When I check a spartans startDate
      Then startDate is not null

    Scenario: Checking course object is not null
      When I check a spartans course
      Then course is not null

    Scenario: Checking course id is not null
      When I check a spartans course id
      Then course id is not null

    Scenario: Checking course name is not null
      When I check a spartans course name
      Then course name is not null

    Scenario: Checking stream object is not null
      When I check a spartans stream
      Then stream is not null

    Scenario: Checking stream duration is not null
      When I check a spartans stream duration
      Then stream duration is not null

    Scenario: Checking stream name is not null
      When I check a spartans stream name
      Then stream name is not null

    Scenario: Checking email is not null
      When I check a spartans email
      Then email is not null
