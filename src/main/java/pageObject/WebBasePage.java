package pageObject;

import actions.AbstractElementActions;
import actions.ElementActions;
import lombok.Delegate;
import org.openqa.selenium.WebDriver;

/**
 * An abstract base class for web-specific page objects.
 * This class extends {@link BasePage} and provides additional element action utilities for interacting with web elements.
 */
public abstract class WebBasePage extends BasePage {

    /**
     * Delegates method calls for element actions to an instance of {@link ElementActions}.
     * This allows subclasses to directly use element action methods without explicitly referencing the {@link ElementActions} instance.
     */
    @Delegate
    private final ElementActions elementActions;

    /**
     * Constructor for initializing the web page object.
     * It initializes the {@link ElementActions} instance using {@link AbstractElementActions}.
     *
     * @param driver the WebDriver instance used for interacting with web elements
     */
    public WebBasePage(WebDriver driver) {
        super(driver);
        this.elementActions = new AbstractElementActions(driver) {};
    }
}
