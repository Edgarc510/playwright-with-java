package com.eac.tests.day_04.pac_02_pom_waits_actions;

import com.eac.pages.LibraryLoginPage;
import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_POMPractice {
    LibraryLoginPage libraryLoginPage;

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();

    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }
/**/

    @Test
    void test1() {

        libraryLoginPage.getEmailInput().fill("invalid");
        libraryLoginPage.getPasswordInput().fill("ifidfji");
        libraryLoginPage.getSignInButton().click();

    }



}
