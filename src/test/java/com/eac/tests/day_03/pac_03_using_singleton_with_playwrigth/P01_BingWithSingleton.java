package com.eac.tests.day_03.pac_03_using_singleton_with_playwrigth;

import com.eac.utilities.BrowserFactory;
import com.eac.utilities.BrowserUtils;
import com.eac.utilities.ConfigurationReader;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.Test;

public class P01_BingWithSingleton {

    @Test
    public void bing_search_1() {

        Driver.getPage().navigate(ConfigurationReader.getProperty("bingURL"));
//        Driver.getPage().getByTestId("bnp_btn_accept").click();
        Driver.getPage().getByTestId("sb_form_q").fill("playwright");
        Driver.getPage().getByTestId("sb_form_q").press("Enter");
        BrowserUtils.sleepWithThread(3);

        Driver.closeDriver();

    }


}
