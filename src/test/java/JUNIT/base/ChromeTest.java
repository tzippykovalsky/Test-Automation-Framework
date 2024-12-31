package JUNIT.base;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import enums.LocatorType;
import pageObject.Login;

public class ChromeTest extends BaseTest {

    @Override
    void setBrowserName() {
        this.browserName = "chrome";
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement webElement = driver.findElement(LocatorType.className, "gLFyf");
        webElement.sendKeys("Selenium");
    }

    @Test
    public void test01_login() {
        Login login = new Login(driver.getWebDriver());
        driver.get("https://demoqa.com/login");
        login.loginAction("Chaim", "1236");

    }


}
