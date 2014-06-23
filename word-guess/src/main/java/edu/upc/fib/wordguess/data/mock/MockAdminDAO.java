package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.AdminDAO;
import edu.upc.fib.wordguess.domain.model.Admin;

public class MockAdminDAO extends MockGenericDAO<Admin> implements AdminDAO {

	private Map<String, Admin> map;
	
	public MockAdminDAO() {
		map = new HashMap<String, Admin>();
	}
	
	@Override
	public List<Admin> getAll() {
		List<Admin> list = new ArrayList<Admin>();
		for	(Entry<String, Admin> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}

	@Override
	public Admin store(Admin object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}

	@Override
	public Admin update(Admin object) throws Exception {
		map.put(object.getUsername(), object);
		return object;
	}

	@Override
	public Admin delete(Admin object) throws Exception {
		map.remove(object.getUsername());
		return object;
	}

}
