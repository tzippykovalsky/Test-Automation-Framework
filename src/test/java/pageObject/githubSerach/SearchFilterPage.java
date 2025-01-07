package pageObject.githubSerach;

import enums.LocatorType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.WebBasePage;

public class SearchFilterPage extends WebBasePage {
    public SearchFilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "UnstyledTextInput__ToggledUnstyledTextInput-sc-14ypya-0")
    private WebElement searchFilterInput;

    public void sendTextToSearch(String filterText) {
       elementAction.typeText(searchFilterInput,filterText);
    }
    public void enterSearchKey(){
        elementAction.enter(searchFilterInput);
    }

    public void searchAction(String filterText){
        sendTextToSearch(filterText);
        enterSearchKey();
    }
}
