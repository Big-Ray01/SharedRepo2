Feature: Practical Test

  Scenario Outline: Login using the My Account menu item
  and Order Bottle of Beyerskloof Pinotage 2019 wine
    Given I am on "<Website>" home page using"<Browser>"
    When I click My account enter "<Username>" and "<Password>"
    Then I click login button
    And I click Shop from the menu items
    And I search for "<BottleName>"
    Then I select Bottle
    And I place order
    Examples:
      | Browser | Username         | Password   | Website     | BottleName                     |
      | Chrome  | testteamtechtest | Ryz3T3st!x | TestWebsite | Beyerskloof Pinotage 2019 wine |