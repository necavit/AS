package edu.upc.fib.wordguess;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/cucumber-features"
)
public class IntegrationTestRunner {
	//the body must be empty -- do not change this
}
