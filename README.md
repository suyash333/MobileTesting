# MobileTesting

A comprehensive mobile application testing framework built with Java, Appium, and Selenium WebDriver for automated Android app testing.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Dependencies](#dependencies)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)

## Overview

This project provides a robust framework for automated mobile application testing, specifically targeting Android applications. It utilizes:

- **Appium** for mobile automation
- **Selenium WebDriver** for browser automation capabilities
- **TestNG** for test organization and execution
- **Maven** for dependency management and build automation
- **UIAutomator2** as the automation engine for Android

## Prerequisites

Before setting up this project, ensure you have the following installed:

### Required Software

1. **Java Development Kit (JDK) 15 or higher**
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/)
   - Verify installation: `java -version`

2. **Apache Maven 3.6+**
   - Download from [Maven Official Site](https://maven.apache.org/download.cgi)
   - Verify installation: `mvn -version`

3. **Android SDK**
   - Install [Android Studio](https://developer.android.com/studio) or Android SDK Command Line Tools
   - Set `ANDROID_HOME` environment variable
   - Add `platform-tools` and `tools` to your PATH

4. **Appium Server**
   - Install globally: `npm install -g appium`
   - Install UIAutomator2 driver: `appium driver install uiautomator2`
   - Verify installation: `appium --version`

5. **Node.js and NPM** (for Appium)
   - Download from [Node.js Official Site](https://nodejs.org/)
   - Verify installation: `node --version` and `npm --version`

### Optional Tools

- **Appium Desktop/Inspector** for element inspection
- **Android Emulator** or physical Android device for testing
- **IDE** such as IntelliJ IDEA or Eclipse

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/suyash333/MobileTesting.git
   cd MobileTesting
   ```

2. **Navigate to the project directory:**
   ```bash
   cd Adroidtest
   ```

3. **Install Maven dependencies:**
   ```bash
   mvn clean install
   ```

4. **Start Appium Server:**
   ```bash
   appium --base-path /wd/hub
   ```
   The server will start on `http://127.0.0.1:4723/wd/hub` by default.

## Project Structure

```
MobileTesting/
├── README.md                 # Project documentation
└── Adroidtest/              # Main Android testing module
    ├── pom.xml              # Maven configuration file
    ├── src/                 # Source code directory
    │   └── base.java        # Base class for Android driver setup
    └── target/              # Compiled classes and build artifacts
```

### Key Files

- **`pom.xml`**: Contains project configuration and dependencies
- **`src/base.java`**: Main class that sets up Android driver with Appium capabilities
- **`README.md`**: This documentation file

## Configuration

### Android Driver Configuration

The `base.java` file contains the core configuration for Android testing:

```java
// Device and app configuration
DesiredCapabilities cap = new DesiredCapabilities();
cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Mydevice");
cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
```

### Customizing Configuration

To customize the configuration for your testing needs:

1. **Device Name**: Update `DEVICE_NAME` capability with your device/emulator name
2. **App Path**: Place your APK file in the appropriate directory and update the path
3. **Platform Version**: Add `PLATFORM_VERSION` capability if needed
4. **Additional Capabilities**: Add more capabilities as required for your testing scenario

### Environment Variables

Set the following environment variables:

```bash
export ANDROID_HOME=/path/to/android/sdk
export PATH=$PATH:$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools
```

## Dependencies

This project uses the following key dependencies:

| Dependency | Version | Purpose |
|------------|---------|---------|
| [Appium Java Client](https://github.com/appium/java-client) | 7.5.1 | Mobile automation library |
| [Selenium WebDriver](https://selenium.dev/) | 3.141.59 | Web browser automation |
| [TestNG](https://testng.org/) | 7.4.0 | Testing framework |

### Version Compatibility

- **Java**: 15+
- **Appium Server**: 1.22.0+ (recommended)
- **Android API Level**: 16+ (Android 4.1+)

## Usage

### Basic Setup

1. **Prepare your Android app:**
   - Place your APK file in the `src/apk/` directory
   - Update the app path in `base.java`

2. **Configure device:**
   - Connect your Android device via USB with Developer Options enabled
   - Or start an Android emulator
   - Verify device connectivity: `adb devices`

3. **Update configuration:**
   ```java
   // In base.java, update these lines:
   File app = new File(appdir, "apk/your-app.apk");
   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "YourDeviceName");
   ```

### Sample Test Execution

```java
public class base {
    public static void main(String[] args) throws MalformedURLException {
        // Setup Android driver
        File appdir = new File("src");
        File app = new File(appdir, "apk/your-app.apk");
        
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "YourDevice");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        
        // Initialize driver
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(
            new URL("http://127.0.0.1:4723/wd/hub"), cap
        );
        
        // Your test logic here
        
        // Clean up
        driver.quit();
    }
}
```

## Running Tests

### Prerequisites for Test Execution

1. **Start Appium Server:**
   ```bash
   appium --base-path /wd/hub
   ```

2. **Ensure device/emulator is connected:**
   ```bash
   adb devices
   ```

### Compile and Run

1. **Compile the project:**
   ```bash
   mvn compile
   ```

2. **Run the main class:**
   ```bash
   mvn exec:java -Dexec.mainClass="base"
   ```

### Alternative Execution Methods

- **Using IDE**: Import the project into your preferred IDE and run the `base.java` class
- **Command Line**: Navigate to the compiled classes and run with `java base`

## Troubleshooting

### Common Issues and Solutions

1. **Appium Server Connection Failed**
   ```
   Error: Could not connect to Appium server
   ```
   - **Solution**: Ensure Appium server is running on `http://127.0.0.1:4723/wd/hub`
   - **Check**: Run `appium doctor` to verify installation

2. **Device Not Found**
   ```
   Error: Device not found
   ```
   - **Solution**: Verify device connection with `adb devices`
   - **Check**: Enable Developer Options and USB Debugging on Android device

3. **APK File Not Found**
   ```
   Error: App file not found
   ```
   - **Solution**: Verify the APK file path in `base.java`
   - **Check**: Ensure the APK file exists in the specified directory

4. **Java Version Incompatibility**
   ```
   Error: Unsupported class file major version
   ```
   - **Solution**: Ensure you're using Java 15 or higher
   - **Check**: Run `java -version` and `mvn -version`

5. **Maven Dependencies Not Resolved**
   ```
   Error: Package does not exist
   ```
   - **Solution**: Run `mvn clean install` to download dependencies
   - **Check**: Verify internet connection and Maven configuration

### Debug Mode

To run in debug mode:
```bash
appium --base-path /wd/hub --log-level debug
```

### Logs and Debugging

- **Appium Logs**: Check Appium server console for detailed logs
- **Device Logs**: Use `adb logcat` for Android device logs
- **Java Logs**: Add logging statements in your test code for debugging

## Contributing

We welcome contributions to improve this mobile testing framework!

### How to Contribute

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b feature/your-feature-name`
3. **Make your changes** and ensure they follow the coding standards
4. **Test your changes** thoroughly
5. **Commit your changes**: `git commit -m "Add your meaningful commit message"`
6. **Push to your branch**: `git push origin feature/your-feature-name`
7. **Create a Pull Request**

### Coding Standards

- Follow Java naming conventions
- Add appropriate comments and documentation
- Ensure code is properly formatted
- Include error handling where necessary

### Reporting Issues

If you encounter any issues or have suggestions for improvements:

1. Check existing issues to avoid duplicates
2. Create a new issue with:
   - Clear description of the problem
   - Steps to reproduce
   - Expected vs actual behavior
   - Environment details (OS, Java version, etc.)

---

**Note**: This project is set up for Android testing. For iOS testing, additional setup and configuration would be required.

For more information about Appium capabilities and advanced configuration options, refer to the [Appium Documentation](http://appium.io/docs/en/about-appium/intro/).
