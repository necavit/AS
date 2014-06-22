package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.ParamsDAO;
import edu.upc.fib.wordguess.domain.model.WordGuessParams;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresParamsDAO extends PostgresGenericDAO<WordGuessParams> implements ParamsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<WordGuessParams> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<WordGuessParams> params = (List<WordGuessParams>) session.createQuery("from " + WordGuessParams.TABLE).list();
				
		session.close();
		
		return params;
	}

	@Override
	public WordGuessParams getParams() {
		List<WordGuessParams> params = getAll();
		if (params != null && params.size() > 0) {
			return params.get(0);
		}
		else {
			return null;
		}
	}
	
}
