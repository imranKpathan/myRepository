package com.dias.pages;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.dias.util.Util;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class HomePage extends PageObject {
	
	public void clickElement(final String elementName) {
		String element = Util.OR_HOME_PAGE.getProperty(elementName);
		$(element).click();
	}
	
	public void typeDataInInputField(final String inputData, final String elementName) {
		String element = Util.OR_HOME_PAGE.getProperty(elementName);
		$(element).type(inputData);
	}
	
	public boolean verifyElementPresent(final String elementName) {
		String element = Util.OR_HOME_PAGE.getProperty(elementName);
		boolean hasElement = $(element).isPresent();
		return hasElement;
	}
	
	public void hoverAndClick(final String hoverElement, final String clickElement) {
		String element1 = Util.OR_HOME_PAGE
				.getProperty(hoverElement);
		Actions builder = new Actions(getDriver());
		Action mouseOverElement1 = builder.moveToElement($(element1))
				.build();
		String element2 = Util.OR_HOME_PAGE.getProperty(clickElement);
		Action mouseOverElement1AndClickElement2 = builder.moveToElement($(element2)).click()
				.build();
		mouseOverElement1.perform();
		Util.pause(5);
		mouseOverElement1AndClickElement2.perform();
	}

}
