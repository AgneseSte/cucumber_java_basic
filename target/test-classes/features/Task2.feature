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

Feature: Modifying person list
  As a test engineer
  I want to be able to add, edit and delete person from the list of people

  Background:
    Given I am on list_of_people page