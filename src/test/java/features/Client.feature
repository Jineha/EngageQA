Feature: ApplicationClient

  Scenario: verify that an agent can create a new client with valid dataset
    Given User login into the application
    And click on create new client button
    When User Enter client data and click create button
    Then New client should be created into the application
    And client should be display on the application dashboard
