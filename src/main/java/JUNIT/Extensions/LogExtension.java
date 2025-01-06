package JUNIT.Extensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LogExtension is a JUnit 5 extension that logs the start and finish of test execution.
 * It creates a log file and appends information about each test suite.
 */
public class LogExtension implements BeforeAllCallback, AfterAllCallback {

    private static BufferedWriter logWriter;
    private static final String LOG_DIRECTORY = "src/test/resources/logs";
    private static final String LOG_FILE = LOG_DIRECTORY + "/test-log.txt";
    private static final Lock logLock = new ReentrantLock(); // Lock for thread-safe writing

    /**
     * Called before all tests in a test suite are executed. Initializes the log file and writes the start entry.
     *
     * @param context The context of the test suite.
     * @throws Exception If an I/O error occurs while writing to the log file.
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        logLock.lock(); // Lock for thread-safe writing
        try {
            File logDir = new File(LOG_DIRECTORY);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }

            if (logWriter == null) { // Ensure BufferedWriter is initialized only once
                logWriter = new BufferedWriter(new FileWriter(LOG_FILE, true));
            }

            logWriter.write(getCurrentTimestamp() + " start: " + context.getDisplayName() + "\n");
            logWriter.flush();
        } finally {
            logLock.unlock(); // Unlock after writing
        }
    }

    /**
     * Called after all tests in a test suite are executed. Writes the finish entry to the log file.
     *
     * @param context The context of the test suite.
     * @throws Exception If an I/O error occurs while writing to the log file.
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        logLock.lock(); // Lock for thread-safe writing
        try {
            if (logWriter != null) {
                logWriter.write(getCurrentTimestamp() + " finish: " + context.getDisplayName() + "\n");
                logWriter.flush(); // Ensure content is saved
            }
        } finally {
            logLock.unlock(); // Unlock after writing
        }
    }

    /**
     * Returns the current timestamp in the format "yyyy-MM-dd HH:mm:ss".
     *
     * @return A string representing the current timestamp.
     */
    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
