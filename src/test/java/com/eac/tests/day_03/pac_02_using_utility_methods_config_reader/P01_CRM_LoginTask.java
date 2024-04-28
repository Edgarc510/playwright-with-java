package com.eac.tests.day_03.pac_02_using_utility_methods_config_reader;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.CRMUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P01_CRM_LoginTask {
    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
        page.navigate("https://login1.nextbasecrm.com/");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(5);
        page.close();
    }

    @Test
    public void loginTaskCRM() {
        //marketing1@cydeo.com
        CRMUtils.login(page);

    }

    @Test
    public void logInTest() {
        CRMUtils.login(page,"marketing1@cydeo.com","UserUser");
        page.locator(".login-btn").click();
    }

}
