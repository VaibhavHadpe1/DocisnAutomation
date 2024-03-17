package docisnPOMClasses;

import docisnStepDefinationsClasses.Background;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class BookAppointment
{
    public BookAppointment(AndroidDriver driver)
    {
        //driver= Background.getDriver();Not needed.
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)),this);
    }
    Logger logger= LogManager.getLogger(BookAppointment.class);

    public void verifyUserPresentOndashboard()
    {
        logger.info("User present on dashboard");
    }

    public void clickOnConsultation()
    {
        logger.info("User clicked on consultation dummy");
    }
}
