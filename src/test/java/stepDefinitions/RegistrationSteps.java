package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Base;

import java.time.Duration;

public class RegistrationSteps extends Base {

    Faker faker = new Faker();
    WebDriver driver;

    @Given("the user is on the registration page")
    public void userOnRegistrationPage() {
        registerPage.clickLoginButton();
    }

    @When("the user clicks on the log in button")
    public void click_login_button() {
        registerPage.clickLoginButton();
    }

    @And("the user clicks on the sign up toggle")
    public void click_signup_toggle() {
        registerPage.clickSignupToggle();
    }

    @And("the user enters random registration details")
    public void enterRandomDetails() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8, 12,true, true, true) + "@";
        System.out.println(password);
        String confirmPassword = password;

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);

    }

    @And("the user selects the group name")
    public void select_group_name() {
        registerPage.dropDownMenuGroup();
    }

    @And("submits the registration form")
    public void submitForm() {
        registerPage.clickCreateAccountBTN();
    }

    @Then("the account should be created successfully")
    public void verifyAccountCreated() {
      registerPage.acceptAlert();
    }

    @And("the admin login page should be displayed")
    public void verifyAdminPage() {
        adminPage.verifyAdminPageisDisplayed();
    }

    @When("the admin enters valid email {string}")
    public void the_admin_enters_valid_email(String adminEmail) {
        adminPage.enterAdminEmail(adminEmail);
    }

    @And("the admin enters valid password {string}")
    public void the_admin_enters_valid_password(String adminPassword) {
        adminPage.enterAdminPassword(adminPassword);
    }

    @And("the admin clicks the login button")
    public void the_admin_clicks_login_button() {
        adminPage.clickLoginButton();
    }

    @Then("the admin should be redirected to the dashboard")
    public void admin_should_be_redirected_to_the_dashboard()
    {
        Assert.assertTrue(adminPage.isAdminDashboardDisplayed(), "Dashboard heading should be displayed after successful login");
    }

    @And("the admin should click the admin panel button")
    public void the_admin_should_click_the_admin_panel_button() {
        adminPage.clickAdminPanel();
    }


}
