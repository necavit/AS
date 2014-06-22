package edu.upc.fib.wordguess.data.dao;

import java.util.List;

/**
 * Generic base interface for Object DAOs (Data Access Objects)
 * 
 * It provides basic methods which can be abstracted from all DAOs.
 * No method for object existence or single object access is defined,
 * because such methods need to know the type of the key which is
 * used to store them. Even though a second parameter could be added
 * to address this issue, it might result being a hassle when composite
 * keys arise.
 * 
 * @param <T> the type of object the DAO will retrieve
 */
public interface GenericDAO<T> {
	
	/**
	 * Retrieves a List of all the objects of type T that have been
	 * stored in the database.
	 * 
	 * @return the list of all the objects
	 */
	public List<T> getAll();
	
	/**
	 * Stores a given object of type T in the database.
	 * 
	 * @param object the object to be stored
	 * @return the same object that was stored
	 * @throws Exception if some integrity constraints are
	 *  violated or any other problem arose during storage
	 */
	public T store(T object) throws Exception;
	
	/**
	 * Updates a given object of type T that was stored in the database.
	 * 
	 * @param object the object to be updated
	 * @return the same object that was updated
	 * @throws Exception if some integrity constraints are
	 *  violated or any other problem arose during update
	 */
	public T update(T object) throws Exception;
	
	/**
	 * Deletes a given object of type T that was stored in the database.
	 * 
	 * @param object the object to be deleted
	 * @return the same object that was deleted
	 * @throws Exception if some integrity constraints are
	 *  violated or any other problem arose during deletion
	 */
	public T delete(T object) throws Exception;
		
}
