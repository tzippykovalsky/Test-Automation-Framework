package JUNIT.Extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * A JUnit 5 extension that implements {@link TestWatcher} to log test execution events.
 * This extension uses SLF4J for logging and logs the status of each test execution, including success, failure, abortion, and disabling.
 */
public class WatcherExtension implements TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(WatcherExtension.class);

    /**
     * Logs when a test is disabled.
     *
     * @param context the current test execution context
     * @param reason  an optional reason why the test was disabled
     */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info("Test: {} Disabled. Reason: {}", context.getDisplayName(), reason.orElse("No reason provided"));
    }

    /**
     * Logs when a test completes successfully.
     *
     * @param context the current test execution context
     */
    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("Test: {} Successful", context.getDisplayName());
    }

    /**
     * Logs when a test is aborted.
     *
     * @param context the current test execution context
     * @param cause   the reason for the test abortion
     */
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.warn("Test: {} Aborted. Cause: {}", context.getDisplayName(), cause.getMessage());
    }

    /**
     * Logs when a test fails.
     *
     * @param context the current test execution context
     * @param cause   the reason for the test failure
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error("Test: {} Failed. Cause: {}", context.getDisplayName(), cause.getMessage(), cause);
    }
}
