import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		
		//apk file, device , 47234
		
		//android driver
		File appdir = new File("src");
		File app= new File(appdir, "apk/path");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mydevice");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());	
		
		//UI Automator2
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		//Android driver
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		
		
		
		
	}

}
