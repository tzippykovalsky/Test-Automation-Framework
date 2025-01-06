package actions;

import org.openqa.selenium.WebDriver;

/**
 * ConcreteElementActions is a concrete implementation of AbstractElementActions.
 * It provides a specific instantiation of element actions for WebDriver operations.
 */
public class ConcreteElementActions extends AbstractElementActions {

    /**
     * Initializes ConcreteElementActions with the provided WebDriver.
     *
     * @param driver The WebDriver instance used to perform actions on web elements.
     */
    public ConcreteElementActions(WebDriver driver) {
        super(driver);
    }
}
