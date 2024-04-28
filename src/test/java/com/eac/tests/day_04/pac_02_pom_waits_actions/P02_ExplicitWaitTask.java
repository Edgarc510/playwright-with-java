package com.eac.tests.day_04.pac_02_pom_waits_actions;

import com.eac.pages.DynamicPageLoading;
import com.eac.pages.LibraryLoginPage;
import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_ExplicitWaitTask {

    DynamicPageLoading dynamicPageLoading;

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_loading/7");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test01() {
            dynamicPageLoading = new DynamicPageLoading();

            //Driver.getPage().waitForFunction("document.URL.includes('search')");
            Driver.getPage().waitForFunction("document.title === 'Dynamic title'");
            //  BrowserUtils.sleepWithThread(6);
            System.out.println(dynamicPageLoading.getAlertMessage().textContent());
            Assertions.assertTrue(dynamicPageLoading.getAlertMessage().textContent().contains("Done"));

        }
    }
