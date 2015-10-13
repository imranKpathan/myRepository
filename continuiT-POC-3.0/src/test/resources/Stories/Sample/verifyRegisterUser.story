Meta:
@all
@Sample
@RegisterUser

Narrative:
In order to add and verify my new address
As a tester
I want to able to add and verify new adress in address page

 				 
Scenario: 1- Verify a registered user is able to add new address in address page
!-- GivenStories: src\test\resources\Stories\Sample\verifyLogin.story

Given the user is in homepage
When the user clicks on my account link
And the user clicks on manage address book
And the user types data in all the fields
And the user clicks on save and continue
Then the user verify the save address in address book
Then the user deletes the newly added address in address book
Examples:
General.table
