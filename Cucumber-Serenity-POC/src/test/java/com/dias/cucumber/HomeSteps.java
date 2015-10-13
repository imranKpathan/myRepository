package com.dias.cucumber;

import java.io.IOException;

import org.junit.Assert;

import com.dias.pages.HomePage;
import com.dias.util.Util;

import net.thucydides.core.steps.ScenarioSteps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeSteps extends ScenarioSteps {
	
	ResponseRuleSteps responseRuleSteps;
	HomePage homePage;

	@Before
	public void beforeScenario() throws IOException {
		Util.brandConfigLoader();
	}
	/*
	@After
	public void afterScenario() {
	}
	*/
	@Given("^the user is navigates to New Response Rule page$")
	public void goToCreateNewResponseRulePage() throws Throwable {
		the_user_clicks_in_homepage("linkMyCompany");
		Util.pause(2);
		the_user_clicks_in_homepage("linkMore");
		Util.pause(2);
		the_user_clicks_in_homepage("linkNewResponseRule");
		Util.pause(2);
	}
	
	@Given("^the properties are loaded$")
	public void thePropertiesAreLoaded() throws IOException {
		Util.brandConfigLoader();
	}
	
	@Given("^the user is on Whisper homepage$")
	public void theUserIsOpensTestHomePage() {
		homePage.open();
	}

	@When("^the user types \"(.*?)\" in \"(.*?)\" in homepage$")
	public void the_user_types_in_homepage(final String inputData, final String elementName) {
	    homePage.typeDataInInputField(inputData, elementName);
	}

	@When("^the user clicks \"(.*?)\" in homepage$")
	public void the_user_clicks_in_homepage(final String elementName) {
	    homePage.clickElement(elementName);
	}

	@Then("^the user sees \"(.*?)\" in homepage$")
	public void the_user_sees_in_homepage(final String elementName) {
		Util.pause(30);
	    assert (homePage.verifyElementPresent(elementName));
	}

	@When("^the user hovers over \"(.*?)\" and clicks \"(.*?)\"$")
	public void the_user_hovers_and_clicks_in_homepage(final String hoverElement, final String actionElement) {
	    homePage.hoverAndClick(hoverElement, actionElement);
	}

}
