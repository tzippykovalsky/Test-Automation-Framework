package actions;

import org.openqa.selenium.WebElement;

public interface ElementActions {
   public void mouseHover(WebElement element);
    public void enter(WebElement element);
    public void typeText(WebElement element, String text);
    public void scrollToElement(WebElement element);
    public String getText(WebElement element);
    public boolean isElementDisplayed(WebElement element);
    public void toggleCheckbox(WebElement checkbox, boolean shouldBeChecked);
    public void selectDropdownByValue(WebElement dropdown, String value);
    public void selectDropdownByVisibleText(WebElement dropdown, String visibleText);
    public void selectDropdownByIndex(WebElement dropdown, int index);
    public String getInputValue(WebElement element);
    public void rightClick(WebElement element);
    public void doubleClick(WebElement element);
    public void dragAndDrop(WebElement source, WebElement target);
    public boolean isEnabled(WebElement element);
    public boolean isSelected(WebElement element);
    public void clickWithShift(WebElement element);
}
