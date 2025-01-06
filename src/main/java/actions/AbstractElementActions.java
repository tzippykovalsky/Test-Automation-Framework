package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

/**
 * AbstractElementActions provides basic actions that can be performed on web elements.
 * It serves as a base class for concrete implementations of element actions.
 */
public abstract class AbstractElementActions implements ElementActions{

    protected WebDriver driver;

    /**
     * Constructs an instance of AbstractElementActions with the specified WebDriver.
     *
     * @param driver The WebDriver to be used for performing actions.
     */
    public AbstractElementActions(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Moves the mouse over the specified element.
     *
     * @param element The WebElement to hover over.
     */
    public void mouseHover(WebElement element) {
        new Actions(driver).moveToElement(element).build().perform();
    }

    /**
     * Simulates pressing the Enter/Return key on the specified element.
     *
     * @param element The WebElement to perform the action on.
     */
    public void enter(WebElement element) {
        element.sendKeys(Keys.RETURN);
    }

    /**
     * Types the specified text into the given element after clearing its current content.
     *
     * @param element The WebElement where the text should be typed.
     * @param text    The text to type.
     */
    public void typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Scrolls the page to bring the specified element into view.
     *
     * @param element The WebElement to scroll to.
     */
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Retrieves the visible text of the specified element.
     *
     * @param element The WebElement to retrieve text from.
     * @return The visible text of the element.
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Checks if the specified element is displayed on the page.
     *
     * @param element The WebElement to check.
     * @return True if the element is displayed, false otherwise.
     */
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Toggles a checkbox to match the desired state.
     *
     * @param checkbox        The checkbox element.
     * @param shouldBeChecked True to check the checkbox, false to uncheck it.
     */
    public void toggleCheckbox(WebElement checkbox, boolean shouldBeChecked) {
        if (checkbox.isSelected() != shouldBeChecked) {
            checkbox.click();
        }
    }

    /**
     * Selects an option in a dropdown by its value attribute.
     *
     * @param dropdown The dropdown element.
     * @param value    The value attribute of the option to select.
     */
    public void selectDropdownByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * Selects an option in a dropdown by its visible text.
     *
     * @param dropdown    The dropdown element.
     * @param visibleText The visible text of the option to select.
     */
    public void selectDropdownByVisibleText(WebElement dropdown, String visibleText) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Selects an option in a dropdown by its index.
     *
     * @param dropdown The dropdown element.
     * @param index    The index of the option to select.
     */
    public void selectDropdownByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * Retrieves the value attribute of an input field.
     *
     * @param element The WebElement representing the input field.
     * @return The value of the input field.
     */
    public String getInputValue(WebElement element) {
        return element.getAttribute("value");
    }

    /**
     * Performs a right-click action on the specified element.
     *
     * @param element The WebElement to right-click on.
     */
    public void rightClick(WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

    /**
     * Performs a double-click action on the specified element.
     *
     * @param element The WebElement to double-click on.
     */
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    /**
     * Drags an element from its current position and drops it onto the target element.
     *
     * @param source The element to be dragged.
     * @param target The element to drop the dragged element onto.
     */
    public void dragAndDrop(WebElement source, WebElement target) {
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    /**
     * Checks if the specified element is enabled.
     *
     * @param element The WebElement to check.
     * @return True if the element is enabled, false otherwise.
     */
    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Checks if the specified element is selected.
     *
     * @param element The WebElement to check.
     * @return True if the element is selected, false otherwise.
     */
    public boolean isSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Performs a click action on the specified element while holding the Shift key.
     *
     * @param element The WebElement to click.
     */
    public void clickWithShift(WebElement element) {
        new Actions(driver).keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).perform();
    }

    /**
     * Performs a standard click action on the specified element.
     *
     * @param element The WebElement to click.
     */
    public void click(WebElement element) {
        element.click();
    }
}
