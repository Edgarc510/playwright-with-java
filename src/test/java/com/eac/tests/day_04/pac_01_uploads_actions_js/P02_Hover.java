package com.eac.tests.day_04.pac_01_uploads_actions_js;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_Hover {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");

    }
    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithThread(7);
        Driver.closeDriver();
    }

    @Test
    public void hoverTest01(){

        Driver.getPage().locator("img").nth(0).hover();
        BrowserUtils.sleepWithThread(2);
        String objectOne = Driver.getPage().locator("//h5").nth(0).textContent();
        System.out.println("objectOne = " + objectOne);
        Driver.getPage().locator("img").nth(1).hover();
        String objectTwo = Driver.getPage().locator("//h5").nth(1).textContent();
        System.out.println("objectTwo = " + objectTwo);
        BrowserUtils.sleepWithThread(2);
        Driver.getPage().locator("img").nth(2).hover();
        String objectThree = Driver.getPage().locator("//h5").nth(2).textContent();
        System.out.println("objectThree = " + objectThree);
        BrowserUtils.sleepWithThread(2);


    }

    @Test
    public void hoverTestWithLoop(){
            for(int i = 0; i <3; i++){
                Driver.getPage().locator("img").nth(i).hover();
                BrowserUtils.sleepWithThread(2);
                System.out.println("Driver.getPage().locator(\"h5\").first() = " + Driver.getPage().locator("h5").first().textContent());

            }
        }




}

