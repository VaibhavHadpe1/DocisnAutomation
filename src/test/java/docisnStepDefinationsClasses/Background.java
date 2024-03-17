package docisnStepDefinationsClasses;

import docisnPOMClasses.LoginPage;
import docisnUtilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Background
{
    public static AndroidDriver driver;
    LoginPage loginPage;

    public Background()
    {
        Utility.setDriver();
        driver=Utility.getDriver();
        loginPage=new LoginPage(driver);
    }
    public static AndroidDriver getDriver()
    {
        return driver;
    }
    Logger logger= LogManager.getLogger(Background.class);
    @Given("the user is on the login page1")
    public void the_user_is_on_the_login_page1() {
        loginPage.openDocisnApp();
    }

    @When("the user enters valid credentials1")
    public void the_user_enters_valid_credentials1() {
        loginPage.enterMobileNumber();
        loginPage.enterPassword();
    }

    @When("clicks the Signin button1")
    public void clicks_the_signin_button1()
    {
        loginPage.clickOnSignIn();
    }

    @Then("the user should be redirected to the home page1")
    public void the_user_should_be_redirected_to_the_home_page1() {
        loginPage.verifyUserPresentOnDashboard();
    }

    @After
    public void Home()
    {
        if(driver==null)
        {
            logger.info("Driver is Null");
        }
        else
        {
            loginPage.clickonMenuOnDashboard();
            loginPage.clickOnLogoutAndLogout();
        }
    }

}
