package com.eac.tests.day_02_multipleElements_checkbox_radio.pac01;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P05_RadioButtons {
    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/radio_buttons");

/**
 * //below will not work because the word "for" is not in the DOM
 *         //<label class="form-check-label" for="hockey">Hockey</label>
 *         //<label class="form-check-label">Red</label>
 *         line 32 is used instead using css
 */
//        page.getByRole(AriaRole.RADIO,
//                new Page.GetByRoleOptions().setName("Red")).click();

        Locator red = page.locator("#red");
        red.click();

        page.getByRole(AriaRole.RADIO,
                new Page.GetByRoleOptions().setName("Hockey")).click();


        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();
    }
}
