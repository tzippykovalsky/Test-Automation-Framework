package selenium.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.URL;

/**
 * Service for creating WebDriver instances.
 *
 * This service provides methods for creating a local or remote WebDriver instance
 * based on provided configurations and capabilities.
 */
public interface WebDriverService {
    /**
     * Create a WebDriver instance based on the provided configuration.
     *
     * @return a new instance of WebDriver
     */
    WebDriver createLocalDriver(String driverName);

    /**
     * Create a WebDriver instance using a remote server.
     *
     * @param remoteAddress the URL of the remote WebDriver server
     * @param capabilities the capabilities for the WebDriver
     * @return a new instance of WebDriver connected to a remote server
     */
    WebDriver createRemoteDriver(URL remoteAddress, Capabilities capabilities);
}
