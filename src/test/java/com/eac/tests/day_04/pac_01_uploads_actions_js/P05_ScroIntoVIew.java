package com.eac.tests.day_04.pac_01_uploads_actions_js;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P05_ScroIntoVIew {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
    }

    @Test
    public void test01() {

        ElementHandle element = Driver.getPage().waitForSelector("//*[@href='/web-tables']");
        BrowserUtils.sleepWithThread(3);
        element.scrollIntoViewIfNeeded();
        ElementHandle home = Driver.getPage().querySelector("text=Home");
        BrowserUtils.sleepWithThread(3);
        home.scrollIntoViewIfNeeded();

////*[@href='/web-tables']

    }

}
