package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.CategoryDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

/**
 * Classe java corresponent a la classe "Category" del model de classes de domini
 * */
@Entity
@Table(name=Category.TABLE)
public class Category implements Serializable {
	
	private static final long serialVersionUID = 7847291535698838393L;

	public static final String TABLE = "category";

	@Id
	@Column
	private String name;
	
	@OneToMany(mappedBy=Word.MAPPED_BY_CATEGORY,
			fetch=FetchType.EAGER)
	private List<Word> words;
	
	/**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
	public Category() {
		//
	}
	
	private static CategoryDAO dao = PostgresDAOFactory.getInstance().getCategoryDAO();
	
	public Category(String name) throws Exception {
		this.name = name;
		this.words = new ArrayList<Word>();
		dao.store(this);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws Exception {
		this.name = name;
		dao.update(this);
	}
	
	public List<Word> getWords() {
		return words;
	}
	
	public void setWords(List<Word> words) {
		this.words = words;
	}

	public void addWord(Word word) throws Exception {
		this.words.add(word);
		dao.update(this);
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
