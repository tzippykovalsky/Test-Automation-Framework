package JUNIT.base;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import enums.LocatorType;

public class FirefoxTest extends BaseTest  {
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
