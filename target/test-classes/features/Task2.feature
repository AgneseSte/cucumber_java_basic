#Task 2
#In Task2.feature create 1 scenario outline and create scenario or scenario outlines for page
# https://kristinek.github.io/site/tasks/list_of_people.html or
# https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html in order to test that user can:
#
#add a new person
#edit a person
#remove a person
#reset original list after:
#adding a person
#editing a person
#removing a person
#check that clear button on adding a user works correctly

Feature: Modifying person list and clear input fields
  As a test engineer
  I want to be able to add, edit and delete person from the list of people and clear input fields

  Background:
    Given I am on list_of_people_with_jobs page

  Scenario Outline: adding a new person
    When I save existing list
    And I click Add person
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click Add
    Then I check the list of people has been changed
    And reset to the the original list
    Examples:
      | name  | job |
      | Ann   | Judge   |

  Scenario Outline: editing a person
    When I save existing list
    When I click to edit person
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click Edit
    Then I check the list of people has been changed
    And reset to the the original list
    Examples:
      | name  | job |
      | Kate   | Teacher  |

  Scenario: deleting a person
    When I save existing list
    When I click to delete person
    Then I check the list of people has been changed
    And reset to the the original list

  Scenario Outline: resetting input on adding a person
    When I click Add person
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click Clear all fields
    Then I check input fields are empty
    Examples:
      | name  | job |
      | Bill   | Welder   |