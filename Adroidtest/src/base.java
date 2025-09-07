import java.net.MalformedURLException;

import com.mobiletesting.driver.DriverManager;
import com.mobiletesting.screens.HomeScreen;
import com.mobiletesting.screens.LoginScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Main class demonstrating the Screen Object Model pattern usage
 * This class shows how to use the restructured mobile test automation framework
 */
public class base {

	public static void main(String[] args) throws MalformedURLException {
		// Initialize the driver using DriverManager
		AndroidDriver<AndroidElement> driver = DriverManager.getDriver();
		
		try {
			// Create LoginScreen instance
			LoginScreen loginScreen = new LoginScreen(driver);
			
			// Verify login screen is loaded
			if (loginScreen.isScreenLoaded()) {
				System.out.println("Login screen loaded successfully");
				
				// Perform login using Screen Object Model
				HomeScreen homeScreen = loginScreen.login("testuser@example.com", "password123");
				
				// Verify home screen is loaded
				if (homeScreen.isScreenLoaded()) {
					System.out.println("Successfully navigated to home screen");
					System.out.println("Welcome message: " + homeScreen.getWelcomeMessage());
					
					// Perform some actions on home screen
					homeScreen.performSearch("test search");
					homeScreen.clickNotifications();
					
					// Logout
					LoginScreen backToLogin = homeScreen.clickLogout();
					if (backToLogin.isScreenLoaded()) {
						System.out.println("Successfully logged out and returned to login screen");
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error occurred during execution: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Always quit the driver
			DriverManager.quitDriver();
			System.out.println("Driver quit successfully");
		}
	}
}
