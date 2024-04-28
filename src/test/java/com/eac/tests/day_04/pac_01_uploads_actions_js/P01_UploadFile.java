package com.eac.tests.day_04.pac_01_uploads_actions_js;

import com.eac.utilities.BrowserUtils;
import com.eac.utilities.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class P01_UploadFile {
    //https://playwright.dev/docs/input#upload-files
    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/upload");

    }
    @AfterEach
    void tearDown(){
        BrowserUtils.sleepWithThread(7);
        Driver.closeDriver();
    }

    @Test
    public void test01() {
        //src/test/resources/uploadTest.txt
        String pathOfFile = System.getProperty("user.dir") + "/src/test/resources/uploadTest.txt";
        //below is one way
//        Driver.getPage().getByTestId("file-upload").setInputFiles(Paths.get(pathOfFile));
        //below is one way
        Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(pathOfFile));

         /*
        for multiple files
        Driver.getPage().getByLabel("Upload files").setInputFiles(new Path[] {Paths.get("pathOfFirstFile"), Paths.get
        ("pathOfSecondFile")});

         */
        BrowserUtils.sleepWithThread(3);

        //if you want to delete uploaded file go on with below line
        // Driver.getPage().getByTestId("file-upload").setInputFiles(new Path[0]);


        Driver.getPage().getByTestId("file-submit").click();

        //css
//        Driver.getPage().locator("h3");
        //xpath
        String actualText = Driver.getPage().locator("//h3").textContent();
        System.out.println("actualText = " + actualText);


    }


}
