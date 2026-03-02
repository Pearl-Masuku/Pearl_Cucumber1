Feature: User Registration

  Scenario Outline: Register a new user with random data
    Given the user is on the registration page
    When the user clicks on the log in button
    And the user clicks on the sign up toggle
    And the user enters random registration details
    And the user selects the group name
    And submits the registration form
    Then the account should be created successfully
    And the admin login page should be displayed
    When the admin enters valid email "<adminEmail>"
    And the admin enters valid password "<adminPassword>"
    And the admin clicks the login button
    Then the admin should be redirected to the dashboard
    And the admin should click the admin panel button
    And the admin should see the admin panel page
    And the admin should click the approval button
    Then the admin should be redirected to the user approval page
    And the admin searches for the newly registered user
    And the admin approves the user registration
    Then the user should be approved successfully
    And the admin should click the users button
    Then the admin should see the list of users
    And the admin searches for the approved user
    And the admin updates the user role to admin
    Then the user role should be updated successfully
    And the admin should click the back to website button
    Then the admin should be redirected to the home page
    And the admin should click the logout button
    Then the admin should logout successfully
    And the admin should be redirected to the main home page
    And the new admin should be able to log in with the updated credentials
    And the new admin should be redirected to the login page
    And the new admin should enter new credentials and click login button
    Then the new admin should be redirected to the dashboard
#    And the new admin should click the login button
#    Then the new admin should be redirected to the admin dashboard



    Examples:
      | adminEmail         | adminPassword  |
      | admin@gmail.com    | @12345678      |
