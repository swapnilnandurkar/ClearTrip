Feature: Search round trip flight

  Background: User is on ClearTrip home page
    Given User navigate to the home page
 
  Scenario: Search Round trip from Pune to Delhi
    Given user select a Round trip
     When user enters From and To locations
      And user selects Depart on and Return on date
      And user selects number of Adults, children and infants
      And search a flight
     Then user should able to see flights details along with fares
