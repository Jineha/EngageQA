Feature: NewsEngage

  Scenario: Engage-03 Verify that the user can navigate to news tab >> electric car tab
    When User successfully logged into the browser
    Given Once the cookies accepted
    When User click on particular news tab
    Then User should be redirect to news tab successfully