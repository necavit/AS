package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;

public class MockParamsDAO extends MockGenericDAO<WordGuessParams> implements ParamsDAO {

	private Map<String, WordGuessParams> map; 
	
	public MockParamsDAO() {
		map = new HashMap<String, WordGuessParams>();
	}
	
	@Override
	public List<WordGuessParams> getAll() {
		List<WordGuessParams> list = new ArrayList<WordGuessParams>();
		for (Entry<String, WordGuessParams> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public WordGuessParams store(WordGuessParams object) throws Exception {
		map.put(object.getId(), object);
		return object;
	}

	@Override
	public WordGuessParams update(WordGuessParams object) throws Exception {
		map.put(object.getId(), object);
		return object;
	}

	@Override
	public WordGuessParams delete(WordGuessParams object) throws Exception {
		map.remove(object.getId());
		return object;
	}

	@Override
	public WordGuessParams getParams() {
		return getAll().get(0); //NOTE that this is safe, because it is a singleton class
	}

}
