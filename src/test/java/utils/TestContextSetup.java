package utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

@Getter
@Setter
public class TestContextSetup {

    private WebDriver driver;
    private String landingPageProductName;
    private String actualProductName;
    private PageObjectManager pageObjectManager;

    public TestContextSetup(){
        pageObjectManager = new PageObjectManager(driver);
    }
}
