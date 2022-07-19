@login
Feature: Verifying the Adactin Hotel Login Details

  Background: 
    Given User is on the adactin page

  Scenario Outline: Verifying Adactin login details with valid credentials
    When User should login "<userName>","<password>"
    Then User should verify after login "Hello ElavarasanJacob!"

    Examples: 
      | userName | password |
      | userName | password |

  Scenario Outline: Verifying Adactin login details with valid credentials with Enter Key
    When User should login "<userName>","<password>" with Enter key
    Then User should verify after login "Hello ElavarasanJacob!"

    Examples: 
      | userName | password |
      | userName | password |

  Scenario Outline: Verifying Adactin login details with Invalid credentials
    When User should login "<userName>","<password>"
    Then User should verify after login error message  "Invalid Login details or Your Password might have expired"

    Examples: 
      | userName | password      |
      | userName | wrongPassword |
