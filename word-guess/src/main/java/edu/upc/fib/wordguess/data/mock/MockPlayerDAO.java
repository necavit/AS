package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.PlayerDAO;
import edu.upc.fib.wordguess.data.exception.PlayerNotExistsException;
import edu.upc.fib.wordguess.domain.model.Player;

public class MockPlayerDAO extends MockGenericDAO<Player> implements PlayerDAO {

	private Map<String, Player> map;
	
	public MockPlayerDAO() {
		map = new HashMap<String, Player>();
	}
	
	@Override
	public Player get(String username) throws PlayerNotExistsException {
		if (map.containsKey(username)) {
			return map.get(username);
		} else {
			throw new PlayerNotExistsException();
		}
	}
	
	@Override
	public Player store(Player object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}
	
	@Override
	public Player update(Player object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}
	
	@Override
	public Player delete(Player object) throws Exception {
		map.remove(object).getUsername();
		return object;
	}
	
	@Override
	public boolean exists(String username) {
		return map.containsKey(username);
	}
	
	@Override
	public List<Player> getAll() {
		List<Player> list = new ArrayList<Player>();
		for (Entry<String, Player> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
}
