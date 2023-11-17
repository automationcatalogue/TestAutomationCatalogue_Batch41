package utilities;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    private static WebDriver driver;
    public static String failureReason;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
