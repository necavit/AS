package edu.upc.fib.wordguess.stepdefinitions;

import org.junit.Before;

import cucumber.api.java.After;

public abstract class WordGuessStepDefinition {
	
	@Before
	public void beforeEachScenario() {
		System.out.println("before scenario");
	}
	
	@After
	public void afterEachScenario() {
		System.out.println("after scenario");
	}
	
}
