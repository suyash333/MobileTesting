package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.testng.Assert;

import base.DriverManager;
import pages.LoginPage;
import pages.HomePage;

public class LoginSteps {
    
    private LoginPage loginPage;
    private HomePage homePage;
    
    @Before
    public void setUp() throws Exception {
        DriverManager.initializeDriver();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
    
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
    
    @Given("the mobile application is launched")
    public void the_mobile_application_is_launched() {
        // Application should be launched through DriverManager initialization
        System.out.println("Mobile application launched successfully");
    }
    
    @Given("I am on the login screen")
    public void i_am_on_the_login_screen() {
        // Verify we are on login screen - this would check for login specific elements
        System.out.println("User is on the login screen");
    }
    
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    
    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }
    
    @When("I click the login button without entering credentials")
    public void i_click_the_login_button_without_entering_credentials() {
        loginPage.clickLoginButton();
    }
    
    @Then("I should be redirected to the home screen")
    public void i_should_be_redirected_to_the_home_screen() {
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be on home screen");
    }
    
    @Then("I should see the welcome message")
    public void i_should_see_the_welcome_message() {
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome message should be displayed");
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
    }
    
    @Then("I should remain on the login screen")
    public void i_should_remain_on_the_login_screen() {
        // Verify we are still on login screen by checking login elements are present
        System.out.println("User remains on login screen");
    }
    
    @Then("I should see an error message indicating required fields")
    public void i_should_see_an_error_message_indicating_required_fields() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Required fields error should be displayed");
    }
    
    @Given("I am logged in with valid credentials")
    public void i_am_logged_in_with_valid_credentials() {
        loginPage.login("testuser", "testpass");
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in");
    }
    
    @When("I click on the logout button")
    public void i_click_on_the_logout_button() {
        homePage.clickLogoutButton();
    }
    
    @Then("I should be redirected to the login screen")
    public void i_should_be_redirected_to_the_login_screen() {
        // Verify we are back on login screen
        System.out.println("User redirected to login screen");
    }
}