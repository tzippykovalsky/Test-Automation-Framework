package selenium.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.enums.LocatorType;
import selenium.pages.ElementBase;

/**
 * DriverManager is responsible for managing the WebDriver instance lifecycle.
 * It provides methods to initialize, quit and ensure proper shutdown of the WebDriver.
 */
public class DriverManager{

    private WebDriver driver;

    /**
     * Initializes the WebDriver using the provided WebDriverService.
     * @param driverService the WebDriverService used to create the driver
     */
    public void initializeDriver(WebDriverService driverService,String browserName) {
        this.driver = driverService.createLocalDriver(browserName);
        this.driver.manage().window().maximize();
    }

    /**
     * Quits the WebDriver instance, closing the browser.
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Gets the current WebDriver instance.
     * @return the current WebDriver instance
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Navigates to the specified URL in the WebDriver.
     * @param url
     */
    public void get(String url) {
        driver.get(url);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public WebElement findElement(LocatorType locatorType, String attributeValue) {
        return driver.findElement(ElementBase.createLocator(locatorType, attributeValue));
    }
}
