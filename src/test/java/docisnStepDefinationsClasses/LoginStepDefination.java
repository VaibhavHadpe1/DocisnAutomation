package docisnStepDefinationsClasses;

import docisnPOMClasses.LoginPage;
import docisnUtilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination {
    AndroidDriver driver;
    LoginPage loginPage;
    public LoginStepDefination()
    {
        Utility.setDriver();
        driver= Utility.getDriver();
        loginPage=new LoginPage(driver);
    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.openDocisnApp();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.enterMobileNumber();
        loginPage.enterPassword();
    }

    @When("clicks the Signin button")
    public void clicks_the_signin_button()
    {
        loginPage.clickOnSignIn();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        loginPage.verifyUserPresentOnDashboard();
    }

    @When("user click on Menu button user can see different features")
    public void userClickOnMenuButtonUserCanSeeDifferentFeatures()
    {
        loginPage.clickonMenuOnDashboard();
    }

    @Then("user click on logout and should logout successfully")
    public void userClickOnLogoutAndShouldLogoutSuccessfully()
    {
        loginPage.clickOnLogoutAndLogout();
    }
}
