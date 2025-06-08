package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;
    private final Path propFilePath;
    private final String driverPath;

    public TestBase() {
        String os = System.getProperty("os.name").toLowerCase();
        Path basePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources");

        propFilePath = basePath.resolve(Paths.get("properties", "global.properties"));
        driverPath = basePath
                .resolve(Paths.get("driver", os.contains("linux") ? "linux" : "windows", os.contains("linux") ? "chromedriver" : "chromedriver.exe"))
                .toAbsolutePath()
                .toString();
    }

    public WebDriver webDriverManager() {
        if (driver == null) {
            Properties prop = new Properties();

            try (InputStream input = java.nio.file.Files.newInputStream(propFilePath)) {
                prop.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load properties file: " + propFilePath, e);
            }

            String browser = prop.getProperty("browser", "chrome").toLowerCase();
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
            } else {
                throw new UnsupportedOperationException("Browser not supported: " + browser);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(prop.getProperty("url"));
        }
        return driver;
    }
}
