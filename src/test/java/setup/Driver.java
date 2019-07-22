package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Initialize a driverSingle with test properties
 */
public class Driver extends TestProperties {
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;
    protected static String TIMEOUT;
    protected static String UDID;

    private AppiumDriver driverSingle;
    private WebDriverWait waitSingle;

    /**
     * Constructor initializes properties on driverSingle creation
     *
     * @throws IOException
     */
    protected void initializeConfig() throws IOException {
        AUT = getProperty("aut");
        String t_sut = getProperty("sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProperty("platform");
        DRIVER = getProperty("driver");
        DEVICE_NAME = getProperty("device_name");
        TIMEOUT = getProperty("timeout");
//        UDID = getProperty("udid");
    }

    /**
     * Initialize driverSingle with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        setCurrentProps(getPropertyFile());
        initializeConfig();
        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME); // default Android emulator
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
//        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        // Setup type of application: mobile, web (or hybrid)
        if (PropertyFile.NATIVE.equals(TestProperties.getPropertyFile())) {
            // Native
            capabilities.setCapability("appPackage", "com.example.android.contactmanager");
            capabilities.setCapability("appActivity", "ContactManager");
        } else if (PropertyFile.WEB.equals(TestProperties.getPropertyFile())) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driverSingle for local Appium server with capabilities have been set
        if (driverSingle == null) driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        if (waitSingle == null) waitSingle = new WebDriverWait(driver(), Long.valueOf(TIMEOUT));
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}
