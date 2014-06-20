package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;
import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=Category.TABLE)
public class Category implements Serializable {

	private static final long serialVersionUID = 7847291535698838393L;

	public static final String TABLE = "category";

	@Id
	@Column
	private String name;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Category() {
		//
	}
	
	private static CategoryDAO dao = PostgresDAOFactory.getInstance().getCategoryDAO();
	
	public Category(String name) throws HibernateException {
		this.name = name;
		try {
			dao.store(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
