package com.eac.tests.day_03.pac_01_alerts_frames_windows;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

public class P03_WindowHandle {

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
    static void beforeAll() {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {

        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void closePage() {
        BrowserUtils.sleepWithThread(3);
        page.close();
    }

    @Test
    public void windowHandle() {

//        page.pause();

        //get the title
        System.out.println("before clicking page title = " + page.title());

        //click Click Here button (it will open a new tab)
/*
     //   search   it
        ElementHandle locator = page.querySelector("text=Click Here");
        locator.click();
*/

        //get second window title
        BrowserUtils.sleepWithThread(3);

        Page secondPage = page.waitForPopup(() -> {page.getByText("Click Here").click();});
//        Page secondPage = page.waitForPopup(() -> {});

        System.out.println("after clicking button second page title= " + secondPage.title());

        BrowserUtils.sleepWithThread(2);
        //go back to first page
        page.bringToFront();
        BrowserUtils.sleepWithThread(1);
        secondPage.bringToFront();
        BrowserUtils.sleepWithThread(1);

        page.bringToFront();

        //Click home

        page.click("text=Home");

        BrowserUtils.sleepWithThread(3);

        //get the title again

        System.out.println("practice title= " + page.title());


    }

    @Test
    public void secondApproachWindowHandles() {


        //get the title
        System.out.println("page.title() = " + page.title());

        //click here button
        page.click("text=Click Here");
        //get the second window title
        Page newPage = browser.contexts().get(0).pages().get(1);
        System.out.println("page.title() = " + newPage.title());
        //go back to first page
        newPage = browser.contexts().get(0).pages().get(0);
        //click home button
        newPage.click("text=Home");
        //get the title again
        System.out.println("page.title() = " + newPage.title());
    }




}
