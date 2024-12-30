package JUNIT.Extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogExtension implements BeforeAllCallback, AfterAllCallback {

    private static BufferedWriter logWriter;

    // אתחול הלוג לפני כל הבדיקות
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        // יצירת קובץ לוג או פתיחה של קובץ קיים
        logWriter = new BufferedWriter(new FileWriter("test-log.txt", true));
        logWriter.write(getCurrentTimestamp() + " התחלת הבדיקות- \n" + context.getDisplayName() + "\n");
        logWriter.flush();
    }

    // ניקוי הלוג אחרי כל הבדיקות
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
