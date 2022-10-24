package co.com.orange.hrm.automation.utils;

import java.io.IOException;

public class Utility {


    public static String getUrl() {
        return System.getenv("url");
    }

    public static int getStatus(String opt) {
        return opt == "Enable" ? 0 : 1;
    }


}
