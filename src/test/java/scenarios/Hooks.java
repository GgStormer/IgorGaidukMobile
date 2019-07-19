package scenarios;

import org.testng.annotations.*;
import setup.Driver;
import setup.PropertyFile;
import setup.TestProperties;

import java.io.IOException;

public class Hooks extends Driver {

    /**
     * Required variables will be initialized by inherited constructor
     *
     */

    Hooks() {
        super();
    }

    @BeforeGroups(groups = "native", description = "Prepare native driver to run test(s)")
    public void setUpNative() throws Exception {
        TestProperties.setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
        System.out.println("Native driver prepared");
    }

    @BeforeGroups(groups = "web", description = "Prepare web driver to run test(s)")
    public void setUpWeb() throws Exception {
        TestProperties.setPropertyFile(PropertyFile.WEB);
        prepareDriver();
        System.out.println("Web driver prepared");
    }

    @AfterSuite(groups = { "native", "web" }, description = "Close driverSingle on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }
}
