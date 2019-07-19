package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    static Properties currentProps = new Properties();

    private static PropertyFile propertyFile = null;

    static Properties getCurrentProps() throws IOException {
        return currentProps;
    }

    public static void setCurrentProps(PropertyFile prop) throws IOException {
        FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\" + prop);
        currentProps.load(in);
        in.close();
    }

    protected static String getProperty(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) currentProps = getCurrentProps();
        // "default" form used to handle the absence of parameter
        return currentProps.getProperty(propKey, null);
    }

    public static PropertyFile getPropertyFile() {
        return propertyFile;
    }

    public static void setPropertyFile(PropertyFile propertyFile) {
        TestProperties.propertyFile = propertyFile;
    }
}
