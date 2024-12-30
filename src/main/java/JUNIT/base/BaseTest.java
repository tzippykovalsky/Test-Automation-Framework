package JUNIT.base;

import org.junit.jupiter.api.BeforeAll;
import store.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import selenium.driver.DriverManager;
import selenium.driver.WebDriverFactory;

public abstract class BaseTest {
    protected DriverManager driver;
    protected String browserName;

    abstract void setBrowserName();

    //TODO:ליצור פונקציה שמפעילה את כל המטודות האבסטרקיות כמו גירסה שם וכו ואותה להפעיל בביפוראיץ
    @BeforeEach
    public void setupTest() {
        setBrowserName();
        driver = new DriverManager();
        driver.initializeDriver(WebDriverFactory.createLocalDriver(),browserName);
    }

    @AfterEach
    public void cleanUpTest() {
        if (driver != null) {
            driver.quitDriver();
        }
    }
}
