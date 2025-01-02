package pageObject;

import actions.AbstractElementActions;
import actions.ElementActions;
import lombok.Delegate;
import org.openqa.selenium.WebDriver;


public abstract class WebBasePage extends BasePage {

    @Delegate
    private final ElementActions elementActions;

    public WebBasePage(WebDriver driver) {
        super(driver);
        this.elementActions = new AbstractElementActions(driver) {};
    }

}
