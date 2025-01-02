package actions;

import org.openqa.selenium.By;
import enums.LocatorType;

/**
 * ElementBase is a base class for all elements in the application.
 * It provides common methods for interacting with web elements.
 * It includes methods for getting the element's text, checking its enabled status,
 * and checking its visibility.
 *
 */
public class ElementLocator{
    //add more actions
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


}