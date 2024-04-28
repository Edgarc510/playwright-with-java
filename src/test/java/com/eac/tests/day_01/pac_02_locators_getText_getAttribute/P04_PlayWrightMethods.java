package com.eac.tests.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlayWrightMethods {

    @Test
    public void test(){

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();

        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://library2.cybertekschool.com/login.html");
//        page.getByPlaceholder("Email address").fill("incorrectemail@gmail.com");
        //below code requires to type the exaxt locator name, no case sensitive..etc
        page.getByPlaceholder("Email address",
                new Page.GetByPlaceholderOptions().setExact(true)).
                fill("incorrectemail@gmail.com");
//        page.getByLabel("Password").fill("fsdfew");
//        page.getByPlaceholder("Password").fill("fsdfew");
        page.querySelector("#inputPassword").fill("fsdfew");

        //Find button
//        Keyboard keyboard = page.keyboard();
//        keyboard.press("Enter");

        //another way to click button using getByRole
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions()
                        .setName("Sign in")).click();

        //With setExact == true
//        page.getByRole(AriaRole.BUTTON,
//                new Page.GetByRoleOptions()
//                        .setName("Sign in").setExact(true)).click();

        page.waitForTimeout(3000);
        System.out.println("ALERT).isVisible() = " + page.getByRole(AriaRole.ALERT).isVisible());
        System.out.println("ALERT).textContent() = " + page.getByRole(AriaRole.ALERT).textContent());

        page.waitForTimeout(5000);
        page.close();
        browser.close();
        playwright.close();
    }

}
