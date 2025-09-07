package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverManager {
    
    private static ThreadLocal<AndroidDriver<AndroidElement>> driver = new ThreadLocal<>();
    
    public static void initializeDriver() throws MalformedURLException {
        if (driver.get() == null) {
            //apk file, device configuration
            File appdir = new File("src");
            File app = new File(appdir, "apk/path");
            
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mydevice");
            cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());	
            
            //UI Automator2
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            
            //Android driver
            AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(
                new URL("http://127.0.0.1:4723/wd/hub"), cap);
            
            // Set implicit wait
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            driver.set(androidDriver);
        }
    }
    
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.get();
    }
    
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}