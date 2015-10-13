Meta:
@all
@Sample
@Login

Narrative:
In order to add and verify login feature
As a tester
I want to able to login as a egistered user
					 
Scenario: 2- Verify the user is able to login as a registered user

Given the user is in homepage
When the user clicks on signin button
And the user signs in with '<emailId>' and '<password>'
Then the user has signed in successfully
Examples:
General.table