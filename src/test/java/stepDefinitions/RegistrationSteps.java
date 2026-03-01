package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import utils.Base;

import java.time.Duration;

public class RegistrationSteps extends Base {

    Faker faker = new Faker();

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
}
