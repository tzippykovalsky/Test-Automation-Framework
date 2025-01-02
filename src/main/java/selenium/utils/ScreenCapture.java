package selenium.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * ScreenCapture is responsible for taking and saving screenshots during tests.
 */
public class ScreenCapture {

    private static final String DEFAULT_SCREENSHOT_DIR = "src/test/resources/screenshots/"; // נתיב ברירת מחדל

    /**
     * Takes a screenshot and saves it to the specified file path.
     * If no file path is provided, it saves it to the default directory.
     *
     * @param driver the WebDriver instance used for capturing the screenshot
     * @param filePath the file path where the screenshot should be saved (optional)
     * @throws IOException if there is an error saving the screenshot
     */
    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
        // אם לא נשלח נתיב, נשתמש בברירת מחדל
        if (filePath == null || filePath.isEmpty()) {
            // יצירת שם קובץ ייחודי (כולל timestamp)
            String timestamp = String.valueOf(System.currentTimeMillis());
            filePath = DEFAULT_SCREENSHOT_DIR + "screenshot_" + timestamp + ".png";
        }

        // ודא שהתקייה קיימת, אם לא - צור אותה
        File directory = new File(filePath).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Cast the driver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture the screenshot and store it as a temporary file
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Create a destination file at the specified location
        File destinationFile = new File(filePath);

        // Copy the screenshot to the destination
        FileUtils.copyFile(sourceFile, destinationFile);
    }
}
