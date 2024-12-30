package JUNIT.base;

import JUNIT.Extensions.LogExtension;
import JUNIT.Extensions.WatcherExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import store.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import selenium.driver.DriverManager;
import selenium.driver.WebDriverFactory;

@ExtendWith({WatcherExtension.class, LogExtension.class})
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
