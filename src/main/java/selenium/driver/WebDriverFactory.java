package selenium.driver;

import org.openqa.selenium.Capabilities;

import java.net.URL;

/**
 * Factory class to instantiate local and remote WebDriver services.
 *
 * This class provides a method for creating local or remote WebDriver instances
 * based on provided configurations and capabilities.
 */
public class WebDriverFactory {

    /**
     * Creates a local WebDriver based on default or custom configuration.
     *
     * @return a new instance of WebDriver
     */
    public static WebDriverService createLocalDriver() {
        return new LocalWebDriverService();
    }

    /**
     * Creates a remote WebDriver based on remote server URL and capabilities.
     *
     * @param remoteAddress URL of the remote WebDriver server
     * @param capabilities the capabilities to configure the WebDriver
     * @return a new instance of WebDriver for remote execution
     */
    public static WebDriverService createRemoteDriver(URL remoteAddress, Capabilities capabilities) {
        return new RemoteWebDriverService(remoteAddress, capabilities);
    }
}
