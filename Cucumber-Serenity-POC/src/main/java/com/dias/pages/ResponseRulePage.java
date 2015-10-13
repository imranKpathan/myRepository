package com.dias.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.dias.util.Util;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;


public class ResponseRulePage extends PageObject {
	public static Logger APP_LOGS = Logger.getLogger(ResponseRulePage.class);
	
	public void clickElement(final String elementName) {
		String element = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName);
		$(element).click();
	}
	
	public void clickElementResponseRules(final String elementName, final String ruleNumber) {
		String elementBegin = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName.concat("Begin"));
		String elementEnd = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName.concat("End"));
		String element = elementBegin + ruleNumber + elementEnd;
		$(element).click();
	}
	
	public void typeDataInInputField(final String inputData, final String elementName) {
		String element = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName);
		$(element).type(inputData);
	}
	
	public boolean verifyElementPresent(final String elementName) {
		String element = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName);
		boolean hasElement = $(element).isPresent();
		return hasElement;
	}
	
	public void typeResponseRuleInformation(final String inputData, final String elementName, final String ruleNumber) {
		String elementBegin = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName.concat("Begin"));
		String elementEnd = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementName.concat("End"));
		String element = elementBegin + ruleNumber + elementEnd;
		APP_LOGS.info("=====Element Attribute======  :" + element);
		$(element).type(inputData);
	}
	
	public void selectResponseRuleInformationFromDropDown(final String inputData, final String elementNameBegin, final String elementNameEnd, final String ruleNumber) {
		String elementBegin = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementNameBegin);
		String elementEnd = Util.OR_RESPONSE_RULE_PAGE.getProperty(elementNameEnd);
		String element = elementBegin + ruleNumber + elementEnd;
		
		$(element).selectByVisibleText(inputData);
	}
	
	
	public String getTextFromResponseRuleField(final String ruleNumber) {
		String elementBegin = Util.OR_RESPONSE_RULE_PAGE.getProperty("fieldSpokenVoicePromptBegin");
		String elementEnd = Util.OR_RESPONSE_RULE_PAGE.getProperty("fieldSpokenVoicePromptEnd");
		String element = elementBegin + ruleNumber + elementEnd;
		
		return $(element).getText();
	}
	
	

}
