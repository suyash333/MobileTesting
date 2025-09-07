package com.mobiletesting.screens;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * HomeScreen class representing the home screen of the mobile application
 * This demonstrates the Screen Object Model pattern implementation
 */
public class HomeScreen extends BaseScreen {
    
    // Locators for home screen elements
    private By welcomeMessage = By.id("welcome_message");
    private By userProfile = By.id("user_profile");
    private By menuButton = By.id("menu_button");
    private By logoutButton = By.id("logout_button");
    private By searchField = By.id("search_field");
    private By notificationIcon = By.id("notification_icon");
    private By settingsIcon = By.id("settings_icon");
    private By homeTitle = By.id("home_title");
    
    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    
    /**
     * Get welcome message text
     * @return Welcome message text
     */
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }
    
    /**
     * Click on user profile
     * @return ProfileScreen instance
     */
    public HomeScreen clickUserProfile() {
        clickElement(userProfile);
        // In a real implementation, this might return a ProfileScreen
        return this;
    }
    
    /**
     * Click on menu button
     * @return MenuScreen instance or same HomeScreen if menu is a drawer
     */
    public HomeScreen clickMenu() {
        clickElement(menuButton);
        return this;
    }
    
    /**
     * Click on logout button
     * @return LoginScreen instance
     */
    public LoginScreen clickLogout() {
        clickElement(logoutButton);
        return new LoginScreen(driver);
    }
    
    /**
     * Perform search
     * @param searchText Text to search for
     * @return HomeScreen instance
     */
    public HomeScreen performSearch(String searchText) {
        enterText(searchField, searchText);
        return this;
    }
    
    /**
     * Click on notification icon
     * @return NotificationScreen instance
     */
    public HomeScreen clickNotifications() {
        clickElement(notificationIcon);
        // In a real implementation, this might return a NotificationScreen
        return this;
    }
    
    /**
     * Click on settings icon
     * @return SettingsScreen instance
     */
    public HomeScreen clickSettings() {
        clickElement(settingsIcon);
        // In a real implementation, this might return a SettingsScreen
        return this;
    }
    
    /**
     * Check if user is logged in by verifying welcome message is displayed
     * @return true if user is logged in, false otherwise
     */
    public boolean isUserLoggedIn() {
        return isElementDisplayed(welcomeMessage);
    }
    
    /**
     * Check if notification icon has badge (indicating new notifications)
     * @return true if notification badge is present, false otherwise
     */
    public boolean hasNewNotifications() {
        By notificationBadge = By.id("notification_badge");
        return isElementDisplayed(notificationBadge);
    }
    
    @Override
    public boolean isScreenLoaded() {
        return isElementDisplayed(homeTitle) && 
               isElementDisplayed(welcomeMessage) && 
               isElementDisplayed(menuButton);
    }
}