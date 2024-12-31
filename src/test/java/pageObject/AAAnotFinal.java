package pageObject;

public class AAAnotFinal {
    package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.lang.reflect.Field;

    public abstract class BasePageObject {
        protected WebDriver driver;

        public BasePageObject(WebDriver driver) {
            this.driver = driver;
            // אתחול אוטומטי של כל אלמנטי ה-PageObject
            PageFactory.initElements(driver, this);
            initElementBases();
        }

        // פונקציה שתאתחל את כל ה-ElementBase של האלמנטים
        private void initElementBases() {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType().equals(WebElement.class)) {
                    try {
                        field.setAccessible(true);
                        WebElement webElement = (WebElement) field.get(this);
                        field.set(this, new ElementBase(webElement));  // אתחול אוטומטי של ElementBase
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }







    package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.pages.ElementBase;

    public class GoogelSearch extends BasePageObject {

        @FindBy(className = "gLFyf")
        private WebElement textField;

        @FindBy(className = "dddd")
        private WebElement textField2;

        private ElementBase textFieldElement;
        private ElementBase textField2Element;

        public GoogelSearch(WebDriver driver) {
            super(driver);  // אתחול כל האלמנטים
            // האלמנטים כבר מאותחלים באופן אוטומטי
        }

        public void searchForText(String text) {
            textFieldElement.sendText(text);
            textFieldElement.enter();
        }

        public void searchForText2(String text) {
            textField2Element.sendText(text);
            textField2Element.enter();
        }
    }
//עדיין מסובך ודורש הקצאת אובייקטים כפולים
    //לחשוב אולי יש DP שפותר את זה
}
