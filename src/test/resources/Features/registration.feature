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

    Examples:
      | adminEmail         | adminPassword  |
      | admin@gmail.com    | @12345678      |
