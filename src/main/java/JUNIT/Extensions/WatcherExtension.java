package JUNIT.Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class WatcherExtension implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test: " + context.getDisplayName() + " Disabled");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test: " + context.getDisplayName() + " Successful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test: " + context.getDisplayName() + " Aborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test: " + context.getDisplayName() + " Failed");
    }
}
