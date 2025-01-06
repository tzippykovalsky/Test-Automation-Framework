package JUNIT.base;

import enums.BrowserType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import enums.LocatorType;
import pageObject.GoogelSearch;
import pageObject.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChromeTest extends BaseTest {

    @Override
    void setBrowserName() {
        this.browserName = BrowserType.CHROME;
    }

    @Test
    public void testGoogleSearch() {
        driver.navigateTo("https://www.google.com");
        WebElement webElement = driver.findElement(LocatorType.className, "gLFyf");
        webElement.sendKeys("Selenium");
    }

    @Test
    public void googleSearchPageObject() {
        GoogelSearch googelSearch = new GoogelSearch(driver.getWebDriver());
        driver.navigateTo("https://www.google.com");
        googelSearch.searchForText("Selenium");
        assertTrue(driver.getWebDriver().getCurrentUrl().contains("https://www.google.com/search?q=Selenium"));
    }

    @Test
    public void test01_login() {
        Login login = new Login(driver.getWebDriver());
        driver.navigateTo("https://demoqa.com/login");
        login.loginAction("Chaim", "1236");

    }

    @Test
    public void failToCheckStarsInGithub() {
        driver.navigateTo("https://github.com/tzippykovalsky");
        WebElement element = driver.findElement(LocatorType.id, "768313732");
        elementAction.click(element);
        element = driver.findElement(LocatorType.sccSelector, "a:contains('stars') > span.text-bold.color-fg-default");
        assertEquals(3, element.getText());

    }

}
