package docisnStepDefinationsClasses;

import docisnPOMClasses.BookAppointment;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookAppointmentStepDefination
{
    AndroidDriver driver;
    BookAppointment bookAppointment;
    public BookAppointmentStepDefination()
    {
        driver=Background.getDriver();
        bookAppointment=new BookAppointment(driver);
    }
    @Given("user present on dashboard")
    public void userPresentOnDashboard()
    {
        bookAppointment.verifyUserPresentOndashboard();
    }

    @When("user click on consultation it will redirect to Look for a doctor screen")
    public void userClickOnConsultationItWillRedirectToLookForADoctorScreen()
    {
        bookAppointment.clickOnConsultation();
    }

    @Then("user can search and select the doctor")
    public void userCanSearchAndSelectTheDoctor()
    {
        bookAppointment.clickOnSearchToSearchDoctors1();
        bookAppointment.clickOnSearchBarForDrNameSpecialitySymptoms("Jyothi Agarawal");
    }
    @Then("user proceed for book appointment and select date and time")
    public void userProceedForBookAppointmentAndSelectDateAndTime()
    {
        bookAppointment.clickOnBookAppointmetForDoctor();
        bookAppointment.selectDateForBookAppointment(18);
        bookAppointment.selectTimeForBookAppointment(10);
    }
    @When("user click on Book appointment")
    public void userClickOnBookAppointment()
    {
        bookAppointment.clickOnConsultation();
    }

    @Then("user can see make payment window")
    public void userCanSeeMakePaymentWindow() {
    }

    @And("user click on make payment and redirect to payment page")
    public void userClickOnMakePaymentAndRedirectToPaymentPage() {
    }

    @Then("user can pay and book appointment successfully")
    public void userCanPayAndBookAppointmentSuccessfully() {
    }

}
