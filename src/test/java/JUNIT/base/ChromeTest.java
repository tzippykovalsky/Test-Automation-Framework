package JUNIT.base;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import selenium.enums.LocatorType;

public class ChromeTest extends BaseTest {

    @Override
    void setBrowserName() {
        this.browserName = "firefox";
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement webElement = driver.findElement(LocatorType.className, "gLFyf");
        webElement.sendKeys("Selenium");
    }


}
