package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogelSearch extends BasePageWithActions {
    //להוסיף url?
    public GoogelSearch(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "gLFyf")
    private WebElement textField;

    public void searchForText(String text) {
        typeText(textField, text);
        enter(textField);
    }

}
