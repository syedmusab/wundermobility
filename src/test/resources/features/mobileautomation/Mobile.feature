Feature: Mobile Automation
  Background: As an Automation Engineer, I  would like to automate process of adding contact in ContactManager.apk

  @appium
  Scenario Outline: Add a contact to phone
    Given I open the application
    When I tab on addContactButton
    When I enter "<contactname>" and "<contactnumber>"
    Then I tab to save button
    Examples:
      | contactname     | contactnumber |
      | Wunder Mobility | 12345678      |


  @appium
  Scenario: Show Invisible Contact List
    Given I open the application
    When I check on show invisible contact
    Then I can see invisible contact list


