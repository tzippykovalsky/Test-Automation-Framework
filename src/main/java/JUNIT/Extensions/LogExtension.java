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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogExtension implements BeforeAllCallback, AfterAllCallback {

    private static BufferedWriter logWriter;
    private static final String LOG_DIRECTORY = "src/test/resources/logs";
    private static final String LOG_FILE = LOG_DIRECTORY + "/test-log.txt";
    private static final Lock logLock = new ReentrantLock(); // מנעול לכתיבה בטוחה

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        logLock.lock(); // נעילה לכתיבה בטוחה
        try {
            File logDir = new File(LOG_DIRECTORY);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            if (logWriter == null) { // ודא ש-BufferedWriter נפתח פעם אחת
                logWriter = new BufferedWriter(new FileWriter(LOG_FILE, true));
            }

            logWriter.write(getCurrentTimestamp() + " start: " + context.getDisplayName() + "\n");
            logWriter.flush();
        } finally {
            logLock.unlock(); // שחרור המנעול
        }
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        logLock.lock(); // נעילה לכתיבה בטוחה
        try {
            if (logWriter != null) {
                logWriter.write(getCurrentTimestamp()+ " finish: " + context.getDisplayName() + "\n");
                logWriter.flush(); // שמור את התוכן
            }
        } finally {
            logLock.unlock(); // שחרור המנעול
        }
    }

    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
