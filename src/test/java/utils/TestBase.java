package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    private WebDriver driver;

    public WebDriver webDriverManager() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
