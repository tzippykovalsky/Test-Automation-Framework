package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends WebBasePage {
    //להוסיף url?
    public GoogleSearch(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "gLFyf")
    private WebElement textField;

    public void searchForText(String text) {
        elementAction.typeText(textField, text);
        elementAction.click(textField);

    }

}
