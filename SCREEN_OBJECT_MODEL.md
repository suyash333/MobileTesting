# Screen Object Model Pattern Implementation

This project demonstrates the implementation of the Screen Object Model (SOM) pattern for mobile test automation using Appium and TestNG.

## Project Structure

```
src/
├── base.java                              # Main demo class showing SOM usage
├── testng.xml                            # TestNG suite configuration
└── com/mobiletesting/
    ├── driver/
    │   └── DriverManager.java            # Driver management and initialization
    ├── screens/
    │   ├── BaseScreen.java               # Abstract base class for all screens
    │   ├── LoginScreen.java              # Login screen object
    │   └── HomeScreen.java               # Home screen object
    └── tests/
        ├── LoginTest.java                # Login functionality tests
        └── HomeScreenTest.java           # Home screen functionality tests
```

## Screen Object Model Pattern

The Screen Object Model pattern is specifically designed for mobile applications and provides:

### 1. Separation of Concerns
- **Screen Objects**: Contain element locators and actions for specific screens
- **Test Classes**: Contain test logic and assertions
- **Driver Management**: Centralized driver initialization and management

### 2. Key Components

#### BaseScreen Class
- Abstract base class with common functionality for all screens
- Provides reusable methods for element interactions (click, enter text, wait, etc.)
- Ensures consistent behavior across all screen objects

#### Screen Classes (LoginScreen, HomeScreen)
- Extend BaseScreen to inherit common functionality
- Encapsulate screen-specific elements and actions
- Implement method chaining for fluent API
- Include screen verification methods

#### DriverManager Class
- Singleton pattern for driver management
- Centralized driver initialization and configuration
- Proper cleanup and resource management

### 3. Benefits

1. **Maintainability**: Changes to UI elements require updates in only one place
2. **Reusability**: Screen objects can be reused across multiple test classes
3. **Readability**: Tests are more readable and express business logic clearly
4. **Method Chaining**: Fluent API allows for expressive test code
5. **Encapsulation**: Screen logic is separated from test logic

## Usage Examples

### Basic Screen Object Usage
```java
// Initialize driver
AndroidDriver<AndroidElement> driver = DriverManager.getDriver();

// Create screen objects
LoginScreen loginScreen = new LoginScreen(driver);
HomeScreen homeScreen = loginScreen.login("user@example.com", "password");

// Verify screen state
Assert.assertTrue(homeScreen.isScreenLoaded());
```

### Method Chaining
```java
HomeScreen homeScreen = new LoginScreen(driver)
    .enterUsername("user@example.com")
    .enterPassword("password123")
    .clickLogin();
```

### Screen Verification
```java
// Each screen has an isScreenLoaded() method
if (loginScreen.isScreenLoaded()) {
    // Screen is properly loaded
}
```

## Running Tests

### Compile the project
```bash
mvn clean compile
```

### Run specific test class
```bash
mvn test -Dtest=LoginTest
```

### Run all tests using TestNG suite
```bash
mvn test -DsuiteXmlFile=src/testng.xml
```

## Configuration

The DriverManager class can be configured with custom capabilities:

```java
DesiredCapabilities customCaps = new DesiredCapabilities();
customCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "CustomDevice");
DriverManager.initializeDriver(customCaps);
```

## Best Practices Implemented

1. **Page Object Pattern**: Each screen is represented by a separate class
2. **DRY Principle**: Common functionality is abstracted to BaseScreen
3. **Single Responsibility**: Each class has a single, well-defined purpose
4. **Method Chaining**: Enables fluent and readable test code
5. **Proper Resource Management**: Driver is properly initialized and cleaned up
6. **Explicit Waits**: All element interactions use WebDriverWait for stability
7. **Exception Handling**: Graceful handling of element not found scenarios

## Future Enhancements

- Add more screen objects (ProfileScreen, SettingsScreen, etc.)
- Implement data-driven testing with TestNG DataProvider
- Add screenshot capture on test failures
- Implement parallel test execution
- Add reporting with Extent Reports or Allure
- Add mobile gestures support (swipe, scroll, etc.)