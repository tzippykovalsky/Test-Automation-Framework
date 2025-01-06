package JUNIT.base;

import enums.BrowserType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import enums.LocatorType;

public class FirefoxTest extends BaseTest  {
    @Override
    void setBrowserName() {
        this.browserName = BrowserType.FIREFOX;
    }
    @Test
    public void testGoogleSearch() {
        driver.navigateTo("https://www.google.com");
        WebElement webElement = driver.findElement(LocatorType.className, "gLFyf");
        webElement.sendKeys("Selenium");
    }
}
