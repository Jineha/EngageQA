Feature: ApplicationLogin

  Scenario: Engage-01 Verify that the user with a valid username and password is able to login to the application.
    When User opens the application in a web browser
    Given User enters valid username and password
    When User click login button
    Then User should be redirect to the Application dashboard homepage

  Scenario: Engage-02 validate cookie alert on the application landing page
    Given User logged into the application
    When user click on the accept cookies button
    Then The cookies footer should be disappear
