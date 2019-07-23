package scenarios.nativetests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTest extends Driver {

    /**
     * Constructor initializes properties on driverSingle creation
     *
     * @throws IOException
     */
    protected SimpleNativeTest() throws IOException {
    }

    @Test(description = "Just click on button 'Add contact'")
    public void nativeTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }
}
