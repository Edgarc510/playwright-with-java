package com.eac.tests.day_04.pac_01_uploads_actions_js;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04_JSPractice {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/infinite_scroll");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }


    @Test
    void test1() {
        //evaluate("()=> {window.scrollBy(0,500);}"); this is function for java script
        //window.scrollBy(0,500);
        //this will scroll down 10 times 500 pixels
        for (int i = 0; i < 10; i++) {
        Driver.getPage().evaluate("window.scrollBy(0, 500)");
        BrowserUtils.sleepWithThread(1);
        }

    }

}
