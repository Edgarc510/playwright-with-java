package com.eac.tests.day_02_multipleElements_checkbox_radio.pac01;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P03_ClickWithIndex extends BrowserUtils {

    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");


        List<ElementHandle> elementHandlesList = page.querySelectorAll(".container li a");
        System.out.println("list size = " + elementHandlesList.size());

        page.locator(".container li a")
//                .first()
//                .last()
                .nth(4)//index
                .click();

        for (int i = 0; i < elementHandlesList.size(); i++) {
            Locator locator = page.locator(".container li a").nth(i);

            if (locator.textContent().equals("A/B Testing")) {
                    locator.click();

                break;
            }

        }


        sleepWithPage(page,3);
        page.close();
        browser.close();
        playwright.close();
    }

}
