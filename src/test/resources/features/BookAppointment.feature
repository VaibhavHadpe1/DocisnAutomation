@run

Feature:Book appointement

  Background: Login to Docisn Application
  Given the user is on the login page1
    When the user enters valid credentials1
    And clicks the Signin button1
    Then the user should be redirected to the home page1

  Scenario: Book an walkin appointment.
    Given user present on dashboard
    When user click on Book apppointment