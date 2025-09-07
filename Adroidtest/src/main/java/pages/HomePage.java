package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    
    // Locators - These should be replaced with actual app locators
    private final By welcomeMessage = By.id("com.example.app:id/welcome_message");
    private final By profileButton = By.id("com.example.app:id/profile_button");
    private final By logoutButton = By.id("com.example.app:id/logout_button");
    private final By menuButton = By.id("com.example.app:id/menu_button");
    
    public boolean isWelcomeMessageDisplayed() {
        return isElementPresent(welcomeMessage);
    }
    
    public String getWelcomeMessage() {
        return getText(welcomeMessage);
    }
    
    public void clickProfileButton() {
        clickElement(profileButton);
    }
    
    public void clickLogoutButton() {
        clickElement(logoutButton);
    }
    
    public void clickMenuButton() {
        clickElement(menuButton);
    }
    
    public boolean isUserLoggedIn() {
        return isElementPresent(welcomeMessage);
    }
}