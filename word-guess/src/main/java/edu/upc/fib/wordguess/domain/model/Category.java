package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.HibernateException;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.mock.MockDAOFactory;

@Entity
@Table(name=Category.TABLE)
public class Category implements Serializable {
	/**
	 * Classe java corresponent a la classe "Category" del model de classes de domini
	 * */
	private static final long serialVersionUID = 7847291535698838393L;

	public static final String TABLE = "category";

	@Id
	@Column
	private String name;
	
	private List<Word> words;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Category() {
		//
	}
	
	private static CategoryDAO dao = MockDAOFactory.getInstance().getCategoryDAO();
	
	public Category(String name) throws HibernateException {
		this.name = name;
		this.words = new ArrayList<Word>();
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
	
	public List<Word> getWords() {
		return words;
	}
	
	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void addWord(Word word) {
		this.words.add(word);
		try {
			dao.update(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteWord(Word word) {
		this.words.remove(word);
	}
	
	public Word getRandomWord() {
		Random rand = new Random();
		int wordIndex = rand.nextInt(words.size());
		return words.get(wordIndex);
	}
	
}
