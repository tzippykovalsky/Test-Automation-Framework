package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.pages.ElementBase;

public class GoogelSearch extends BasePageObject{
    public GoogelSearch(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "gLFyf")
    private WebElement textField;

    public void searchForText(String text) {
        ElementBase element = new ElementBase(textField);
        element.sendText(text);
        element.enter();
    }
}
