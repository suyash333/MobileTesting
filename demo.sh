#!/bin/bash

# Mobile Testing Demo Script
# This script demonstrates how to use the new POM and BDD structure

echo "=== Mobile Testing Project Demo ==="
echo ""

echo "1. Project Structure:"
echo "===================="
find Adroidtest/src -type f -name "*.java" -o -name "*.feature" | sort
echo ""

echo "2. Building the project:"
echo "========================"
cd Adroidtest
mvn clean compile test-compile
echo ""

echo "3. Available test execution options:"
echo "===================================="
echo "a) Run all Cucumber tests:"
echo "   mvn test"
echo ""
echo "b) Run tests using TestNG XML:"
echo "   mvn test -DsuiteXmlFile=testng.xml"
echo ""
echo "c) Run with dry-run to validate scenarios:"
echo "   mvn test -Dcucumber.options='--dry-run'"
echo ""

echo "4. Page Object Model Structure:"
echo "==============================="
echo "- DriverManager: Handles Appium driver lifecycle"
echo "- BasePage: Common page functionality"
echo "- LoginPage: Login screen interactions"
echo "- HomePage: Home screen interactions"
echo ""

echo "5. BDD Structure:"
echo "=================="
echo "- Feature files: src/test/resources/features/"
echo "- Step definitions: src/test/java/steps/"
echo "- Test runner: src/test/java/runners/"
echo ""

echo "6. Sample BDD Scenario:"
echo "======================="
cat src/test/resources/features/login.feature | head -15
echo ""

echo "Setup complete! The project now supports:"
echo "- Page Object Model pattern"
echo "- Behavior Driven Development with Cucumber"
echo "- Thread-safe driver management"
echo "- Comprehensive reporting"