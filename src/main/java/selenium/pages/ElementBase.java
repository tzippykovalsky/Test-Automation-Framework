package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import enums.LocatorType;

/**
 * ElementBase is a base class for all elements in the application.
 * It provides common methods for interacting with web elements.
 * It includes methods for getting the element's text, checking its enabled status,
 * and checking its visibility.
 *
 */
public class ElementBase implements Element {
//לא בטוח בכלל שנכון לכתוב את זה
    private  WebElement webElement;
    private By by;

    public ElementBase(WebElement webElement) {
        this.webElement = webElement;
    }

    public ElementBase(WebElement webElement, By by) {
        this.webElement = webElement;
        this.by = by;
    }

    public By getBy() {
        return by;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public String getText() {
        return webElement.getText();
    }

    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public void sendText(String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click() {
        webElement.click();
    }

    /**
     * Get the locator for the web element
     * @param attributeName
     * @return
     */

    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }
    public static By createLocator(LocatorType locatorType, String attributeValue) {

        switch (locatorType) {
            case id:
                return By.id(attributeValue);
            case name:
                return By.name(attributeValue);
            case xpath:
                return By.xpath(attributeValue);
            case sccSelector:
                return By.cssSelector(attributeValue);
            case className:
                return By.className(attributeValue);
            case tagName:
                return By.tagName(attributeValue);
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }
    public void enter(){
        webElement.sendKeys(Keys.RETURN);
    }

}