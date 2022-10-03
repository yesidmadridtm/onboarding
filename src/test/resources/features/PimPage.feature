Feature: Manage employees in PIM page

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
  @run
  Scenario: add an employee in application
    Given Client want to add an new employee in the application
    When He go to registration form
    And He provides information about new employee
    Then the information is registered

  Scenario: edit an employee in application
    Given Client want to edit name of an employee in the application
    When He search an employee using his Id
    And He go to form of update
    And He provides new name of employee
    Then the name is updated

  Scenario: delete an employee in application
    Given Client want to delete an employee in the application
    When He search an employee in list using his Id
    And He go to action of delete
    Then the employee has been deleted
  