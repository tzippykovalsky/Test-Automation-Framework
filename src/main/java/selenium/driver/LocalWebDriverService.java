package selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Local WebDriver Service implementation.
 * <p>
 * This service is responsible for creating a local WebDriver instance (e.g., ChromeDriver).
 */
public class LocalWebDriverService implements WebDriverService {

    /**
     * Creates a WebDriver instance based on the provided browser name.
     * <p>
     * Supported browsers: Chrome, Firefox, Edge
     * If browserName is not supported, an IllegalArgumentException will be thrown.
     *
     * @param browserName
     * @return driver instance
     */
    @Override
    public WebDriver createLocalDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().clearDriverCache().setup();
                return new ChromeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().clearDriverCache().setup();
                return new EdgeDriver();
            default:
                break;
        }
        throw new IllegalArgumentException("Unsupported driver name: " + browserName);
    }

    @Override
    public WebDriver createRemoteDriver(URL remoteAddress, Capabilities capabilities) {
        throw new UnsupportedOperationException("Local driver cannot be remote.");
    }
}
