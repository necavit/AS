package edu.upc.fib.wordguess.data.postgres;

import java.util.List;

import org.hibernate.classic.Session;

import edu.upc.fib.wordguess.data.dao.AdminDAO;
import edu.upc.fib.wordguess.domain.model.Admin;
import edu.upc.fib.wordguess.util.HibernateUtil;

public class PostgresAdminDAO extends PostgresGenericDAO<Admin> implements AdminDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<Admin> admin = (List<Admin>) session.createQuery("from " + Admin.class.getSimpleName()).list();
				
		session.close();
		
		return admin;
	}

}
