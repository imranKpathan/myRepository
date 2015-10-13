package com.dias.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import com.dias.cucumber.AcceptanceTestSuite;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features",
tags = {"@all"})
public class AcceptanceTestSuite {
	
	
	
}
