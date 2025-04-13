package utils;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

@AllArgsConstructor
public class GenericUtils {

    private WebDriver driver;

    public void switchToChildWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
    }
}
