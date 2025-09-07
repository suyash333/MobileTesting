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
 * HomeScreenTest class demonstrating the usage of Screen Object Model pattern
 * This class contains test cases for home screen functionality
 */
public class HomeScreenTest {
    
    private AndroidDriver<AndroidElement> driver;
    private HomeScreen homeScreen;
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = DriverManager.getDriver();
        
        // Navigate to home screen by logging in first
        LoginScreen loginScreen = new LoginScreen(driver);
        homeScreen = loginScreen.login("testuser@example.com", "password123");
    }
    
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    /**
     * Test home screen loading
     */
    @Test
    public void testHomeScreenLoading() {
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should be loaded properly");
        Assert.assertTrue(homeScreen.isUserLoggedIn(), "User should be logged in on home screen");
    }
    
    /**
     * Test welcome message display
     */
    @Test
    public void testWelcomeMessage() {
        String welcomeMessage = homeScreen.getWelcomeMessage();
        Assert.assertFalse(welcomeMessage.isEmpty(), "Welcome message should not be empty");
        Assert.assertTrue(welcomeMessage.toLowerCase().contains("welcome"), 
                         "Welcome message should contain 'welcome' text");
    }
    
    /**
     * Test search functionality
     */
    @Test
    public void testSearchFunctionality() {
        String searchText = "test search";
        homeScreen.performSearch(searchText);
        
        // In a real implementation, we would verify search results
        // For now, we verify the screen remains stable after search
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should remain loaded after search");
    }
    
    /**
     * Test menu functionality
     */
    @Test
    public void testMenuFunctionality() {
        homeScreen.clickMenu();
        
        // In a real implementation, we would verify menu is opened
        // For now, we verify the click action doesn't break the screen
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should remain stable after clicking menu");
    }
    
    /**
     * Test notification functionality
     */
    @Test
    public void testNotificationFunctionality() {
        homeScreen.clickNotifications();
        
        // In a real implementation, we would verify navigation to notifications
        // For now, we verify the screen remains stable
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should remain stable after clicking notifications");
    }
    
    /**
     * Test logout functionality
     */
    @Test
    public void testLogoutFunctionality() {
        LoginScreen loginScreen = homeScreen.clickLogout();
        
        // Verify user is navigated back to login screen
        Assert.assertTrue(loginScreen.isScreenLoaded(), "User should be navigated to login screen after logout");
    }
    
    /**
     * Test settings functionality
     */
    @Test
    public void testSettingsFunctionality() {
        homeScreen.clickSettings();
        
        // In a real implementation, we would verify navigation to settings
        // For now, we verify the screen remains stable
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should remain stable after clicking settings");
    }
    
    /**
     * Test user profile functionality
     */
    @Test
    public void testUserProfileFunctionality() {
        homeScreen.clickUserProfile();
        
        // In a real implementation, we would verify navigation to profile screen
        // For now, we verify the screen remains stable
        Assert.assertTrue(homeScreen.isScreenLoaded(), "Home screen should remain stable after clicking user profile");
    }
}