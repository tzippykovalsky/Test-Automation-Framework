package selenium.driver;

import enums.BrowserType;
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
    public WebDriver createLocalDriver(BrowserType browserName) {
        return switch (browserName) {
            case BrowserType.CHROME -> {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                yield new ChromeDriver();
            }
            case BrowserType.FIREFOX -> {
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                yield new FirefoxDriver();
            }
            case BrowserType.EDGE -> {
                WebDriverManager.edgedriver().clearDriverCache().setup();
                yield new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported driver name: " + browserName);
        };
    }

    @Override
    public WebDriver createRemoteDriver(URL remoteAddress, Capabilities capabilities) {
        throw new UnsupportedOperationException("Local driver cannot be remote.");
    }
}
