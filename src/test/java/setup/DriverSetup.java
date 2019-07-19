//package setup;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class DriverSetup {
//    protected AndroidDriver androidDriver;
//
//    protected void prepareNative() throws MalformedURLException { // exception required by java.net.URL
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        //mandatory capabilities
//        capabilities.setCapability("deviceName", "894ec4aa");
//        capabilities.setCapability("platformName", "Android");
//
//        // path to app
//        // Copy the application (.apk), which will become AUT, to the specified location,
//        // e.g. "resources" folder of the project
//        File appDir = new File("C:\\Users\\Igor_Gaiduk\\IdeaProjects\\MyFirstTrainingAppiumTest\\src\\main\\resources");
//        File app = new File(appDir, "ContactManager.apk");
//
//        //other caps
//        capabilities.setCapability("app", app.getAbsolutePath());
//
//        // Init androidDriver for local Appium server with capabilities have been set
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//    /**
//     * Set of capabilities to test Android web app
//     *
//     * @throws MalformedURLException
//     */
//    protected void prepareAndroidWeb() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        //mandatory Android capabilities
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "894ec4aa");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//
//        // specific web capabilities
////        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//
//        // Init androidDriver for local Appium server with capabilities have been set
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    }
//
//}
//
