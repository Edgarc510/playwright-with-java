package com.eac.tests.day_02_multipleElements_checkbox_radio.pac01;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P01_xpath_css_elementHandle {


    @Test
    public void test01() {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/forgot_password");

        ElementHandle homeLink = page.querySelector("a.nav-link");
        ElementHandle email = page.querySelector("div label");
        //prints webelement text -> textContent()
        System.out.println("homeLink = " + homeLink.textContent());
        System.out.println("email = " + email.textContent());
        System.out.println("homeLink.isVisible() = " + homeLink.isVisible());
        System.out.println("email.isVisible() = " + email.isVisible());


        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();


    }
}
