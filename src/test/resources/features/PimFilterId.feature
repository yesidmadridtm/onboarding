Feature: Filter employees by Id

  Scenario: Positive Test of filtering the employees

    Given Client see the records of employees, He want filter these records by Id
    When He search an Id
    Then data has been filtered with this Id
