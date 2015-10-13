package com.dias.cucumber;

import java.io.IOException;

import org.junit.Assert;

import com.dias.pages.NewTemplatePage;
import com.dias.util.Util;

import net.thucydides.core.steps.ScenarioSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewTemplateSteps extends ScenarioSteps {
	NewTemplatePage newTemplatePage;
	
	@Then("^the user is in template page$")
	public void theUserIsInNewTemplatePage() throws Throwable {
		//PendingtextTemplate
		Util.pause(10);
	    assert (newTemplatePage.verifyElementPresent("textTemplate"));
	}

	@When("^the user types \"(.*?)\" in \"(.*?)\" in New Template Page$")
	public void the_user_types_in_newTemplatePage(final String inputData, final String elementName) {
	    if (elementName.contains("fieldTemplateName")) {
	    	String templateName = inputData + Util.getNameCurrentResponseRule().substring(Util.getNameCurrentResponseRule().indexOf("Name") + 4);
		newTemplatePage.typeDataInInputField(templateName, elementName);
	    } else {
	    newTemplatePage.typeDataInInputField(inputData, elementName);
	    }
	}
	

	@When("^the user clicks \"(.*?)\" in New Template Page$")
	public void the_user_clicks_in_newTemplatePage(final String elementName) {
	    newTemplatePage.clickElement(elementName);
	}

	@Then("^the user sees \"(.*?)\" in New Template Page$")
	public void the_user_sees_in_newTemplatePage(final String elementName) {
		Util.pause(5);
	    assert (newTemplatePage.verifyElementPresent(elementName));
	}
	
	@When("^the user selects latest response rule from \"(.*?)\" in New Template Page$")
	public void the_user_selects_latest_response_rule_from_New_Template_Page(final String elementName) {
		newTemplatePage.selectLastResponseRuleNameFromDropDown(Util.getNameCurrentResponseRule(), elementName);
	}
	

}
