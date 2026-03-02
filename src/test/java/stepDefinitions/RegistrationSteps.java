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
    public static String newlyRegisteredEmail;

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
        newlyRegisteredEmail = faker.internet().emailAddress();
        String password = faker.internet().password(8, 12,true, true, true) + "@";
        System.out.println(password);
        String confirmPassword = password;

        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(newlyRegisteredEmail);
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

    @And("the admin should see the admin panel page")
    public void the_admin_should_see_the_admin_panel_page()
    {
        Assert.assertTrue(adminPanelPage.verifyAdminPanelPageisDisplayed(), "Admin Panel heading should be displayed");
    }

    @And("the admin should click the approval button")
    public void the_admin_should_click_the_approval_button() {
        adminPanelPage.clickApprovalButton();
    }

    @Then("the admin should be redirected to the user approval page")
    public void admin_should_be_redirected_to_the_approval_page()
    {
        Assert.assertTrue(adminPanelPage.verifyApprovalPanelPageisDisplayed(), "User  Panel heading should be displayed");
    }

    @And("the admin searches for the newly registered user")
    public void adminSearchesForUser()
    {
        adminPanelPage.searchUserByEmail(RegistrationSteps.newlyRegisteredEmail);
    }

    @And("the admin approves the user registration")
    public void the_admin_approves_the_user_registration()
    {
        adminPanelPage.clickUserApprovalButton();
    }

    @Then("the user should be approved successfully")
    public void user_should_be_approved_successfully()
    {
        Assert.assertTrue(adminPanelPage.verifyApprovalConfirmation(), "Expected approval confirmation message to be displayed");
    }

    @And("the admin should click the users button")
    public void the_admin_should_click_the_users_button() {
        userManagementPage.clickUsersButton();
    }

    @And("the admin should see the list of users")
    public void the_admin_should_see_the_list_of_users()
    {
        Assert.assertTrue(userManagementPage.verifyUserManagementIsDisplayed(), "User management heading should be displayed");
    }

    @And("the admin searches for the approved user")
    public void adminSearchesApprovedUser()
    {
        userManagementPage.searchApprovedUserByEmail(RegistrationSteps.newlyRegisteredEmail);
    }

    @And("the admin updates the user role to admin")
    public void update_user_role_to_admin() {
        userManagementPage.selectUserRole();
    }

    @Then("the user role should be updated successfully")
    public void user_role_should_be_updated_successfully() {
        userManagementPage.handleMultipleAlerts(2);
    }

    @And("the admin should click the back to website button")
    public void the_admin_should_click_back_to_website_button() {
        userManagementPage.clickBackToWebsiteButton();
    }

    @Then("the admin should be redirected to the home page")
    public void admin_should_be_redirected_to_the_home_page()
    {
        Assert.assertTrue(adminPage.isAdminDashboardDisplayed(), "Expected to land on Admin Dashboard after updating user role");
    }

    @And("the admin should click the logout button")
    public void the_admin_should_click_the_logout_button()
    {
        adminPage.clickAdminLogout();
    }

    @Then("the admin should logout successfully")
    public void confirm_logout_successfully()
    {
        adminPage.acceptLogoutAlert();
    }

    @Then("the admin should be redirected to the main home page")
    public void verify_main_homePage_isDisplayed()
    {
        Assert.assertTrue(adminPage.isMainHomePageDisplayed(), "Expected to land on main home page after logout");
    }


}
