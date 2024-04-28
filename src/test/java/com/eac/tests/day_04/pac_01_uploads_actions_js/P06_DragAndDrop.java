package com.eac.tests.day_04.pac_01_uploads_actions_js;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P06_DragAndDrop {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/drag_and_drop_circles");

    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void dragAndDrop() {
        //draggable
        Locator source = Driver.getPage().getByTestId("draggable");
        Locator target = Driver.getPage().getByTestId("droptarget");
        String text = target.textContent();
        System.out.println("before = " + text);
        BrowserUtils.sleepWithThread(2);
        source.dragTo(target);
        System.out.println("after = " + text);


    }

    @Test
    void dragAndDrop2() {
        //draggable
        Locator source = Driver.getPage().getByTestId("draggable");
        Locator target = Driver.getPage().getByTestId("droptarget");

        System.out.println("before = " + target.textContent());
        source.click();
        BrowserUtils.sleepWithThread(1);
        Driver.getPage().mouse().down();
        BrowserUtils.sleepWithThread(2);
        Driver.getPage().mouse().move(500,200);
        BrowserUtils.sleepWithThread(1);
        Driver.getPage().mouse().up();

        BrowserUtils.sleepWithThread(3);
        System.out.println("after = " + target.textContent());


    }

}
