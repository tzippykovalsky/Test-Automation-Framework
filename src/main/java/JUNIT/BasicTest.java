package JUNIT;

import JUNIT.Extensions.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import selenium.driver.DriverManager;
import selenium.driver.WebDriverFactory;

abstract class BaseTest {
    protected DriverManager driverManager;

    @BeforeEach
    public void setup() {
        TestContext.getInstance().set("browser", System.getProperty("browser", "chrome"));

        String browser = TestContext.getInstance().getString("browser");

        driverManager = new DriverManager();
        driverManager.initializeDriver(WebDriverFactory.createLocalDriver(),browser);
    }

    @AfterEach
    public void tearDown() {
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
}
