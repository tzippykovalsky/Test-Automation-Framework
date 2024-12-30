package selenium.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Remote WebDriver Service implementation.
 *
 * This service is responsible for creating a remote WebDriver instance connected
 * to a Selenium Grid or cloud-based WebDriver server.
 */
public class RemoteWebDriverService implements WebDriverService {

    private final URL remoteAddress;
    private final Capabilities capabilities;

    public RemoteWebDriverService(URL remoteAddress, Capabilities capabilities) {
        this.remoteAddress = remoteAddress;
        this.capabilities = capabilities;
    }

    @Override
    public WebDriver createLocalDriver(String browserName) {
        throw new UnsupportedOperationException("Remote WebDriver can only be used with createRemoteDriver.");
    }

    @Override
    public WebDriver createRemoteDriver(URL remoteAddress, Capabilities capabilities) {
        // Create and return a Remote WebDriver instance
        return new RemoteWebDriver(remoteAddress, capabilities);
    }
}
