package edu.upc.fib.wordguess.stepdefinitions;

import org.hibernate.HibernateException;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.upc.fib.wordguess.data.DAOFactory;
import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;
import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Word;

public class HibernateMapping {

	private String name;
	private boolean exists = false;
	
	@Given("^the word \"([^\"]*)\"$")
	public void the_word(String name) throws Throwable {
	    this.name = name;
	}

	@When("^the word is inserted$")
	public void the_word_is_inserted() throws Throwable {
		try {
			new Word(name, new Category("foo"));
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}

	@When("^the database is queried for its existence$")
	public void the_database_is_queried_for_its_existence() throws Throwable {
	    DAOFactory daoFactory = MockDAOFactory.getInstance();
	    WordDAO wordDAO = daoFactory.getWordDAO();
	    exists = wordDAO.exists(name);
	}

	@Then("^the word exists$")
	public void the_word_exists() throws Throwable {
	    Assert.assertTrue(exists);
	}
	
}
