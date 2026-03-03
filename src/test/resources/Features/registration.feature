Feature: User Registration and Admin Flow

  Background: Given the user is on the registration page

# Scenario 1: User registers
Scenario: Register a new user with random data
  When the user clicks on the log in button
  And the user clicks on the sign up toggle
  And the user enters random registration details
  And the user selects the group name
  And submits the registration form
  Then the account should be created successfully
  And the admin login page should be displayed

  # Scenario 2: Admin approves user
  Scenario Outline: Admin approves newly registered user
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

    Examples:
      | adminEmail      | adminPassword |
      | admin@gmail.com | @12345678 |

      # Scenario 3: Admin updates user role
      Scenario: Admin updates user role to Admin
        And the admin should click the users button
        Then the admin should see the list of users
        And the admin searches for the approved user
        And the admin updates the user role to admin
        Then the user role should be updated successfully
        And the admin should click the back to website button
        Then the admin should be redirected to the home page

        # Scenario 4: Admin logs out
        Scenario: Admin logs out
          And the admin should click the logout button
          Then the admin should logout successfully
          And the admin should be redirected to the main home page

          # Scenario 5: Newly updated user logs in as Admin
          Scenario: Newly updated user logs in as Admin
            And the new admin should be able to log in with the updated credentials
            And the new admin should be redirected to the login page
            And the new admin should enter new credentials and click login button
            Then the new admin should be redirected to the dashboard

            # Scenario 6: New admin accesses instructor panel and logs out
            Scenario: New admin accesses instructor panel
              And the new admin should click the instructor panel button
              And the new admin should be redirected to the instructor dashboard
              And the new admin should click the back to website button
              And the new admin should be redirected back to the instructor dashboard
              And the new admin should click the logout button
              Then the new admin should logout successfully
