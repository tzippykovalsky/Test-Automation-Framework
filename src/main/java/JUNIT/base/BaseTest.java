package JUNIT.base;

import JUNIT.Extensions.LogExtension;
import JUNIT.Extensions.RetryExtension;
import JUNIT.Extensions.ScreenshotExtension;
import JUNIT.Extensions.WatcherExtension;
import actions.ConcreteElementActions;
import enums.BrowserType;
import org.junit.jupiter.api.extension.ExtendWith;
import selenium.driver.DriverActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import selenium.driver.WebDriverFactory;
import selenium.utils.TestContext;

/**
 * BaseTest is an abstract class providing the common setup and cleanup logic for all test classes.
 * It initializes the WebDriver and associated actions before each test and ensures cleanup after the test.
 * The class uses JUnit 5 extensions for logging, screenshots, and failure watching.
 */
//, LogExtension.class לא נותן למה?????
@ExtendWith({WatcherExtension.class,LogExtension.class, ScreenshotExtension.class, RetryExtension.class})
public abstract class BaseTest {

    /**
     * Instance of DriverActions to manage WebDriver operations.
     */
    protected DriverActions driver;

    /**
     * Browser name used to initialize the WebDriver. Default is "chrome".
     */
    protected BrowserType browserName = BrowserType.CHROME;

    /**
     * Instance of ConcreteElementActions for performing various actions on web elements.
     */
    public ConcreteElementActions elementAction;

    /**
     * Abstract method to set the browser name before initializing the WebDriver.
     * This method should be implemented by derived test classes.
     */
    abstract void setBrowserName();

    /**
     * Initializes the WebDriver, actions, and context before each test.
     * This method is annotated with @BeforeEach to ensure it runs before every test case.
     */
    @BeforeEach
    public void setupTest() {
        setBrowserName();
        driver = new DriverActions();
        driver.initializeDriver(WebDriverFactory.createLocalDriver(), browserName);
        elementAction = new ConcreteElementActions(driver.getWebDriver());
        TestContext.setDriver(driver.getWebDriver());
    }

    /**
     * Cleans up the WebDriver and context after each test.
     * This method is annotated with @AfterEach to ensure it runs after every test case.
     * It quits the WebDriver if it is not null and clears the TestContext to prevent memory leaks.
     */
    @AfterEach
    public void cleanUpTest() {
        if (driver != null) {
            driver.quitDriver();
        }
        TestContext.clear();
    }
}
