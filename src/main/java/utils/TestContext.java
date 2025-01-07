package utils;

import org.openqa.selenium.WebDriver;

/**
 * TestContext or Store - A class for storing shared objects between tests and extensions.
 */
public class TestContext {
    private static WebDriver driverStore;

    // Setter for WebDriver
    public static void setDriver(WebDriver driver) {
        driverStore=driver;
    }

    // Getter for WebDriver
    public static WebDriver getDriver() {
        return driverStore;
    }

    // Clear the driver after each test to prevent memory leaks
    public static void clear() {
        driverStore=null;
    }
}
