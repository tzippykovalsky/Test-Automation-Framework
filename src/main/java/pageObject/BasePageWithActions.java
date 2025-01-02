package pageObject;

import actions.AbstractElementActions;
import actions.ElementActions;
import lombok.Delegate;
import org.openqa.selenium.WebDriver;


public abstract class BasePageWithActions extends BasePage {

    @Delegate
    private final ElementActions elementActions;

    public BasePageWithActions(WebDriver driver) {
        super(driver);
        this.elementActions = new AbstractElementActions(driver) {};
    }

}
