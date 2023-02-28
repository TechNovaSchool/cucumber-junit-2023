Feature: Airtable API Tests

@api
  Scenario: Verify status code for get endpoint
    When user call a GET endpoint
    Then user will receive status "200"


