package com.eac.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_ClickLinkWithText {

    @Test
    public void test() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");
//        page.setViewportSize(1080,1080);
        page.waitForTimeout(3000);
        page.click("text=A/B Testing");
        page.waitForTimeout(3000);
        System.out.println("page.title() = " + page.title());




        page.close();
        browser.close();
        playwright.close();


    }

}
