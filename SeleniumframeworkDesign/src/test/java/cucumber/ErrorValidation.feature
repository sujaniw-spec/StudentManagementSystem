
@tag
Feature: Error Validation
  I want to use this template for my feature file

 Background:
  Given user landed on Ecommerce Page
  
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    When user Logged in with username <name> and password <password>
    Then the "Incorrect email or password." is displayed

    Examples: 
      | name              | password          |
      | sujaniw@yahoo.com | MyLokupusa123#@ee | 

