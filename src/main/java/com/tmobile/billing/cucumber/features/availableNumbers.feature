#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template

Feature: Search Available Number
	Available Numbers should be searched based on the area code provided.
  Area code should be with 03 digits only.
  Provide the List of Available Numbers.

Scenario: Search Available Numbers
Given Area code provided for Atlanta "404"
When Call Number Search Service to getAvailableNumbers
Then List of Available Numbers