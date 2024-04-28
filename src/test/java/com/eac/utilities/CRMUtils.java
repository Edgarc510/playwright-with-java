package com.eac.utilities;

import com.microsoft.playwright.Page;

public class CRMUtils {


    public static void login(Page page) {
        //String userName, String password
        ////input[@name='USER_LOGIN']
        //.login-inp

        page.locator("//input[@name='USER_LOGIN']").fill("marketing1@cydeo.com");
        page.getByPlaceholder("Password").fill("invalid");
    }

    public static void login(Page page,String username,String password) {
//"marketing1@cydeo.com"
        page.locator("//input[@name='USER_LOGIN']").fill(username);
        page.getByPlaceholder("Password").fill(password);
    }

}
