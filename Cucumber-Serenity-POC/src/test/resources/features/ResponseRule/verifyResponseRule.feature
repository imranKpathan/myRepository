@all
@ResponseRule
@verifyResponseRule

Feature: Create a response rule
  
  In order verify the Response Rules
  As an tester
  I want to be able to create different Response Rules

  Background: verify the user has signed in
    Given the user is on Whisper homepage
    When the user types "dummyuser" in "fieldUserName" in homepage
    And the user types "1236548" in "fieldPassword" in homepage
    And the user clicks "buttonSignIn" in homepage
    Then the user sees "Subject" in homepage
  
  Scenario: verify the user is able to create multiple response rules
    
    When the user clicks "linkMyCompany" in homepage
    And the user clicks "linkMore" in homepage
    And the user clicks "linkNewResponseRule" in homepage
    Then the user is in Response Rule page
	When the user types random data in "fieldResponseRuleName" in Response Rule Page
	And the user types "Test Response Rule Description" in "fieldResponseRuleDescription" in Response Rule Page
	
	#Adding the first response rule
    When the user types "I AM SAFE" in "fieldResponseName" for Response Rule 1 in Response Rule Page
    And the user selects "6" from "dropDownVoicePrompt" for Response Rule 1 in Response Rule Page
    Then the user sees that the spoken voice prompt for Response Rule 1 is "to select I AM SAFE"
    When the user selects "Starts with" from "dropDownResponsePatternList" for Response Rule 1 in Response Rule Page
	And the user types "SAFE" in "fieldResponsePatternList" for Response Rule 1 in Response Rule Page
	And the user clicks "linkColorPicker" for Response Rule 1 in Response Rule Page
	And the user clicks "linkSelectColorOne" in Response Rule Page
	And the user clicks "linkAddAnotherResponseRule" in Response Rule Page
	
	#Adding the second response rule
    When the user types "NOT SAFE" in "fieldResponseName" for Response Rule 2 in Response Rule Page
    And the user selects "2" from "dropDownVoicePrompt" for Response Rule 2 in Response Rule Page
    Then the user sees that the spoken voice prompt for Response Rule 2 is "to select NOT SAFE"
    When the user selects "Starts with" from "dropDownResponsePatternList" for Response Rule 2 in Response Rule Page
	And the user types "NOT SAFE" in "fieldResponsePatternList" for Response Rule 2 in Response Rule Page
	And the user clicks "linkColorPicker" for Response Rule 2 in Response Rule Page
	And the user clicks "linkSelectColorTwo" in Response Rule Page
	And the user clicks "linkAddAnotherResponseRule" in Response Rule Page
	
	#Adding the third response rule
    When the user types "NONE" in "fieldResponseName" for Response Rule 3 in Response Rule Page
    And the user selects "6" from "dropDownVoicePrompt" for Response Rule 3 in Response Rule Page
    Then the user sees that the spoken voice prompt for Response Rule 3 is "to select NONE"
    When the user selects "Starts with" from "dropDownResponsePatternList" for Response Rule 3 in Response Rule Page
	And the user types "NONE" in "fieldResponsePatternList" for Response Rule 3 in Response Rule Page
	And the user clicks "linkColorPicker" for Response Rule 3 in Response Rule Page
	And the user clicks "linkSelectColorThree" in Response Rule Page
	
	#Save And Validate
	When the user clicks "buttonSave" in Response Rule Page
    Then the user sees "textResponseRuleList" in Response Rule Page
    
    
