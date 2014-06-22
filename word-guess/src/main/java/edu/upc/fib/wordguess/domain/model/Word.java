package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.HibernateException;

import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;
import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=Word.TABLE)
public class Word implements Serializable {
	/**
	 * Classe java corresponent a la classe "Paraula" del model de classes de domini
	 * */
    private static final long serialVersionUID = -7024212638179206833L;
    public static final String TABLE = "word";

    @Id
    @Column
    private String name;

    @Column
    private int numLetters;

    @ManyToOne
    private Category category;
    
    /**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
    public Word() {
    	//empty constructor for Hibernate to work
    }
    
    private static WordDAO dao = MockDAOFactory.getInstance().getWordDAO();
    
    public Word(String name, Category category) throws HibernateException {
        this.name = name;
        this.numLetters = name.length();
        this.category = category;
        category.addWord(this);
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
        this.numLetters = name.length();
        try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public int getNumLetters() {
        return numLetters;
    }
    
    public Category getCategory() {
		return category;
	}
    
    public void setCategory(Category category) {
		this.category = category;
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
