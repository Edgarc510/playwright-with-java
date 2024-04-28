package com.eac.tests.day_01.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P02_Differences_InnerText_TextContent {

    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("file:///C:/Users/ceale/IdeaProjects/playwright-with-java/src/test/resources/getText.html");
        System.out.println("textContent() = " + page.querySelector("#example").textContent());
        System.out.println("innerText() = " + page.querySelector("#example").innerText());
        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();


    }

}
