package docisnPOMClasses;


import docisnUtilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

import static docisnStepDefinationsClasses.Background.driver;


public class BookAppointment
{
    LoginPage loginPage;
    public BookAppointment(AndroidDriver driver)
    {
        //driver= Background.getDriver();Not needed.
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)),this);
        loginPage=new LoginPage(driver);
    }
    Logger logger= LogManager.getLogger(BookAppointment.class);
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Consultation\"]") private WebElement consultationOnDashboard;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"serchDoc_searchbar_id\"]") WebElement searchBarLookForADoctor;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"SearchSym_searchbar_id\"]") WebElement searchBarForNameSymptomsSpeciality;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Book Appointment\"]") private WebElement bookAppointmentButton;
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView//android.widget.TextView[@index='0']") private List<WebElement> listOfAvailableDates;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Morning\"]") private WebElement morningSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Afternoon\"]") private WebElement afternoonSection;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Evening\"]") private WebElement eveningSection;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,'tmng_btn_id')]") private List<WebElement> listOfAvailableSlots;


    public void verifyUserPresentOndashboard()
    {
        loginPage.verifyUserPresentOnDashboard();
    }
    public void clickOnConsultation()
    {
        Utility.explicitlyWait(consultationOnDashboard,driver,2);
        consultationOnDashboard.click();
        logger.info("Clicked on Consultation Button OnDashboard");
    }
    public void clickOnSearchToSearchDoctors1()
    {
        searchBarLookForADoctor.click();
        logger.info("Clicked on search bar present on Look for a doctor screen");
    }
    public void clickOnSearchBarForDrNameSpecialitySymptoms(String enterDrNameSpecialitySymptoms)
    {
        searchBarForNameSymptomsSpeciality.sendKeys(enterDrNameSpecialitySymptoms);
        logger.info("Search with "+enterDrNameSpecialitySymptoms);
        driver.findElement(By.xpath("//android.view.ViewGroup[contains(@content-desc,'"+enterDrNameSpecialitySymptoms+"')]")).click();
        logger.info("Clicked on "+enterDrNameSpecialitySymptoms);
    }

    public void clickOnBookAppointmetForDoctor()
    {
        Utility.explicitlyWait(bookAppointmentButton,driver,3);
        bookAppointmentButton.click();
        logger.info("Clicked on Book Appointment");
    }
    public void selectDateForBookAppointment(int enterDate)
    {
        //Utility.scrollDownCustom(driver,0.8,0.3);
        for(WebElement date:listOfAvailableDates)
        {
            if(date.getText().contains(String.valueOf(enterDate)))
            {
                date.click();
                logger.info("Selected Date: "+enterDate);
                break;
            }
        }
    }
    public void selectTimeForBookAppointment(int enterTime)
    {
        morningSection.click();
        for(WebElement slot:listOfAvailableSlots)
        {
            if(slot.getText().contains(String.valueOf(enterTime)))
            {
                slot.click();
                logger.info("Selected Time slot is "+slot.getText());
                break;
            }
        }
        afternoonSection.click();
        for(WebElement slot:listOfAvailableSlots)
        {
            if(slot.getText().contains(String.valueOf(enterTime)))
            {
                slot.click();
                logger.info("Selected Time slot is "+slot.getText());
                break;
            }
        }
        eveningSection.click();
        for(WebElement slot:listOfAvailableSlots)
        {
            if(slot.getText().contains(String.valueOf(enterTime)))
            {
                slot.click();
                logger.info("Selected Time slot is "+slot.getText());
                break;
            }
        }
    }



}
