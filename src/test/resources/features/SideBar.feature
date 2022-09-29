Feature: Manage filtering of side bar

    Scenario: Filer side bar menu
      Given Client want to filter side bar menu using a name
      When He provides name
      Then side bar is filtered