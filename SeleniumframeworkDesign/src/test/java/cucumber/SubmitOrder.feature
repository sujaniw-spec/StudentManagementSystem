@tag
Feature: Purchase the order from ECommerce website
  I want to use this template for my feature file
  
  Background:
  Given user landed on Ecommerce Page

  @Regression
  Scenario Outline:Positive Test of Submitting the order
    Given user Logged in with username <name> and password <password>
    When user adds product <productName> to Cart
    And user checkouts <productName> and submit the order
    Then the "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name              | password          | productName |
      | sujaniw@yahoo.com | MyLokupusa123#@   | ZARA COAT 3 |
