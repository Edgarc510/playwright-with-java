package com.eac.pages;

import com.eac.utilities.Driver;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LibraryLoginPage {
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator signInButton;

    public LibraryLoginPage() {
        this.emailInput = Driver.getPage().locator("#inputEmail");
        this.passwordInput = Driver.getPage().locator("#inputPassword");
        this.signInButton = Driver.getPage().locator("//button[contains(text(),'Sign in')]");
    }


    public void login(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        signInButton.click();

    }

}
