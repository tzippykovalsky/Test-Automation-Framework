package selenium.driver;

import actions.ElementLocator;
import enums.BrowserType;
import org.openqa.selenium.*;
import enums.LocatorType;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * DriverActions is responsible for managing the WebDriver instance lifecycle.
 * It provides various methods for interacting with the browser, such as navigation,
 * handling alerts, working with cookies, and managing windows and iframes.
 */
public class DriverActions {

    private WebDriver driver;

    /**
     * Initializes the WebDriver using the provided WebDriverService.
     *
     * @param driverService the WebDriverService used to create the driver
     * @param browserName   the browser name to initialize the driver with
     */
    public void initializeDriver(WebDriverService driverService, BrowserType browserName) {
        if (driverService instanceof LocalWebDriverService) {
            this.driver = driverService.createLocalDriver(browserName);
        } else if (driverService instanceof RemoteWebDriverService) {
            System.out.println("Remote WebDriver implementation to be added later");
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
     *
     * @param url the URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Switch to a specific window by its title.
     *
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
     *
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

    /**
     * Find an element on the page using the provided locator type and value.
     *
     * @param locatorType   the type of locator (id, name, xpath, etc.)
     * @param attributeValue the value of the locator (e.g., id, name, etc.)
     * @return the WebElement found
     */
    public WebElement findElement(LocatorType locatorType, String attributeValue) {
        return driver.findElement(ElementLocator.createLocator(locatorType, attributeValue));
    }

    /**
     * Find multiple elements on the page using the provided locator type and value.
     *
     * @param locatorType   the type of locator (id, name, xpath, etc.)
     * @param attributeValue the value of the locator (e.g., id, name, etc.)
     * @return a list of WebElements found
     */
    public List<WebElement> findElements(LocatorType locatorType, String attributeValue) {
        return driver.findElements(ElementLocator.createLocator(locatorType, attributeValue));
    }

    /**
     * Accept an alert in the browser.
     */
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /**
     * Dismiss an alert in the browser.
     */
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Get the text from an alert in the browser.
     *
     * @return the text of the alert
     */
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /**
     * Send text to an alert in the browser (e.g., for prompt alerts).
     *
     * @param text the text to send to the alert
     */
    public void sendKeysToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    /**
     * Refresh the current page in the browser.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Switch to a window by its window handle.
     *
     * @param windowHandle the handle of the window to switch to
     */
    public void switchToWindowByHandle(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    /**
     * Switch to an iframe by its ID.
     *
     * @param iframeId the ID of the iframe to switch to
     */
    public void switchToIframeById(String iframeId) {
        driver.switchTo().frame(iframeId);
    }

    /**
     * Navigate back to the previous page in the browser.
     */
    public void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Navigate forward to the next page in the browser.
     */
    public void navigateForward() {
        driver.navigate().forward();
    }

    /**
     * Add a cookie to the browser.
     *
     * @param cookie the cookie to add
     */
    public void addCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    /**
     * Get a cookie by its name.
     *
     * @param name the name of the cookie
     * @return the cookie found
     */
    public Cookie getCookieNamed(String name) {
        return driver.manage().getCookieNamed(name);
    }

    /**
     * Delete a cookie by its name.
     *
     * @param name the name of the cookie
     */
    public void deleteCookieNamed(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    /**
     * Delete all cookies in the browser.
     */
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    /**
     * Maximize the browser window.
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * Minimize the browser window.
     */
    public void minimizeWindow() {
        driver.manage().window().setSize(new Dimension(0, 0));
    }

    /**
     * Resize the browser window to the specified dimensions.
     *
     * @param width  the new width of the window
     * @param height the new height of the window
     */
    public void resizeWindow(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    /**
     * Get the current browser window's size.
     *
     * @return the size of the current window
     */
    public Dimension getWindowSize() {
        return driver.manage().window().getSize();
    }

    /**
     * Get the current browser window's position.
     *
     * @return the position of the current window
     */
    public Point getWindowPosition() {
        return driver.manage().window().getPosition();
    }

 /*   *//**
     * Take a screenshot of the current browser window.
     *
     * @param filePath the path to save the screenshot
     *//*
    public void takeScreenshot(String filePath) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);
        file.renameTo(destFile);
    }*/

    /**
     * Get the browser's current window title.
     *
     * @return the title of the current window
     */
    public String getWindowTitle() {
        return driver.getTitle();
    }
}
