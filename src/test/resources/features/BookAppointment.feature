@run

Feature:Book appointement

  Background: Login to Docisn Application
  Given the user is on the login page1
    When the user enters valid credentials1
    And clicks the Signin button1
    Then the user should be redirected to the home page1

  Scenario: Book an appointment(Inclinic) with a doctor
    Given user present on dashboard
    When user click on consultation it will redirect to Look for a doctor screen
    Then user can search and select the doctor
    Then user proceed for book appointment and select date and time
    When user click on Book appointment
    Then user can see make payment window
    And user click on make payment and redirect to payment page
    Then user can pay and book appointment successfully
