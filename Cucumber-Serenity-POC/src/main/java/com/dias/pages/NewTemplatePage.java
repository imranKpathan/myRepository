package com.dias.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.dias.util.Util;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;


public class NewTemplatePage extends PageObject {
	public static Logger APP_LOGS = Logger.getLogger(NewTemplatePage.class);
	
	public void clickElement(final String elementName) {
		String element = Util.OR_NEW_TEMPLATE_PAGE.getProperty(elementName);
		$(element).click();
	}
	
	public void typeDataInInputField(final String inputData, final String elementName) {
		String element = Util.OR_NEW_TEMPLATE_PAGE.getProperty(elementName);
		$(element).type(inputData);
	}
	
	public boolean verifyElementPresent(final String elementName) {
		String element = Util.OR_NEW_TEMPLATE_PAGE.getProperty(elementName);
		boolean hasElement = $(element).isPresent();
		return hasElement;
	}
	
	public void selectLastResponseRuleNameFromDropDown(final String inputData, final String elementName) {
		String element = Util.OR_NEW_TEMPLATE_PAGE.getProperty(elementName);		
		$(element).selectByVisibleText(inputData);
	}
	
	

}
