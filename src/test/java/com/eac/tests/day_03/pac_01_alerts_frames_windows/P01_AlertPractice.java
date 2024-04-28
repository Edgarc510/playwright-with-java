package com.eac.tests.day_03.pac_01_alerts_frames_windows;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {

    /**
     * Shared between all tests in this class.
     * this must be static
     */
    static private Playwright playwright;
    static private Browser browser;
    /**
     * New instance for each test method.
     * that's why this is not static
     */
    private Page page;

    @BeforeAll
    static void  beforeAll() {

         playwright = Playwright.create();
         browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(1000));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {

        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/javascript_alerts");


    }

    @AfterEach
    void closePage() {
        BrowserUtils.sleepWithThread(3);
        page.close();
    }

    @Test
    public void test01() {

//        page.navigate("https://practice.cydeo.com/javascript_alerts");
        page.locator("button").first().click();

        String actualResultText = page.locator("#result").textContent();
        String expectedResultText = "You successfully clicked an alert";

        System.out.println("actualResultText = " + actualResultText);
        System.out.println("expectedResultText = " + expectedResultText);

        Assertions.assertEquals(actualResultText,expectedResultText);


    }

    @Test
    public void test01HandleAlertMyself() {


        page.onceDialog(dialog -> dialog.accept()); //page.onceDialog(Dialog::accept);
        Locator firstButton = page.locator("//button[.='Click for JS Confirm']");
        BrowserUtils.sleepWithThread(2);
        firstButton.click();
        BrowserUtils.sleepWithThread(2);



        String actualResultText = page.locator("#result").textContent();
        String expectedResultText = "You clicked: Ok";

        System.out.println("actualResultText = " + actualResultText);
        System.out.println("expectedResultText = " + expectedResultText);

        Assertions.assertEquals(actualResultText,expectedResultText);


    }


}
