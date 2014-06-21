package edu.upc.fib.wordguess.data.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.upc.fib.wordguess.data.dao.MatchDAO;
import edu.upc.fib.wordguess.data.exception.MatchNotExistsException;
import edu.upc.fib.wordguess.domain.model.Match;

public class MockMatchDAO extends MockGenericDAO<Match> implements MatchDAO {

	private Map<Integer, Match> map;
	
	public MockMatchDAO() {
		map = new HashMap<Integer, Match>();
	}
	
	@Override
	public Match get(int matchId) throws MatchNotExistsException {
		if (map.containsKey(matchId)) {
			return map.get(matchId);
		} else {
			throw new MatchNotExistsException();
		}
	}
	
	@Override
	public Match store(Match object) throws Exception {
		map.put(object.getMatchId(), object);
		return object;
	}
	
	@Override
	public Match update(Match object) throws Exception {
		map.put(object.getMatchId(), object);
		return object;
	}
	
	@Override
	public Match delete(Match object) throws Exception {
		map.remove(object).getMatchId();
		return object;
	}
	
	@Override
	public boolean exists(int matchId) {
		return map.containsKey(matchId);
	}
	
	@Override
	public List<Match> getAll() {
		List<Match> list = new ArrayList<Match>();
		for (Entry<Integer, Match> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
}
