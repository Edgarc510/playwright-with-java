package com.eac.tests.day_02_multipleElements_checkbox_radio.pac_02_dropdowns;

import com.eac.utilities.BrowserUtils;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_DropdownSelectOption {


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

        ElementHandle year = page.querySelector("#year");
        ElementHandle month = page.querySelector("#month");
        ElementHandle day = page.querySelector("#day");

        String expectedYear = "1988";
        String expectedMonth = "January";
        int expectedDay = 12;

        year.selectOption(new SelectOption().setValue("1988"));
        month.selectOption(new SelectOption().setLabel("January")); //label means text
        day.selectOption(new SelectOption().setIndex(11));

        String actualYear = page.evaluate("el=>el.selectedOptions[0].text", year).toString();
        String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", month).toString();
        String actualDay = page.evaluate("el=>el.selectedOptions[0].text", day).toString();

        System.out.println("with DOM knowledge " + page.evaluate("document.querySelector('#year').value").toString());

        Assertions.assertEquals(expectedYear,actualYear);
        Assertions.assertEquals(expectedMonth,actualMonth);
        Assertions.assertEquals(expectedYear,actualYear);





/**
 * //from ChatGPT
        ElementHandle selectElement = page.querySelector("#dropdown");
        selectElement.selectOption(new SelectOption("value", "option2"));

        // Get the selected option's value
        String selectedOptionValue = page.evaluate("() => document.querySelector('#myDropdown').value").toString();
        System.out.println("Selected option value: " + selectedOptionValue);

        // Get the selected option's text
        String selectedOptionText = page.evaluate("() => document.querySelector('#myDropdown').options[document.querySelector('#myDropdown').selectedIndex].text").toString();
        System.out.println("Selected option text: " + selectedOptionText);
*/

        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();




    }
}
