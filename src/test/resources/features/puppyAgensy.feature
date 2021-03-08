@PuppyAdoptionAgency

Feature: Puppy Adoption Agency functions Tests

  @PAA1
  Scenario: Validate Adopt a Puppy olen Pappy List
    Given I open "PAA" page
    When I click on "Adopt a Puppy"
    And I validate "Puppy List" present

  @PAA2
  Scenario: Validate More Details button working
    Given I open "PAA" page
    When I click More Details button for "Hanna"
    And I validate "Hanna" details page opens

  @PAA3
  Scenario: Validate Adopt me button proses to next page
    Given I open "PAA" page
    When I click More Details button for "Brook"
    And I click Adopt Me! button
    Then I validate I add "Brook" to my cart

  @PAA4
  Scenario Outline: Make a payment for your selection
    Given I open "PAA" page
    When I click More Details button for "Brook"
    And I click Adopt Me! button
    And I click "Complete the Adoption" button in my cart
    Then I fill out "<name>" name, "<address>" address, "<email>" email, "<payment>" payment
    And I verify message "Thank you for adopting a puppy!" is present
    Examples:
      | name      | address                            | email          | payment        |
      | John Do   | 123 Main st Chicago IL 60601       | john@gmail.com | Credit card    |
      | Vil Smith | 324 Michigan ave New York NY 62830 | vil@yahoo.com  | Purchase order |
      | Vil Smith | 324 Michigan ave New York NY 62830 | vil@yahoo.com  | Check          |
      | John Do   | 123 Main st Chicago IL 60601       | john@gmail.com | Credit card    |