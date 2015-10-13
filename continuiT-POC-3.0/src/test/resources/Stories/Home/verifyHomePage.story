Meta:
@skip

Narrative:
In order to test the home page of a web application
As a tester
I want to be able to access its home page

				 
Scenario:  1- verify the user is able to reach the home page

Given the user is in homepage
Then the user waits for '2' seconds

Examples:
General.table

Scenario:  2-verify the user is able to reach the home page and validate the carousel

Given the user is in homepage
And the user sees the logo on the homepage
When the user clicks next button on the carousel
Then the user sees the carousel

Examples:
General.table

Scenario:  3-verify the user is able to reach the home page & validate the Navigation Table

Given the user is in homepage
And the user sees navigation table
When the user clicks on Active link in the Navigation table
Then the user is in Active page

Examples:
General.table


Scenario:  4- verify the user is able to log on to Adobe CEM Classic UI as an author

Given the user is in Adobe Pre-Prod author home page
Then the user waits for '2' seconds
When the user logs in as a Pre-Prod Author with '<userName>' and '<password>'
Then the user sees the Adobe AEM in Classic UI mode
Given the user is in Site Admin page
When the user selects Seven Seas
And the user selects English Malaysia
And the user selects Test Page
Then the user sees the Test Page in AEM content finder
Examples:
General.table

Scenario:  4-verify the user is able to reach the home page & validate Navigation Overlay

Given the user is in homepage
And the user sees menu on the top left corner of the homepage
When the user clicks to open menu
Then a navigation overlay appears
When the user clicks Active link in Navigation overlay
Then the user is in Active page

Examples:
General.table
