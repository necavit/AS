package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;

import edu.upc.fib.wordguess.util.HibernateUtil;

@Entity
@Table(name=Word.TABLE)
public class Word implements Serializable {

    private static final long serialVersionUID = -7024212638179206833L;
    public static final String TABLE = "word";

    @Id
    @Column
    private String name;

    @Column
    private int numLetters;

    /**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
    public Word() {
    	//empty constructor for Hibernate to work
    }
    
    public Word(String name) throws HibernateException {
        this.name = name;
        this.numLetters = name.length();
        HibernateUtil.store(this);
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        this.numLetters = name.length();
    }

    public int getNumLetters() {
        return numLetters;
    }
}
