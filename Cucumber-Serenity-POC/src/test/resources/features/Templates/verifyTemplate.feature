@all
@Templates
@verifyTemplates

Feature: Create a New Template
  
  In order verify the New Template features
  As an tester
  I want to be able to create New Templates

  Background: verify the user added a response rule
    Given the user is on Whisper homepage
    When the user types "dummyuser" in "fieldUserName" in homepage
    And the user types "1236548" in "fieldPassword" in homepage
    And the user clicks "buttonSignIn" in homepage
    Then the user sees "Subject" in homepage
    Given the user is navigates to New Response Rule page
   	And the user has created a new response rule for testing
  
  Scenario: verify the user is able to create New Templates
    When the user clicks "linkMyCompany" in homepage
    And the user clicks "linkNewTemplate" in homepage
    Then the user is in template page
	When the user types "Test Template" in "fieldTemplateName" in New Template Page
	And the user types "Test Template Description" in "fieldTemplateDescription" in New Template Page
    And the user selects latest response rule from "dropdownFilterResponseTemplate" in New Template Page
    When the user clicks "buttonSave" in New Template Page
    Then the user sees "textTemplateList" in New Template Page
    
  
    
    
