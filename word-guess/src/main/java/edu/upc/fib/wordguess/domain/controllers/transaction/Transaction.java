package edu.upc.fib.wordguess.domain.controllers.transaction;

public interface Transaction<T> {

	/**
	 * Generic execution method for transaction controllers.
	 * 
	 * @return the value of the execution
	 */
	public T execute() throws Exception;
	
}
