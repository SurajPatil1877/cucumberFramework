package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null) {
            Properties prop = new Properties();
            String baseLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\";
            try {
                prop.load(new FileInputStream(baseLocation + "properties\\global.properties"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", baseLocation + "driver\\chromedriver.exe");
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(prop.getProperty("url"));
        }
        return driver;
    }
}
