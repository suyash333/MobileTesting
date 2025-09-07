# MobileTesting

Mobile App Testing Framework with Screen Object Model Pattern

## Overview

This project demonstrates a mobile test automation framework implementing the Screen Object Model (SOM) pattern using Appium, Selenium, and TestNG.

## Features

- **Screen Object Model Pattern**: Clean separation of screen elements and test logic
- **Appium Integration**: Mobile test automation for Android applications
- **TestNG Support**: Comprehensive testing framework with annotations and assertions
- **Method Chaining**: Fluent API for readable and maintainable test code
- **Driver Management**: Centralized AndroidDriver initialization and cleanup
- **Explicit Waits**: Robust element handling with WebDriverWait

## Quick Start

1. **Build the project**:
   ```bash
   cd Adroidtest
   mvn clean compile
   ```

2. **Run tests**:
   ```bash
   mvn test -DsuiteXmlFile=src/testng.xml
   ```

3. **Run demo**:
   ```bash
   java -cp target/classes base
   ```

## Documentation

For detailed information about the Screen Object Model implementation, see [SCREEN_OBJECT_MODEL.md](SCREEN_OBJECT_MODEL.md).

## Project Structure

```
Adroidtest/
├── src/
│   ├── base.java                          # Demo class showing SOM usage
│   ├── testng.xml                         # TestNG suite configuration
│   └── com/mobiletesting/
│       ├── driver/
│       │   └── DriverManager.java         # Driver management
│       ├── screens/
│       │   ├── BaseScreen.java            # Base screen class
│       │   ├── LoginScreen.java           # Login screen object
│       │   └── HomeScreen.java            # Home screen object
│       └── tests/
│           ├── LoginTest.java             # Login tests
│           └── HomeScreenTest.java        # Home screen tests
└── pom.xml                                # Maven configuration
```

## Dependencies

- Appium Java Client 7.5.1
- Selenium Java 3.141.59
- TestNG 7.4.0 
