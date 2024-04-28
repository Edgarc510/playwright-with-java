package com.eac.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P01_Locators {

    @Test
    public void test01(){

        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://login1.nextbasecrm.com/");

        page.querySelector("[name=USER_LOGIN]").fill("ngjnjfnjr");
        page.querySelector("[name=USER_PASSWORD]").fill("incorrect password");
//        page.querySelector("[class=login-btn]").click();
        page.querySelector(".login-btn").click();
        String incorrectPasswordMessage = page.querySelector(".errortext").textContent();
        System.out.println("inccorrectPasswordMessage = " + incorrectPasswordMessage);

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();
    }
}
