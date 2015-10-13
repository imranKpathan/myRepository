package com.dias.cucumber;

import java.io.IOException;

import org.junit.Assert;

import com.dias.pages.ResponseRulePage;
import com.dias.util.Util;

import net.thucydides.core.steps.ScenarioSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ResponseRuleSteps extends ScenarioSteps {
	HomeSteps homesteps;
	
	ResponseRulePage responseRulePage;
	
	@Given("^the user has created a new response rule for testing$")
	public void createNewResponseRule() throws Throwable {
		Util.pause(20);
		the_user_types_randomName_in_responseRulePage("fieldResponseRuleName");
		Util.pause(2);
		the_user_types_in_responseRulePage("Test Response Rule Description", "fieldResponseRuleDescription");
		Util.pause(2);
		the_user_types_in_for_Response_Rule_in_Response_Rule_Page("I AM SAFE","fieldResponseName", 1);
		Util.pause(2);
		the_user_selects_in_for_Response_Rule_in_Response_Rule_Page("6","dropDownVoicePrompt", 1);
		Util.pause(2);
		the_user_selects_in_for_Response_Rule_in_Response_Rule_Page("Starts with","dropDownResponsePatternList", 1);
		Util.pause(2);
		the_user_types_in_for_Response_Rule_in_Response_Rule_Page("SAFE","fieldResponsePatternList", 1);
		Util.pause(2);
		the_user_clicks_for_Response_Rule_in_Response_Rule_Page("linkColorPicker", 1);
		Util.pause(2);
		the_user_clicks_in_responseRulePage("linkSelectColorOne");
		Util.pause(2);
		the_user_clicks_in_responseRulePage("buttonSave");
		Util.pause(2);
	}
	
	
	@Then("^the user is in Response Rule page$")
	public void theUserIsInResponseRulePage() throws IOException {
		Util.pause(20);
	    assert (responseRulePage.verifyElementPresent("textResponseRule"));
	}

	@When("^the user types \"(.*?)\" in \"(.*?)\" in Response Rule Page$")
	public void the_user_types_in_responseRulePage(final String inputData, final String elementName) {
	    responseRulePage.typeDataInInputField(inputData, elementName);
	}
	
	@When("^the user types random data in \"(.*?)\" in Response Rule Page$")
	public void the_user_types_randomName_in_responseRulePage(final String elementName) {
		String inputData = "TestResponseRuleName" + Util.randomNumberGenerator();
	    responseRulePage.typeDataInInputField(inputData, elementName);
	    Util.setNameCurrentResponseRule(inputData);
	}

	@When("^the user clicks \"(.*?)\" in Response Rule Page$")
	public void the_user_clicks_in_responseRulePage(final String elementName) {
	    responseRulePage.clickElement(elementName);
	}

	@Then("^the user sees \"(.*?)\" in Response Rule Page$")
	public void the_user_sees_in_responseRulePage(final String elementName) {
		Util.pause(5);
	    assert (responseRulePage.verifyElementPresent(elementName));
	}

	@When("^the user types \"(.*?)\" in \"(.*?)\" for Response Rule (\\d+) in Response Rule Page$")
	public void the_user_types_in_for_Response_Rule_in_Response_Rule_Page(final String inputData, final String elementName, int ruleNumber) {
	    ruleNumber = ruleNumber - 1;
	    String rule = Integer.toString(ruleNumber);
	    responseRulePage.typeResponseRuleInformation(inputData, elementName, rule);
	}
	
	@When("^the user selects \"(.*?)\" from \"(.*?)\" for Response Rule (\\d+) in Response Rule Page$")
	public void the_user_selects_in_for_Response_Rule_in_Response_Rule_Page(String inputData, String elementName, int ruleNumber) {
		ruleNumber = ruleNumber - 1;
	    String elementNameBegin = elementName + "Begin";
	    String elementNameEnd = elementName + "End";
	    responseRulePage.selectResponseRuleInformationFromDropDown(inputData, elementNameBegin, elementNameEnd, Integer.toString(ruleNumber));
	}
	
	@Then("^the user sees that the spoken voice prompt for Response Rule (\\d+) is \"(.*?)\"$")
	public void the_user_sees_that_the_spoken_voice_prompt_for_Response_Rule_is(int ruleNumber, final String expectedData) {
	    String actualData = responseRulePage.getTextFromResponseRuleField(Integer.toString(ruleNumber - 1));
	    assert (expectedData.toLowerCase().contains(actualData.toLowerCase()));
	}
	
	@When("^the user clicks \"(.*?)\" for Response Rule (\\d+) in Response Rule Page$")
	public void the_user_clicks_for_Response_Rule_in_Response_Rule_Page(final String elementName, int ruleNumber) {
		responseRulePage.clickElementResponseRules(elementName, Integer.toString(ruleNumber - 1));
	}
	
	

}
