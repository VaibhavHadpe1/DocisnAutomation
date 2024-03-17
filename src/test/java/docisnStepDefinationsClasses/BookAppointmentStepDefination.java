package docisnStepDefinationsClasses;

import docisnPOMClasses.BookAppointment;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
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

    @When("user click on Book apppointment")
    public void userClickOnBookApppointment()
    {
        bookAppointment.clickOnConsultation();
    }
}
