package com.janitri.qa.tests;

import com.janitri.qa.base.BaseTest;
import com.janitri.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testElementsVisible() {
        Assert.assertTrue(loginPage.isEyeIconVisible(), "Eye icon should be visible");
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked initially");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        loginPage.enterUserId("invalid@example.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isErrorMessageVisible(), "Should show error for invalid login");
    }

    @Test
    public void testLoginButtonEnabledEvenWhenFieldsAreEmpty() {
        loginPage.clearFields();
        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Login button should remain enabled even with empty fields");
    }

    @Test
    public void testPasswordMaskedButton() {
        Assert.assertTrue(loginPage.isPasswordMasked(), "Password should be masked initially");
        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.isPasswordMasked(), "Password should be visible after toggle");
    }
}
