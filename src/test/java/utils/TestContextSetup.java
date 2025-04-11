package utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

@Getter
@Setter
public class TestContextSetup {

    private WebDriver driver;
    private String landingPageProductName;
    private String actualProductName;
}
