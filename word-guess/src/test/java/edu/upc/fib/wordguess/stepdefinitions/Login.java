package edu.upc.fib.wordguess.stepdefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.upc.fib.wordguess.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.controllers.transaction.LoginTransaction;

public class Login extends WordGuessStepDefinition {
	
	private String username;
	private String password;
	private boolean loggedIn;
	private boolean usernameExists = true;
	
	@Given("^the username \"([^\"]*)\"$")
	public void the_username(String username) throws Throwable {
	    this.username = username;
	}

	@Given("^the password \"([^\"]*)\"$")
	public void the_password(String password) throws Throwable {
	    this.password = password;
	}

	//login action
	@When("^the user tries to log in$")
	public void the_user_tries_to_log_in() throws Throwable {
	    LoginTransaction loginController = new LoginTransaction(username, password);
	    try {
	    	loggedIn = loginController.execute();
	    } catch (UsernameNotExists ue) {
	    	usernameExists = false;
	    }
	}

	//successful login
	@Then("^the system logs the user in$")
	public void the_system_logs_the_user_in() throws Throwable {
	    Assert.assertTrue(loggedIn);
	}
	
	//non-existent username
	@Then("^the system warns that no such username exists$")
	public void the_system_warns_that_no_such_username_exists() throws Throwable {
	    Assert.assertFalse(usernameExists);
	}
	
	//invalid password
	@Then("^the system refuses to log the user in$")
	public void the_system_refuses_to_log_the_user_in() throws Throwable {
	    Assert.assertFalse(loggedIn);
	}
}
