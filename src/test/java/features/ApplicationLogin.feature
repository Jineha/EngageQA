Feature: ApplicationLogin

  Scenario: CTMPRO-179 Verify that the user with a valid username and password is able to login to the application.
    When User opens the application in a web browser
    Given User enters valid username and password
    When User click login button
    Then User should be redirect to the Application dashboard homepage
    And Logout From the Application

  Scenario Outline: CTMPRO-181 Verify that a user with unauthorized credentials is not able to access the application as an agent.
    When User opens the application in a web browser
    Given User enters a combination of a valid invalid agent "<username>" and "<password>"
    When User click login button
    Then User should have gotten a validation "<message>" and not been able to login.
    Examples:
      | username                 | password             | message                                                                          |
      | dGVzdEB0ZXN0LmNvbQ==     | VGVzdEAxMg==         | There are no accounts linked to this email.                                      |
      | aGlyZW5AbWFpbHNhYy5jb20= | VGVzdEAxMg==         | This password is invalid. Try again or reset your password using the link below. |
      | dGVzdEB0ZXN0LmNvbQ==     | UWF0ZXN0QDEyMzQ1Ng== | There are no accounts linked to this email.                                      |
