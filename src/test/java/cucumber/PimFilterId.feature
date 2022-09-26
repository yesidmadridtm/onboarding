@tag
Feature: Filter employees by Id

  @Regression
  Scenario Outline: Positive Test of filtering the employees

    Given Logged in with username <name> and password <password>
    When I write an id <id> in input Employee Id
    And click in Search
    Then data has been filtered with this id

    Examples:
      | name   |  password	 |	id  |
      | Admin  |  admin123   | 0011 |