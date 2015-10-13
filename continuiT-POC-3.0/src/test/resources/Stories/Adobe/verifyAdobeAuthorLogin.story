Meta:
@skip


Narrative:
In order to Perform authoring functions on Adobe CEM
As an Author
I want to be able to log on to Adobe CEM perform authoring functions

				 
Scenario:  1- verify the user is able to log on to Adobe CEM as an author and Add Benefit Icons to Test Page

Given the user is in Adobe Pre-Prod author home page
Then the user waits for '2' seconds
When the user logs in as a Pre-Prod Author with '<userName>' and '<password>'
Then the user is logged on to the AEM-Touch UI
When the user logs clicks Sites link in the left hand side column
Then the user sees the sites page
When the user clicks Classic UI Icon in Sites
When the user selects Seven Seas
And the user selects English Malaysia
And the user selects Test Page

Then the user sees the Test Page in AEM content finder
And the user sees the AEM Sidekick

When the user adds the benefit icons to the container

Then the user sees the Benefit Icons section
When the user selects to edit the component
Then the user sees the Edit Component window

When the user enters data in the Asterisk field '<testInput>'
And the user selects plus button to add more components in Edit Component Window
And the user searches to add Benefit Icons in Edit Component Window
Then the user sees the Select Path window
When the user selects the path of the image
And the user enters data in the Headline field '<testHeadlineInput>'
And the user click OK button to close Edit Component window
And the user Page button in AEM Sidekick
And the user selects Activate Page link in AEM Sidekick

Examples:
General.table