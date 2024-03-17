@run
Feature: User Login

  Scenario: User successfully logs in
    Given the user is on the login page
    When the user enters valid credentials
    And clicks the Signin button
    Then the user should be redirected to the home page
    When user click on Menu button user can see different features
    Then user click on logout and should logout successfully