Feature: Login Functionality
  As a mobile app user
  I want to be able to login to the application
  So that I can access my account features

  Background:
    Given the mobile application is launched

  Scenario: Successful login with valid credentials
    Given I am on the login screen
    When I enter username "testuser" and password "testpass"
    And I click the login button
    Then I should be redirected to the home screen
    And I should see the welcome message

  Scenario: Login with invalid credentials
    Given I am on the login screen
    When I enter username "invaliduser" and password "wrongpass"
    And I click the login button
    Then I should see an error message
    And I should remain on the login screen

  Scenario: Login with empty fields
    Given I am on the login screen
    When I click the login button without entering credentials
    Then I should see an error message indicating required fields

  Scenario: Logout functionality
    Given I am logged in with valid credentials
    When I click on the logout button
    Then I should be redirected to the login screen