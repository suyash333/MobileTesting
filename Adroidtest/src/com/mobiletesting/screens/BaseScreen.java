package com.mobiletesting.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * BaseScreen class containing common functionality for all screen objects
 */
public abstract class BaseScreen {
    
    protected AndroidDriver<AndroidElement> driver;
    protected WebDriverWait wait;
    
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    
    /**
     * Wait for element to be visible
     * @param locator Element locator
     * @return AndroidElement
     */
    protected AndroidElement waitForElement(By locator) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be clickable
     * @param locator Element locator
     * @return AndroidElement
     */
    protected AndroidElement waitForElementToBeClickable(By locator) {
        return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Click on element
     * @param locator Element locator
     */
    protected void clickElement(By locator) {
        waitForElementToBeClickable(locator).click();
    }
    
    /**
     * Enter text in element
     * @param locator Element locator
     * @param text Text to enter
     */
    protected void enterText(By locator, String text) {
        AndroidElement element = waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Get text from element
     * @param locator Element locator
     * @return Element text
     */
    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }
    
    /**
     * Check if element is displayed
     * @param locator Element locator
     * @return true if element is displayed, false otherwise
     */
    protected boolean isElementDisplayed(By locator) {
        try {
            return waitForElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Wait for element to disappear
     * @param locator Element locator
     * @return true if element disappears, false otherwise
     */
    protected boolean waitForElementToDisappear(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    /**
     * Abstract method to verify screen is loaded
     * Each screen should implement this method to verify if the screen is properly loaded
     */
    public abstract boolean isScreenLoaded();
}