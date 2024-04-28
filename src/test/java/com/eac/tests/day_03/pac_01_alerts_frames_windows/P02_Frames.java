package com.eac.tests.day_03.pac_01_alerts_frames_windows;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class P02_Frames {
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
        page.navigate("https://practice.cydeo.com/iframe");


    }

    @AfterEach
    void closePage() {
        BrowserUtils.sleepWithThread(3);
        page.close();
    }

    @Test
    public void frameTest01() {

        FrameLocator firstFrame = page.frameLocator("#mce_0_ifr");
        firstFrame.locator("#tinymce").clear();
        //send text use .fill method
        firstFrame.locator("#tinymce").fill("Here goes Adam");

        String textFromBox = firstFrame.locator("//p").textContent();
        System.out.println("textFromBox = " + textFromBox);
        assertEquals("Here goes Adam", textFromBox);


    }
}
