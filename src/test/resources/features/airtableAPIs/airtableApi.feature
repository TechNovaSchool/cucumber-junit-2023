Feature: Airtable API Tests

@api
  Scenario: Verify status code for get endpoint
    When user call a GET endpoint
    Then user will receive status "200"

  Scenario: Verify status code for get a single record endpoint
    When user call a GET single endpoint
    Then user will receive status "200"
    And user verify the first name


