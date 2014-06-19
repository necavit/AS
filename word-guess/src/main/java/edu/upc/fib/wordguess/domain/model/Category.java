package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;

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
	
	public Category(String name) throws HibernateException {
		this.name = name;
		HibernateUtil.store(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
