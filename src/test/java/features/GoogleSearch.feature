Feature: Google Search
  As a user i would like to visit www.google.com and to perform a web search

  Background: I am on google page
    Given a user is on google web page

  @Run
  Scenario: Google Search
  Perform google search...

    Given I read test data from "TestData" "Data1" "TC001"
    When a user types in hello in search filed
    And presses search button
    Then search result page should be shown

  @Google
  Scenario Outline: Google Search
  Perform google search...

    Given I read test data from "TestData" "Data1" "<id>"
    Given I add "<value>" to "<key>"
    When a user types in "<pozdrav>" in search filed
    And presses search button
    Then search result page should be shown "<pozdrav>"

    @Smoke @Regression
    Examples:
      | pozdrav | id    | value | key |
      | cao     | TC001 |       |     |

    @Regression
    Examples:
      | pozdrav | id    | value | key  |
      | hello   | TC002 |       |      |
      | hi      | TC003 |       |      |
      | hi      | TC001 | test  | test |