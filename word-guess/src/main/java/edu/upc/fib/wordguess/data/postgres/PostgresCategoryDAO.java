package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.exception.CategoryNotExistsException;
import edu.upc.fib.wordguess.domain.model.Category;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresCategoryDAO extends PostgresGenericDAO<Category> implements CategoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Category> category = (List<Category>) session.createQuery("from " + Category.class.getSimpleName()).list();
				
		session.close();
		
		return category;
	}

	@Override
	public Category get(String name) throws CategoryNotExistsException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Category category = (Category) session.get(Category.class, name);
		if (category == null) {
			session.close();
			throw new CategoryNotExistsException();
		}
		
		session.close();
		return category;
	}

	@Override
	public boolean exists(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		boolean exists = (session.get(Category.class, name) != null) ? true : false;
		
		session.close();
		
		return exists;
	}

}
