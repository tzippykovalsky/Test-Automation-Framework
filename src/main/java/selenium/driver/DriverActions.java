package selenium.driver;

import actions.ElementLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import enums.LocatorType;

import java.util.List;


/**
 * DriverManager is responsible for managing the WebDriver instance lifecycle.
 * It provides methods to initialize, quit and ensure proper shutdown of the WebDriver.
 */
public class DriverActions {

    private WebDriver driver;

    /**
     * Initializes the WebDriver using the provided WebDriverService.
     *
     * @param driverService the WebDriverService used to create the driver
     */
    public void initializeDriver(WebDriverService driverService, String browserName) {
        if (driverService instanceof LocalWebDriverService) {
            this.driver = driverService.createLocalDriver(browserName);
        } else if (driverService instanceof RemoteWebDriverService) {
            System.out.println("מימוש בהמשך");
        }
        this.driver.manage().window().maximize();
    }



    /**
     * Gets the current WebDriver instance.
     *
     * @return the current WebDriver instance
     */
    public WebDriver getWebDriver() {
        return driver;
    }


    /**
     * Navigate to a URL in the browser.
     * @param url the URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Switch to a specific window by title.
     * @param windowTitle the title of the window to switch to
     */
    public void switchToWindowByTitle(String windowTitle) {
        driver.getWindowHandles().stream()
                .filter(handle -> driver.switchTo().window(handle).getTitle().equals(windowTitle))
                .findFirst()
                .ifPresent(handle -> driver.switchTo().window(handle));
    }

    /**
     * Switch to an iframe using its name or ID.
     * @param iframeNameOrId the name or ID of the iframe
     */
    public void switchToIframe(String iframeNameOrId) {
        driver.switchTo().frame(iframeNameOrId);
    }

    /**
     * Close the current window or tab.
     */
    public void closeWindow() {
        driver.close();
    }

    /**
     * Quit the WebDriver and close all associated windows.
     */
    public void quitDriver() {
        driver.quit();
    }

    public WebElement findElement(LocatorType locatorType, String attributeValue) {
        return driver.findElement(ElementLocator.createLocator(locatorType, attributeValue));
    }
    public List<WebElement> findElements(LocatorType locatorType, String attributeValue) {
        return driver.findElements(ElementLocator.createLocator(locatorType, attributeValue));
    }
}
