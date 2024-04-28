package com.eac.tests.day_03.pac_02_using_utility_methods_config_reader;

import com.eac.utilities.BrowserFactory;
import com.eac.utilities.BrowserUtils;
import com.eac.utilities.ConfigurationReader;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P02_UseConfigReaderWithBrowserFactory {

    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        String browserFromConfig = ConfigurationReader.getProperty("browser");
        browser= BrowserFactory.getBrowser(browserFromConfig, playwright);
        System.out.println("browserFromConfig = " + browserFromConfig);

    }
    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }
    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    public void test01(){

        page.navigate(ConfigurationReader.getProperty("googleURL"));

    }
}
