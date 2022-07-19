@searchhotel
Feature: Verifying the Adactin Search Hotel Details

  Background: 
    Given User is on the adactin page
    When User should login "userName","password"
    Then User should verify after login "Hello ElavarasanJacob!"

  Scenario Outline: Verifying adactin search hotel by entering all valid details
    And User should select all fields and search "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    And User should verify after search "Select Hotel"

    Examples: 
      | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Paris    | Hotel Creek | Deluxe    | 1 - One         | 22/10/2022    | 23/10/2022     | 2 - Two         | 0 - None          |

  Scenario Outline: Verifying adactin search hotel by Select only manatory fields and verify select hotel
    And User should select only manatory fields and search "<Location>","<Number of Rooms>","<Check In Date>","<Check Out Date>"and"<Adults per Room>"
    And User should verify after search "Select Hotel"

    Examples: 
      | Location | Number of Rooms | Check In Date | Check Out Date | Adults per Room |
      | Paris    | 1 - One         | 22/10/2022    | 23/10/2022     | 2 - Two         |

  Scenario Outline: Verifying adactin search hotel by entering checkin date and incorrect checkout date
    And User should select all fields and search "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    And User should verify after search get date error message of "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Paris    | Hotel Creek | Deluxe    | 1 - One         | 22/10/2022    | 23/10/2021     | 2 - Two         | 0 - None          |

  Scenario: Verifying adactin search hotel without enter any fields click search
    And User should not select any fields and click search
    And User should verify after search get error message in search hotel page  "Please Select a Location"
