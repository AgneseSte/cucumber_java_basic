#Task 1
#In Task1.feature create 1 scenario outline and 1 scenario for page with url: "https://kristinek.github.io/site/tasks/enter_a_number"
#
#Scenario outline for error cases:
#enter number too small
#enter number too big
#enter text instead of the number
#Scenario for correct number
Feature: create 1 scenario outline and 1 scenario for page with url: "https://kristinek.github.io/site/tasks/enter_a_number"

  Background:
    Given I am on a number page

  @errorMessages
  Scenario Outline: a new scenario outline for error cases
    When I enter number: "<input>"
    And I click submit number
    Then I see an error message: "<message>"
    @numberTooSmall
    Examples:
      | input | message             |
      | 7     | Number is too small |
    @NumberTooBig
    Examples:
      | input | message           |
      | 101   | Number is too big |
    @numberIsText
    Examples:
      | input | message               |
      | text  | Please enter a number |


  Scenario:
    When I enter number: "64"
    And I click submit number
    Then I see a pop-up message: "Square root of 64 is 8.00"
