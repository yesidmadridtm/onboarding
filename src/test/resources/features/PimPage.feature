Feature: See records of employees in PIM page

  Scenario: Positive Test of filtering the employees by ID
    Given Client see the records of employees, He want filter these records by Id
    When He search an Id
    Then data has been filtered with this Id

  Scenario: Positive Test of filtering the employees by Employment Status
    Given Client see the records of employees, He want filter these records by Employment Status
    When He search an employee using an Employment Status
    Then data has been filtered with this Employment Status

   Scenario: Positive Test of filtering the employees by Include
      Given Client see the records of employees, He want filter these records by Include
      When He search an employee using an Include
      Then data has been filtered with this Include

   Scenario: Positive Test of filtering the employees by Job Title
      Given Client see the records of employees, He want filter these records by Job Title
      When He search an employee using an Job Title
      Then data has been filtered with this Job Title

   Scenario: Positive Test of filtering the employees by Sub Unit
      Given Client see the records of employees, He want filter these records by Sub Unit
      When He search an employee using an Sub Unit
      Then data has been filtered with this Sub Unit