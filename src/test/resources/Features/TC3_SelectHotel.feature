@selectHotel
Feature: Verifying the Adactin Select Hotel Details

  Background: 
    Given User is on the adactin page
    When User should login "userName","password"
    Then User should verify after login "Hello ElavarasanJacob!"

  Scenario Outline: Verifying adactin select hotel page with select hotel
    And User should select all fields and search "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    And User should verify after search "Select Hotel"
    And User should select hotel
    And User should verify after select hotel in book a hotel page "Book A Hotel"

    Examples: 
      | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Paris    | Hotel Creek | Deluxe    | 1 - One         | 22/10/2022    | 23/10/2022     | 2 - Two         | 0 - None          |

  Scenario Outline: Verifying adactin select hotel page without select hotel
    And User should select all fields and search "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    And User should verify after search "Select Hotel"
    And User should click continue without selecting any hotel
    And User should verify without select hotel get error message on select a hotel page "Please Select a Hotel"

     Examples: 
      | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room |
      | Paris    | Hotel Creek | Deluxe    | 1 - One         | 22/10/2022    | 23/10/2022     | 2 - Two         | 0 - None          |
