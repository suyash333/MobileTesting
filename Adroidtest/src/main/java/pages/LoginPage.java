package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    
    // Locators - These should be replaced with actual app locators
    private final By usernameField = By.id("com.example.app:id/username");
    private final By passwordField = By.id("com.example.app:id/password");
    private final By loginButton = By.id("com.example.app:id/login_button");
    private final By errorMessage = By.id("com.example.app:id/error_message");
    
    public void enterUsername(String username) {
        sendText(usernameField, username);
    }
    
    public void enterPassword(String password) {
        sendText(passwordField, password);
    }
    
    public void clickLoginButton() {
        clickElement(loginButton);
    }
    
    public boolean isErrorMessageDisplayed() {
        return isElementPresent(errorMessage);
    }
    
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}