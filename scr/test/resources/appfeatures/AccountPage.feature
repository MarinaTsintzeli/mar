Feature: Account Page Featyre

  Background: 
    Given user has already logged in the application
      | username                     | password      |
      | dec2020secondbatch@gmail.com | Selenium@12345 |
	
	@p1
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | Order history and details |
      | My credit slips           |
      | My addresses              |
      | My personal information   |
      | My wishlists              |
    And accounts section count sould be 5

