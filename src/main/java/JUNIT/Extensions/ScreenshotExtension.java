package JUNIT.Extensions;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import utils.ScreenCapture;
import utils.TestContext;

import java.io.IOException;

/**
 * ScreenshotExtension captures a screenshot if a test fails.
 */
public class ScreenshotExtension implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        // שליפת הדרייבר מה-Store של הטסט
//        WebDriver driver = context.getStore(ExtensionContext.Namespace.GLOBAL).get("driver", WebDriver.class);
        WebDriver driver = TestContext.getDriver();  // שליפה ישירה של הדרייבר מה-TestContext
        System.out.println("Driver retrieved: " + (driver != null));
        if (driver != null) {
            try {
                String testName = context.getDisplayName();
                String filePath = "src/test/resources/screenshots/" + testName + "_failed.png";
                ScreenCapture.takeScreenshot(driver, filePath);  // צילום מסך בזמן כשלון
                System.out.println("Screenshot saved: " + filePath);
            } catch (IOException e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }
}
