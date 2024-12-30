import JUNIT.Extensions.LogExtension;
import JUNIT.Extensions.WatcherExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import selenium.driver.DriverManager;
import selenium.driver.WebDriverFactory;
import selenium.enums.LocatorType;
import selenium.pages.ElementBase;

@ExtendWith({WatcherExtension.class, LogExtension.class})
public class TestExample {
    @Test
    public void test01() {//דרך אנוטציות להעביר שמות דפדפנים וכו
        DriverManager driver = new DriverManager();

        driver.initializeDriver(WebDriverFactory.createLocalDriver(), "edge");

        driver.get("https://www.google.com");
        WebElement webElement = driver.findElement(LocatorType.className, "gLFyf");
        webElement.sendKeys("Selenium");

        driver.quitDriver();
        //TODO לקשר בין webElement ל elementBase;
        //האם לשמור כל אלמנט במחלקה או שזה מיותר?

    }

}
