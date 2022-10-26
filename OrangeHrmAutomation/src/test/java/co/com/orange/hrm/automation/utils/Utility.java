package co.com.orange.hrm.automation.utils;

public class Utility {

    public static String getUrl() {
        return System.getenv("url");
    }

    public static int getStatus(String opt) {
        return opt.equals("Enable") ? 0 : 1;
    }


}
