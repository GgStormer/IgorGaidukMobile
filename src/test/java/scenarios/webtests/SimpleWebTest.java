package scenarios.webtests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.annotation.DependsOn;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class SimpleWebTest extends Driver {
    /**
     * Constructor initializes properties on driverSingle creation
     *
     * @throws IOException
     */
    protected SimpleWebTest() throws IOException {
    }

    @Test(description = "Open website")
    public void webTest() throws Exception{
        driver().get("https://iana.org");
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        System.out.println("Site opening done");

        String expectedTitle = "Internet Assigned Numbers Authority";
        String actualTitle = driver().getTitle();
        assertEquals(expectedTitle,actualTitle);
    }
}
