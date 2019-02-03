Feature: Search Flight

  Background: User is on ClearTrip home page
    Given User navigate to the login page
  
  Scenario: Search One way trip from Pune to Delhi
    Given user select a One way trip
     When user enters From and To location
      And user selects Depart on date
      And user selects number of Adults, children and infants
      And search a flight 
     Then user should able to see flights details along with fares
  
  Scenario: Search Round trip from Pune to Delhi
    Given user select a Round trip
     When user enters From and To location
      And user selects Depart on and Return on date
      And user selects number of Adults, children and infants
      And search a flight
     Then user should able to see flights details along with fares
