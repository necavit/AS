package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.exception.UserNotExistsException;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public class MockRegisteredUserDAO extends MockGenericDAO<RegisteredUser> implements RegisteredUserDAO {

	private Map<String, RegisteredUser> map;
	
	public MockRegisteredUserDAO() {
		map = new HashMap<String, RegisteredUser>();
	}

	@Override
	public RegisteredUser getUser(String username) throws UserNotExistsException {
		if (map.containsKey(username)) {
			return map.get(username);
		} else {
			throw new UserNotExistsException();
		}
	}

	@Override
	public RegisteredUser store(RegisteredUser object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}
	
	@Override
	public RegisteredUser update(RegisteredUser object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}
	
	@Override
	public RegisteredUser delete(RegisteredUser object) throws Exception {
		map.remove(object).getUsername();
		return object;
	}
	
	@Override
	public boolean exists(String username) {
		return map.containsKey(username);
	}
	
	@Override
	public List<RegisteredUser> getAll() {
		List<RegisteredUser> list = new ArrayList<RegisteredUser>();
		for (Entry<String, RegisteredUser> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
}
