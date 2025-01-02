package actions;

import org.openqa.selenium.By;
import enums.LocatorType;

/**
 * ElementLocator provides utility methods for creating locators.
 * Includes methods for simple and dynamic locators (like complex XPath or dynamic elements).
 */
public class ElementLocator {

    /**
     * Creates a locator based on the specified locator type and attribute value.
     * @param locatorType the type of locator (e.g., id, name, xpath, etc.)
     * @param attributeValue the value of the attribute
     * @return a By object representing the locator
     */
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

    /**
     * Creates a dynamic XPath based on a template and the dynamic parameter to replace in the XPath.
     * @param xpathTemplate the XPath template
     * @param dynamicValue the value to replace in the XPath
     * @return a By object representing the dynamic XPath locator
     */
    public static By createDynamicXPath(String xpathTemplate, String dynamicValue) {
        String dynamicXPath = xpathTemplate.replace("{dynamicValue}", dynamicValue);
        return By.xpath(dynamicXPath);
    }

    /**
     * Validates whether a given XPath is syntactically valid.
     * @param xpath the XPath to validate
     * @return true if the XPath is valid, false otherwise
     */
    public static boolean isValidXPath(String xpath) {
        try {
            // Try creating a By object to see if the XPath is valid
            By.xpath(xpath);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
