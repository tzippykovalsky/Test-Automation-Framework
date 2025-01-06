package JUNIT.Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;

/**
 * Extension that retries a test a specified number of times upon failure.
 * Implements the JUnit 5 extension interface to handle test execution exceptions
 * and trigger retries if a test fails.
 */
public class RetryExtension implements TestExecutionExceptionHandler, BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final int MAX_RETRY_COUNT = 3; // Maximum retry attempts
    private int retryCount = 0;

    /**
     * Resets the retry count before each test execution.
     *
     * @param context The context of the current test execution
     */
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        retryCount = 0;  // Reset retry count before each test
    }

    /**
     * Handles test execution exceptions and retries the test a specified number of times
     * if it fails.
     *
     * @param context   The context of the current test execution
     * @param throwable The exception thrown during the test execution
     * @throws Throwable The original exception if retry attempts are exhausted
     */
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++; // Increment retry count
            System.out.println("Retrying test " + context.getDisplayName() + " for the " + retryCount + " time.");
            // Re-throw the exception so JUnit can retry the test
        } else {
            System.out.println("Max retry attempts reached for test: " + context.getDisplayName());
        }
        throw throwable;  // Re-throws the exception, causing JUnit to retry the test
    }

    /**
     * Invoked after the test execution. Can be used for any cleanup operations.
     *
     * @param context The context of the current test execution
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        // Cleanup logic after test execution, if necessary
    }
}
