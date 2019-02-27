Feature: Yandex mailbox

  Background:
   Given I am logged into yandex mail

  @logout
  Scenario: Sending a new email
    When I send a new email
    Then I should see the new email in 'Sent' folder

  @logout
  Scenario Outline: Creating a new folder
    When I create a new folder <folderName>
    Then I should see a new folder in the list of folders

    Examples:
     |folderName|
     |TestFolder|
     |JustFolder|

  @logout
  Scenario Outline: Finding a email
    When I find the email by keyword <keyword>
    Then I should see this email is opened

    Examples:
      |keyword|
      |struggle|
      |less|

