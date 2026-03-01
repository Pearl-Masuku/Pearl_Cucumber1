Feature: User Registration

  Scenario: Register a new user with random data
    Given the user is on the registration page
    When the user clicks on the log in button
    And the user clicks on the sign up toggle
    And the user enters random registration details
    And the user selects the group name
    And submits the registration form
    Then the account should be created successfully
