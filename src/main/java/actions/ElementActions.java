package actions;

import org.openqa.selenium.WebElement;

/**
 * ElementActions is an interface that defines various actions
 * that can be performed on web elements in a web application.
 * These actions include interaction methods such as clicking,
 * typing text, selecting from dropdowns, and verifying element states.
 */
public interface ElementActions {

 void mouseHover(WebElement element);

 void enter(WebElement element);

 void typeText(WebElement element, String text);

 void scrollToElement(WebElement element);

 String getText(WebElement element);

 boolean isElementDisplayed(WebElement element);

 void toggleCheckbox(WebElement checkbox, boolean shouldBeChecked);

 void selectDropdownByValue(WebElement dropdown, String value);

 void selectDropdownByVisibleText(WebElement dropdown, String visibleText);

 void selectDropdownByIndex(WebElement dropdown, int index);

 String getInputValue(WebElement element);

 void rightClick(WebElement element);

 void doubleClick(WebElement element);

 void dragAndDrop(WebElement source, WebElement target);

 boolean isEnabled(WebElement element);

 boolean isSelected(WebElement element);

 void clickWithShift(WebElement element);

 void click(WebElement element);
}
