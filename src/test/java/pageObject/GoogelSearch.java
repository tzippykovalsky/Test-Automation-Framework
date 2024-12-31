package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.pages.ElementBase;
import selenium.pages.WebElementManager;

public class GoogelSearch extends BasePageObject{
    public GoogelSearch(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "gLFyf")
    private WebElement textField;

//    public void searchForText(String text) {
//        textField.sendKeys(text);
//        textField.enter();
//    }
    //צריך לקשר בינו  WebElementManager ולבין WebElement
}
