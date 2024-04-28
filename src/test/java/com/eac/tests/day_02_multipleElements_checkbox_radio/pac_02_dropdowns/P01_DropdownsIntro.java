package com.eac.tests.day_02_multipleElements_checkbox_radio.pac_02_dropdowns;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P01_DropdownsIntro {

    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

//        Locator dropdown = page.locator(".dropdown");
        ElementHandle dropdown = page.querySelector("#dropdown");

        //evaluate is to run javaScript commands
        String selectedOption = page.evaluate("el=>el.selectedOptions[0].text",dropdown).toString();
        System.out.println("selectedOption = " + selectedOption);


        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();


    }

}
