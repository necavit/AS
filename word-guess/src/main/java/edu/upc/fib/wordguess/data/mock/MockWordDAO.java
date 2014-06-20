package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.exception.WordNotExistsException;
import edu.upc.fib.wordguess.domain.model.Word;

public class MockWordDAO extends MockGenericDAO<Word> implements WordDAO {
	
	private Map<String, Word> map;
	
	public MockWordDAO() {
		map = new HashMap<String, Word>();
	}
	
	@Override
	public Word get(String name) throws WordNotExistsException {
		if (map.containsKey(name)) {
			return map.get(name);
		} else {
			throw new WordNotExistsException();
		}
	}
	
	@Override
	public Word store(Word object) throws Exception {
		map.put(object.getName(), object);
		return object;
	}
	
	@Override
	public Word update(Word object) throws Exception {
		map.remove(object).getName();
		map.put(object.getName(), object);
		return object;
	}
	
	@Override
	public Word delete(Word object) throws Exception {
		map.remove(object).getName();
		return object;
	}
	
	@Override
	public boolean exists(String name) {
		return map.containsKey(name);
	}
	
	@Override
	public List<Word> getAll() {
		List<Word> list = new ArrayList<Word>();
		for (Entry<String, Word> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
}