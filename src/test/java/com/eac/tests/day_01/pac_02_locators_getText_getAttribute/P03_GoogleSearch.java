package com.eac.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {


    @Test
    public void test01(){

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://google.com/");

        //name name="q"

        //locate element
//        Locator searchBox = page.locator("textarea[name='q']");
        Locator searchBox = page.locator("//textarea[@name='q']");
//        searchBox.type("selenium"); // deprecated
//        searchBox.fill("selenium"); // types whole word at once, not letter by letter
//        searchBox.pressSequentially("selenium"); // this is letter by letter
        searchBox.pressSequentially("selenium",
                new Locator.PressSequentiallyOptions()
                .setDelay(100)); // this is letter by letter

        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");

        page.waitForTimeout(5000);


        page.close();
        browser.close();
        playwright.close();
    }

}
