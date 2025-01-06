package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * An abstract base class for all page objects.
 * This class initializes web elements using Selenium's {@link PageFactory} and provides a common WebDriver instance.
 */
public abstract class BasePage {

    /**
     * The WebDriver instance used for interacting with web elements.
     */
    protected WebDriver driver;

    /**
     * Constructor for initializing the page object.
     * It uses {@link PageFactory-initElements(WebDriver, Object)} to initialize the web elements declared in the subclass.
     *
     * @param driver the WebDriver instance to be used by the page object
     */
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
