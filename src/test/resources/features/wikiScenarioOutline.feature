@wikiOutline
Feature: Wikipedia search functionality

  Scenario Outline: Wikipedia search functionality
    Given user click on wikipedia page
    When User type "<name>" in the wiki search box
    And User click search button
    Then User see "<name>" in the wiki page title
    #option+cmd+l
#    alt+ctrl+l

    Examples:
      | name        |
      | Ruby Tandoh |
      | Johnny Depp |
      | Steve Jobs  |