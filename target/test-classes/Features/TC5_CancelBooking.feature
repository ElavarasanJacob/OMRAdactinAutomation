@cancelBooking
Feature: Verifying the Adactin Hotel Cancel Booking Details

  Background: 
    Given User is on the adactin page
    When User should login "userName","password"
    Then User should verify after login "Hello ElavarasanJacob!"

  Scenario Outline: Verifying adactin hotel booking cancellation details
    And User should select all fields and search "<Location>","<Hotels>","<Room Type>","<Number of Rooms>","<Check In Date>","<Check Out Date>","<Adults per Room>"and"<Children per Room>"
    And User should verify after search "Select Hotel"
    And User should select hotel
    And User should verify after select hotel in book a hotel page "Book A Hotel"
    And User should fill all fields "<FirstName>","<LastName>"and"<BillingAddress>"
      | CreditCardNo     | CreditCardType   | ExpiryMonth | Expiry Year | CVVNumber |
      | 1234567890123456 | American Express | October     |        2022 |       123 |
      | 1234567890122134 | VISA             | November    |        2022 |       324 |
      | 1234567890123455 | Master Card      | December    |        2022 |       456 |
      | 1234567890123477 | Other            | September   |        2022 |       677 |
    Then User should verify after booking on booking confirmation page "Booking Confirmation"
    And User should cancel the orderId
    And User should verify cancel message on Booked Itinerary page  "The booking has been cancelled."

    Examples: 
      | Location | Hotels      | Room Type | Number of Rooms | Check In Date | Check Out Date | Adults per Room | Children per Room | FirstName  | LastName | BillingAddress  |
      | Paris    | Hotel Creek | Deluxe    | 1 - One         | 22/10/2022    | 23/10/2022     | 2 - Two         | 0 - None          | Elavarasan | s        | Chennai  601206 |

  Scenario Outline: Verifying adactin hotel by cancelling booked orderId
    And User should cancel the booked orderid "<orderId>"
    And User should verify cancel message on Booked Itinerary page  "The booking has been cancelled."

    Examples: 
      | orderId    |
      | 7E97CCM92P |
