package edu.upc.fib.wordguess;

import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.domain.model.Match;
import edu.upc.fib.wordguess.domain.model.Player;
import edu.upc.fib.wordguess.domain.model.Word;


public class TestApp {
    
	public static void main( String[] args ) {    	
    	try {
    		Category category = new Category("fooCategory");
    		Word word = new Word("giraffe", category);
    		Player player = new Player("John", "Doe", "john.doe", "pass", "john@doe.com");
    		
    		Match match = new Match(1, word, player);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
