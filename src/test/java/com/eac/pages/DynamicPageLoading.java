package com.eac.pages;

import com.eac.utilities.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;

@Getter
public class DynamicPageLoading {

    private final Locator alertMessage;

    public DynamicPageLoading() {
        this.alertMessage = Driver.getPage().getByTestId("alert");
    }
}
