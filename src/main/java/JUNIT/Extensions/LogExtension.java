package JUNIT.Extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogExtension implements BeforeAllCallback, AfterAllCallback {

    private static BufferedWriter logWriter;
    private static final String LOG_DIRECTORY = "src/test/resources/logs";
    private static final String LOG_FILE = LOG_DIRECTORY + "/test-log.txt";

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        // ודא שהתיקיה קיימת ואם לא, צור אותה
        File logDir = new File(LOG_DIRECTORY);
        if (!logDir.exists()) {
            logDir.mkdirs();  // יצירת תיקיה אם היא לא קיימת
        }

        // יצירת קובץ לוג או פתיחה של קובץ קיים
        logWriter = new BufferedWriter(new FileWriter(LOG_FILE, true));
        logWriter.write(getCurrentTimestamp() + " התחלת הבדיקות- \n" + context.getDisplayName() + "\n");
        logWriter.flush();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if (logWriter != null) {
            logWriter.write(getCurrentTimestamp() + " סיום הבדיקות- \n");
            logWriter.close();
        }
    }

    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
