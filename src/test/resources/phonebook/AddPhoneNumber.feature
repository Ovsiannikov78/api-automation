Feature: Add Phone Number

  Background:
    Given I have access token

  @api @add_phone_number
  Scenario: Add new phone number

    When I make POST request for the endpoint 'phone'
    Then I see status code 200


  @api @get_phone
  Scenario: Get phone number

    When I make POST request for the endpoint 'phone'
    Then I see status code 200

    When I make GET request for the endpoint 'phone'
    Then I see status code 200
    #Then I see valid phone number
