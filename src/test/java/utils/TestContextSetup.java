package utils;

import lombok.Getter;
import lombok.Setter;
import pageObjects.PageObjectManager;

@Getter
@Setter
public class TestContextSetup {

    private String landingPageProductName;
    private String actualProductName;
    private PageObjectManager pageObjectManager;
    private TestBase testBase;
    private GenericUtils genericUtils;


    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
