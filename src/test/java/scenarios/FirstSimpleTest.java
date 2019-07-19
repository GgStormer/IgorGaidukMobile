//package scenarios;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import setup.Driver;
//
//import java.io.IOException;
//
//import static org.testng.Assert.assertEquals;
//
//public class FirstSimpleTest extends Driver {
//
//    protected FirstSimpleTest() throws IOException {
//    }
//
//    @BeforeClass(description = "Prepare androidDriver to run test(s)")
//    /**
//     * Prepare appiumDriver to run test(s)
//     */
//    public void setUp() throws Exception {
//        prepareDriver();
//    }
//
//    /**
//     * This simple test just click on button 'Add contact'
//     */
////    @Test(description = "This simple test just click on button 'Add contact'")
//    public void SimplestTest() {
//        String app_package_name = "com.example.android.contactmanager:id/";
//        By add_btn = By.id(app_package_name + "addContactButton");
//        driverSingle.findElement(add_btn).click();
//        System.out.println("Simplest Appium test done");
//    }
//
//    @Test(description = "Open website")
//    public void webTest() throws InterruptedException {
//        driverSingle.get("https://iana.org");
//        waitSingle.until(ExpectedConditions.urlToBe(SUT + "/"));
//        System.out.println("Site opening done");
//
//        String expectedTitle = "Internet Assigned Numbers Authority";
//        String actualTitle = driverSingle.getTitle();
//        assertEquals(expectedTitle,actualTitle);
//    }
//
//    @AfterClass
//    /**
//     * Close androidDriver on all tests completion
//     */
//    public void tearDown() throws Exception {
//        driverSingle.quit();
//    }
//}
//
