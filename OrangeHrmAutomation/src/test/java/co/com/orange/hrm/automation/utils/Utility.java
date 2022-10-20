package co.com.orange.hrm.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static String getUrl() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/test/resources/config.properties"));
        return properties.getProperty("url");
    }

    public static int getStatus(String opt) {
        return opt == "Enable" ? 0 : 1;
    }


}
