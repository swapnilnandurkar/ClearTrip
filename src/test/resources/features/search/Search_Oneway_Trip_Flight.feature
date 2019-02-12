Feature: Search one way flight

  Background: User is on ClearTrip home page
    Given User navigate to the home page
  
  Scenario: Search One way trip from Pune to Delhi
    Given user select a One way trip
     When user enters From and To location
      And user selects Depart on date
      And user selects number of Adults, children and infants
      And search a flight 
     Then user should able to see flights details along with fares
