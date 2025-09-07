package com.mobiletesting.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * DriverManager class to handle AndroidDriver initialization and management
 */
public class DriverManager {
    
    private static AndroidDriver<AndroidElement> driver;
    
    /**
     * Initialize AndroidDriver with default capabilities
     * @return AndroidDriver instance
     * @throws MalformedURLException
     */
    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
    
    /**
     * Initialize driver with default capabilities
     * @throws MalformedURLException
     */
    private static void initializeDriver() throws MalformedURLException {
        File appdir = new File("src");
        File app = new File(appdir, "apk/path");
        
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mydevice");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }
    
    /**
     * Initialize driver with custom capabilities
     * @param capabilities Custom DesiredCapabilities
     * @throws MalformedURLException
     */
    public static void initializeDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    
    /**
     * Quit the driver and set it to null
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}