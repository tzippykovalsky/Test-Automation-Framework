package selenium.pages;

import org.openqa.selenium.By;

/**
 * Element interface represents a single UI element on a web page.
 */

interface Element {
    /**
     * The name of the element
     * @return the name of the element
     */
    public By getBy();

    /**
     * The value of the element
     * @return the value of the element
     */
    public String getText();

    /**
     * Checks if the element is enabled
     * @return true if the element is enabled
     */
    public Boolean isEnabled();

    /**
     * Checks if the element is visible
     * @return true if the element is visible
     */
    public Boolean isDisplayed();

    /**
     * Sends text to the element
     * @param text
     */
    public void sendText(String text);

    /**
     * Clicks on the element
     */
    public void click();

    /**
     * Returns the value of the specified attribute of the element
     * @param attributeName
     * @return
     */
    public String getAttribute(String attributeName);

}