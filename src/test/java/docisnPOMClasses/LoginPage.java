package docisnPOMClasses;

import docisnUtilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static docisnStepDefinationsClasses.DocisnBaseStep.driver;

public class LoginPage
{
    public LoginPage(AndroidDriver driver)
    {
        driver= Utility.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)),this);
    }
    public static Logger logger= LogManager.getLogger(LoginPage.class);
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Docisn']") private WebElement docisnApp;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='log_mob_id']")private WebElement mobileNumber;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='log_pass_id']")private WebElement password;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign In']")private WebElement signIn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='uF10B']")private WebElement mobileIcon;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"home_open_menu_id\"]") private WebElement menuButtonOnDashboard;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'menu_close,')]//android.widget.TextView") private List<WebElement> listOfFeatureInMenu;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGOUT']") private WebElement logoutButtonOnConfirmationPopup;

    public void openDocisnApp()
    {
        Utility.implicitlyWait(driver,5);
        docisnApp.click();
        logger.info("Clicked on Docisn App.");
    }

    public void enterMobileNumber()
    {
        Utility.explicitlyWait(mobileNumber,driver,2);
        mobileNumber.sendKeys("7972481656");
        logger.info("Entered mobile number.");
    }

    public void enterPassword()
    {
        Utility.explicitlyWait(password,driver,2);
        password.sendKeys("Vaibhav@1234");
        logger.info("Entered password.");
    }

    public void clickOnSignIn()
    {
        signIn.click();
        logger.info("Clicked on Sign In.");
    }

    public void verifyUserPresentOnDashboard()
    {
        Utility.explicitlyWait(menuButtonOnDashboard,driver,3);
        if(menuButtonOnDashboard.isDisplayed())
        {
            logger.info("User present on dashboard and can see menu button");
        }
    }

    public void clickonMenuOnDashboard()
    {
        Utility.explicitlyWait(menuButtonOnDashboard,driver,3);
        if(menuButtonOnDashboard.isDisplayed())
        {
            menuButtonOnDashboard.click();
            logger.info("Clicked on Menu Button");
        }
        else
        {
            logger.info("Dashboard not loading immidietly");
        }
    }
    public void clickOnFeatureInMenu(String enterFeatureName)
    {
        Utility.implicitlyWait(driver,2);
        for(WebElement feature:listOfFeatureInMenu)
        {
            if(feature.getText().contains(enterFeatureName))
            {
                feature.click();
                logger.info("Clicked on "+enterFeatureName);
                break;
            }
        }
    }

    public void clickOnLogoutAndLogout()
    {
      clickOnFeatureInMenu("Logout");
      Utility.explicitlyWait(logoutButtonOnConfirmationPopup,driver,2);
      logoutButtonOnConfirmationPopup.click();
      logger.info("Logout Successfully");
      Utility.clickOnHomeButton();
      logger.info("Clicked on Home Button");
    }
}
