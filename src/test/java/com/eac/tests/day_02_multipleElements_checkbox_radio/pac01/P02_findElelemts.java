package com.eac.tests.day_02_multipleElements_checkbox_radio.pac01;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P02_findElelemts {

    @Test

        public void test1(){
        Playwright playwright=Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/abtest");
        List<ElementHandle> allLinks = page.querySelectorAll("//a");
        for (ElementHandle allLink : allLinks) {
            System.out.println("allLink.getAttribute(\"href\") = " + allLink.getAttribute("href"));
            System.out.println("allLink = " + allLink.textContent());
        }

        BrowserUtils.sleepWithPage(page,3);
        page.close();
        browser.close();
        playwright.close();



    }
}
