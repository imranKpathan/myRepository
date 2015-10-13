package com.wipro.dias.steps;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


/**
 * 
 * @author Imran Khan
 * 
 */
@SuppressWarnings("serial")
public abstract class AbstractPlatform extends ScenarioSteps {

	/**
	 * Constructor.
	 * 
	 * @param pages
	 *            represents page objects
	 */
	public AbstractPlatform(final Pages pages) {
		super(pages);
	}

	
	protected void theUserIsInHomePage() {
	};

}
