Feature: User Registration

  Scenario: Register a new user with random data
    Given the user is on the registration page
    When the user enters random registration details
    And submits the registration form
    Then the account should be created successfully
