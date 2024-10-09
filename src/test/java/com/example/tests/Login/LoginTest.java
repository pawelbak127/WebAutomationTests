package com.example.tests.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Using WebDriverManager to automation management of WebDriver
        WebDriverManager.chromedriver().setup();

        // Starting browser
        driver = new ChromeDriver();
    }

    // Login function
    public void performLogin(String username, String password) {
        // Assignment id for username password and login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Entering a username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    @Test
    public void correctTestLogin( String login, String password) {

        performLogin("standard_user", "secret_sauce");
        // Checking if Login is success
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Logowanie nieudane.");    }
    @Test
    public void incorrecttestLogin() {

        performLogin("standard_user", "incorrect_pass");

        // Check if there was error message. If so, the test will be passed.
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }
    @AfterMethod
    public void tearDown() {
        // Closing Browser
        if (driver != null) {
            driver.quit();
        }
    }
}
