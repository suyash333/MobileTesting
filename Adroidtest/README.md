# Mobile Testing with Page Object Model and BDD

This project demonstrates mobile app testing using Appium with Page Object Model (POM) architecture and Behavior Driven Development (BDD) approach using Cucumber.

## Project Structure

```
src/
├── main/java/
│   ├── base/
│   │   └── DriverManager.java          # Driver initialization and management
│   └── pages/
│       ├── BasePage.java               # Base page with common functionalities
│       ├── LoginPage.java              # Login page object
│       └── HomePage.java               # Home page object
└── test/
    ├── java/
    │   ├── runners/
    │   │   └── TestRunner.java          # Cucumber TestNG runner
    │   └── steps/
    │       └── LoginSteps.java          # Step definitions for BDD scenarios
    └── resources/
        └── features/
            └── login.feature            # BDD feature file with scenarios
```

## Dependencies

- **Appium Java Client 7.5.1** - Mobile automation
- **Selenium 3.141.59** - WebDriver framework
- **TestNG 7.4.0** - Test execution framework
- **Cucumber 7.14.0** - BDD framework

## Page Object Model Pattern

The project follows POM pattern with:

1. **DriverManager**: Handles driver initialization, management, and cleanup
2. **BasePage**: Contains common methods for element interactions
3. **Page Classes**: Specific page objects that extend BasePage

## BDD Implementation

- **Feature Files**: Written in Gherkin syntax (`.feature` files)
- **Step Definitions**: Java classes that implement the steps
- **Test Runner**: Executes Cucumber scenarios using TestNG

## Running Tests

### Prerequisites
1. Appium server should be running on `http://127.0.0.1:4723/wd/hub`
2. Android device/emulator should be connected
3. Update the app path in `DriverManager.java`

### Build the project
```bash
mvn clean compile test-compile
```

### Run tests using TestNG
```bash
mvn test
```

### Run tests using the XML suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Configuration

### Update App Configuration
Modify `src/main/java/base/DriverManager.java`:
- Update the app path
- Configure device capabilities
- Adjust timeouts as needed

### Add New Page Objects
1. Create new page class extending `BasePage`
2. Define locators and page-specific methods
3. Use the page object in step definitions

### Add New Test Scenarios
1. Write scenarios in `.feature` files
2. Implement corresponding step definitions
3. Update the test runner if needed

## Sample Test Scenario

```gherkin
Feature: Login Functionality
  Scenario: Successful login with valid credentials
    Given I am on the login screen
    When I enter username "testuser" and password "testpass"
    And I click the login button
    Then I should be redirected to the home screen
    And I should see the welcome message
```

## Reports

Cucumber generates reports in multiple formats:
- HTML: `target/cucumber-reports/index.html`
- JSON: `target/cucumber-reports/Cucumber.json`
- JUnit: `target/cucumber-reports/Cucumber.xml`