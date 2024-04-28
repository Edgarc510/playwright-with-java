package com.eac.tests.day_02_multipleElements_checkbox_radio.pac01;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P04_checkbox_radio {

    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/checkboxes");

        Locator checkBox1 = page.locator("#box1");
        Locator checkBox2 = page.locator("#box2");

        checkBox1.click();
        BrowserUtils.sleepWithThread(2);
        checkBox2.uncheck();
        BrowserUtils.sleepWithThread(2);
        checkBox1.uncheck();
        BrowserUtils.sleepWithThread(2);
        checkBox2.check();
        BrowserUtils.sleepWithThread(2);
        checkBox1.check();

//        Locator checkbox1Role = page.getByRole(AriaRole.CHECKBOX,
//                new Page.GetByRoleOptions().setChecked(false));

//        Locator checkbox1Role1 = page.getByRole(AriaRole.CHECKBOX).nth(1);

        System.out.println("checkBox1.isChecked() = " + checkBox1.isChecked());
        System.out.println("checkBox2.isChecked() = " + checkBox2.isChecked());

        BrowserUtils.sleepWithThread(3);

        page.close();
        browser.close();
        playwright.close();


    }
}
