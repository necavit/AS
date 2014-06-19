Feature: Simple Hibernate test
	Simple test to assess that Hibernate maps correctly
	a simple object of the model, by inserting, updating
	and removing it.
	
	No information is actually persisted, since before and
	after each scenario a transaction is initiated and
	then no commit is done.
	
	Scenario: Insert Word
		Given the word "hibernation"
		When the word is inserted
		And the database is queried for its existence
		Then the word exists