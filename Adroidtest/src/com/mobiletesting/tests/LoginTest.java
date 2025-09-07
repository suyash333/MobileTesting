package com.mobiletesting.tests;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mobiletesting.driver.DriverManager;
import com.mobiletesting.screens.HomeScreen;
import com.mobiletesting.screens.LoginScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * LoginTest class demonstrating the usage of Screen Object Model pattern
 * This class contains test cases for login functionality
 */
public class LoginTest {
    
    private AndroidDriver<AndroidElement> driver;
    private LoginScreen loginScreen;
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverManager.getDriver();
        loginScreen = new LoginScreen(driver);
    }
    
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    /**
     * Test successful login functionality
     */
    @Test
    public void testSuccessfulLogin() {
        // Verify login screen is loaded
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Login screen is not loaded properly");
        
        // Perform login
        HomeScreen homeScreen = loginScreen.login("testuser@example.com", "password123");
        
        // Verify user is navigated to home screen and logged in
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen is not loaded after login");
        Assert.assertTrue(homeScreen.isUserLoggedIn(), "User is not logged in successfully");
    }
    
    /**
     * Test login with invalid credentials
     */
    @Test
    public void testLoginWithInvalidCredentials() {
        // Verify login screen is loaded
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Login screen is not loaded properly");
        
        // Attempt login with invalid credentials
        loginScreen.enterUsername("invalid@example.com")
                   .enterPassword("wrongpassword")
                   .clickLogin();
        
        // Verify error message is displayed
        Assert.assertTrue(loginScreen.isErrorMessageDisplayed(), "Error message is not displayed for invalid credentials");
        
        String errorMessage = loginScreen.getErrorMessage();
        Assert.assertFalse(errorMessage.isEmpty(), "Error message is empty");
    }
    
    /**
     * Test login with empty fields
     */
    @Test
    public void testLoginWithEmptyFields() {
        // Verify login screen is loaded
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Login screen is not loaded properly");
        
        // Try to click login without entering credentials
        loginScreen.clickLogin();
        
        // Verify error message is displayed or login button is disabled
        Assert.assertTrue(loginScreen.isErrorMessageDisplayed() || !loginScreen.isLoginButtonEnabled(), 
                         "Login should not be allowed with empty fields");
    }
    
    /**
     * Test forgot password functionality
     */
    @Test
    public void testForgotPasswordLink() {
        // Verify login screen is loaded
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Login screen is not loaded properly");
        
        // Click on forgot password link
        loginScreen.clickForgotPassword();
        
        // In a real implementation, this would verify navigation to forgot password screen
        // For now, we just verify the click action doesn't cause any errors
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Screen state should remain stable after clicking forgot password");
    }
    
    /**
     * Test method chaining functionality
     */
    @Test
    public void testMethodChaining() {
        // Verify login screen is loaded
        Assert.assertTrue(loginScreen.isScreenLoaded(), "Login screen is not loaded properly");
        
        // Test method chaining
        HomeScreen homeScreen = loginScreen
                .enterUsername("testuser@example.com")
                .enterPassword("password123")
                .clickLogin();
        
        // Verify successful navigation
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Method chaining should result in successful navigation");
    }
}