package docisnStepDefinationsClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DocisnBaseStep
{
    public static AndroidDriver driver;
    public static AppiumDriverLocalService appiumServer;
    public static AppiumServiceBuilder appiumServiceBuilder;

    public DocisnBaseStep()
    {
       setDriver();
    }
    public static DesiredCapabilities getDesiredCapabilities()
    {
        DesiredCapabilities capability = new DesiredCapabilities();
        //capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_33");
        //capability.setCapability(MobileCapabilityType.UDID, "emulator-5554");

        capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_6_API_34");//Pixel_6_API_34//Manogna's M33//realme Pad X
        capability.setCapability(MobileCapabilityType.BROWSER_NAME, "dialer");
        capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capability.setCapability("skipUnlock", "true");
        capability.setCapability("app-package", "com.aciana.docisn");
        capability.setCapability("app-activity", "com.aciana.docisn.MainActivity");
        capability.setCapability("noReset", "false");
        capability.setCapability("newCommandTimeout", 25000);
        return capability;
    }
    public static void setDriver() {
        DesiredCapabilities capability = getDesiredCapabilities ( );

        appiumServiceBuilder = new AppiumServiceBuilder();
        appiumServiceBuilder.withAppiumJS(new File("/Users/vaibhavrajendrahadpe/usr/local/lib/node_modules/npm/node_modules/qrcode-terminal/lib/main.js"))
                .usingDriverExecutable(new File("/Users/vaibhavrajendrahadpe/usr/local/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withIPAddress("127.0.0.1")
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        appiumServer = AppiumDriverLocalService.buildService(appiumServiceBuilder);
        appiumServer.start();
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public static AndroidDriver getDriver() {
        return driver;
    }
}
