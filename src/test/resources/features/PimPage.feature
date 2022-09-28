Feature: See records of employees in PIM page

  Scenario: Positive Test of filtering the employees by ID
    Given Client see the records of employees, He want filter these records by Id
    When He search an Id
    Then data has been filtered with this Id

  Scenario: Positive Test of filtering the employees by Employment Status
    Given Client see the records of employees, He want filter these records by Employment Status
    When He search an employee using an Employment Status
    Then data has been filtered with this Employment Status
