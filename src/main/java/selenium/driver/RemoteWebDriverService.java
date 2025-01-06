package selenium.driver;

import enums.BrowserType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Remote WebDriver Service implementation.
 * <p>
 * This service is responsible for creating and managing remote {@link WebDriver} instances
 * that connect to a Selenium Grid or a cloud-based WebDriver service (e.g., BrowserStack, Sauce Labs).
 * It provides an implementation of {@link WebDriverService} for remote execution.
 * </p>
 */
public class RemoteWebDriverService implements WebDriverService {

    /**
     * The URL of the Selenium Grid hub or remote WebDriver service.
     */
    private final URL remoteAddress;

    /**
     * The desired capabilities for the remote WebDriver instance.
     */
    private final Capabilities capabilities;

    /**
     * Constructs a new {@code RemoteWebDriverService} with the specified remote address and capabilities.
     *
     * @param remoteAddress the URL of the Selenium Grid hub or remote WebDriver service
     * @param capabilities  the desired capabilities for the WebDriver instance
     */
    public RemoteWebDriverService(URL remoteAddress, Capabilities capabilities) {
        this.remoteAddress = remoteAddress;
        this.capabilities = capabilities;
    }

    /**
     * This method is unsupported for remote WebDriver.
     * <p>
     * Since this service is designed for remote execution, calling this method will throw an
     * {@link UnsupportedOperationException}.
     * </p>
     *
     * @param browserName the type of browser (not used in this implementation)
     * @return nothing, as this method always throws an exception
     * @throws UnsupportedOperationException always thrown to indicate unsupported operation
     */
    @Override
    public WebDriver createLocalDriver(BrowserType browserName) {
        throw new UnsupportedOperationException("Remote WebDriver can only be used with createRemoteDriver.");
    }

    /**
     * Creates a new remote {@link WebDriver} instance connected to the specified remote address
     * with the given capabilities.
     *
     * @param remoteAddress the URL of the Selenium Grid hub or remote WebDriver service
     * @param capabilities  the desired capabilities for the WebDriver instance
     * @return a {@link RemoteWebDriver} instance connected to the remote service
     */
    @Override
    public WebDriver createRemoteDriver(URL remoteAddress, Capabilities capabilities) {
        // Create and return a Remote WebDriver instance
        return new RemoteWebDriver(remoteAddress, capabilities);
    }
}
