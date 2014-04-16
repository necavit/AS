package edu.upc.fib.wordguess.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="foo_entity")
public class FooHibernateEntityTest implements java.io.Serializable {

	@Id
	private int id;
	
	@Column
	private String name;
	
	public FooHibernateEntityTest(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
