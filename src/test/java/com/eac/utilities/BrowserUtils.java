package com.eac.utilities;

import com.microsoft.playwright.Page;

public class BrowserUtils {

    public static void sleepWithThread(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

    }

    public static void sleepWithPage(Page page,int seconds){
        page.waitForTimeout(seconds*1000);
    }


}
