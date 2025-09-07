package com.mobiletesting.screens;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * LoginScreen class representing the login screen of the mobile application
 * This demonstrates the Screen Object Model pattern implementation
 */
public class LoginScreen extends BaseScreen {
    
    // Locators for login screen elements
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login_button");
    private By forgotPasswordLink = By.id("forgot_password");
    private By signUpLink = By.id("sign_up");
    private By errorMessage = By.id("error_message");
    private By loginTitle = By.id("login_title");
    
    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    
    /**
     * Enter username in the username field
     * @param username Username to enter
     * @return LoginScreen instance for method chaining
     */
    public LoginScreen enterUsername(String username) {
        enterText(usernameField, username);
        return this;
    }
    
    /**
     * Enter password in the password field
     * @param password Password to enter
     * @return LoginScreen instance for method chaining
     */
    public LoginScreen enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }
    
    /**
     * Click on the login button
     * @return HomeScreen instance (assuming successful login navigates to home)
     */
    public HomeScreen clickLogin() {
        clickElement(loginButton);
        return new HomeScreen(driver);
    }
    
    /**
     * Click on forgot password link
     * @return ForgotPasswordScreen instance
     */
    public LoginScreen clickForgotPassword() {
        clickElement(forgotPasswordLink);
        // In a real implementation, this might return a ForgotPasswordScreen
        return this;
    }
    
    /**
     * Click on sign up link
     * @return SignUpScreen instance
     */
    public LoginScreen clickSignUp() {
        clickElement(signUpLink);
        // In a real implementation, this might return a SignUpScreen
        return this;
    }
    
    /**
     * Perform complete login with username and password
     * @param username Username
     * @param password Password
     * @return HomeScreen instance
     */
    public HomeScreen login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return clickLogin();
    }
    
    /**
     * Get error message text
     * @return Error message text
     */
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    /**
     * Check if error message is displayed
     * @return true if error message is displayed, false otherwise
     */
    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }
    
    /**
     * Check if login button is enabled
     * @return true if login button is enabled, false otherwise
     */
    public boolean isLoginButtonEnabled() {
        return waitForElement(loginButton).isEnabled();
    }
    
    @Override
    public boolean isScreenLoaded() {
        return isElementDisplayed(loginTitle) && 
               isElementDisplayed(usernameField) && 
               isElementDisplayed(passwordField) && 
               isElementDisplayed(loginButton);
    }
}