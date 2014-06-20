package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.domain.model.Category;

public class MockCategoryDAO extends MockGenericDAO<Category> implements CategoryDAO {

	private Map<String, Category> map;
	
	public MockCategoryDAO() {
		map = new HashMap<String, Category>();
	}
	
	@Override
	public Category get(String name) throws CategoryNotExistsException {
		if (map.containsKey(name)) {
			return map.get(name);
		} else {
			throw new CategoryNotExistsException();
		}
	}
	
	@Override
	public Category store(Category object) throws Exception {
		map.put(object.getName(), object);
		return object;
	}
	
	@Override
	public Category update(Category object) throws Exception {
		map.remove(object).getName();
		map.put(object.getName(), object);
		return object;
	}
	
	@Override
	public Category delete(Category object) throws Exception {
		map.remove(object).getName();
		return object;
	}
	
	@Override
	public boolean exists(String name) {
		return map.containsKey(name);
	}
	
	@Override
	public List<Category> getAll() {
		List<Category> list = new ArrayList<Category>();
		for (Entry<String, Category> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
}
