Feature: Saksfifthavenue shoppingCart Functionality
  Background:
    Given Not a validated user
    When user borwse to the site
    Then saksfifthavenue home page display
    And user close pop up
    When User click Sign In link
    Then Browser display Sign In page

  Scenario: 1. Product Selection
    When User enter user email as "shoyel1516@gmail.com"
    And User enter user password as "Aasim0619!"
    And user click SIGN IN button
   Then user select activewear from Men Menu
    Then user choose lacoste
    #Then Verify the error message if user does not select color or size
    And user choose small size
    Then user click on add to bag


    Scenario: 2. Adding product to the cart
      When User enter user email as "shoyel1516@gmail.com"
      And User enter user password as "Aasim0619!"
      And user click SIGN IN button
      Then user select activewear from Men Menu
      Then user choose lacoste
    #Then Verify the error message if user does not select color or size
      And user choose small size
      Then user click on add to bag
      Then verify that user is in checkout page
      Then user should click on checkout
      When Verify whether user are able to add items to cart
      Then check for edit delet or save option
      Then shopping cart should contain price of the product