package com.janitri.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By userIdField = By.id("formEmail");
    private By passwordField = By.id("formPassword");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By eyeIcon = By.xpath("//img[@alt='Password Not Visible' or @alt=' Password Visible']");
    private By errorMsg = By.xpath("//p[contains(text(),'Invalid Credentials')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdField).clear();
        driver.findElement(userIdField).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clearFields() {
        driver.findElement(userIdField).clear();
        driver.findElement(passwordField).clear();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public boolean isEyeIconVisible() {
        try {
            return driver.findElement(eyeIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordMasked() {
        String type = driver.findElement(passwordField).getAttribute("type");
        return type.equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public boolean isErrorMessageVisible() {
        try {
            return wait.until(driver -> {
                List<WebElement> errors = driver.findElements(errorMsg);
                for (WebElement e : errors) {
                    if (e.isDisplayed()) return true;
                }
                return false;
            });
        } catch (TimeoutException e) {
            return false;
        }
    }
}
