package selenium.pages;

import org.openqa.selenium.*;
import java.util.List;

/**
 * ElementBase is a custom implementation of the WebElement interface.
 * It wraps a WebElement instance and provides extended functionalities.
 */
public class WebElementManager implements WebElement {

    private final WebElement webElement;

    public WebElementManager(WebElement webElement) {
        this.webElement = webElement;
    }

    // Core WebElement methods

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    // Extended functionality

    /**
     * Sends the Enter key to the element.
     */
    public void enter() {
        webElement.sendKeys(Keys.RETURN);
    }

    /**
     * Returns the wrapped WebElement.
     */
    public WebElement getWebElement() {
        return webElement;
    }

    // Default methods from WebElement (with UnsupportedOperationException for unimplemented ones)

    @Override
    public String getDomProperty(String name) {
        throw new UnsupportedOperationException("getDomProperty is not supported.");
    }

    @Override
    public String getDomAttribute(String name) {
        throw new UnsupportedOperationException("getDomAttribute is not supported.");
    }

    @Override
    public String getAriaRole() {
        throw new UnsupportedOperationException("getAriaRole is not supported.");
    }

    @Override
    public String getAccessibleName() {
        throw new UnsupportedOperationException("getAccessibleName is not supported.");
    }

    @Override
    public SearchContext getShadowRoot() {
        throw new UnsupportedOperationException("getShadowRoot is not supported.");
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
