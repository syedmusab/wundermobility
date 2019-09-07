Feature: Backend Automation
  Background: As an automation engineer, I would like to automate process of create and delete employee

  @backend
  Scenario: Create an employee, validate if this employee was created correctly and then delete the employee
    Given Creating endpoint to add employee
    When request has been processed
    Then validating if this employee is created correctly
    Then delete request has been sent and verified