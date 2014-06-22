package edu.upc.fib.wordguess.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.upc.fib.wordguess.data.dao.WordDAO;
import edu.upc.fib.wordguess.data.postgres.PostgresDAOFactory;

/**
 * Classe java corresponent a la classe "Paraula" del model de classes de domini
 * */
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    public static final String MAPPED_BY_CATEGORY = "category";
    
    @OneToMany(mappedBy=Match.MAPPED_BY_WORD)
    private List<Match> matches;
    
    /**
     * WARNING! Never use this constructor!
     * 
     * Its existence is just for Hibernate to work well.
     */
    public Word() {
    	//empty constructor for Hibernate to work
    }
    
    private static WordDAO dao = PostgresDAOFactory.getInstance().getWordDAO();
    
    public Word(String name, Category category) throws Exception {
        this.name = name;
        this.numLetters = name.length();
        this.category = category;
        this.matches = new ArrayList<Match>();
        category.addWord(this);
        dao.store(this);
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) throws Exception {
        this.name = name;
        this.numLetters = name.length();
        dao.update(this);
    }

    public int getNumLetters() {
        return numLetters;
    }
    
    public Category getCategory() {
		return category;
	}
    
    public void setCategory(Category category) throws Exception {
		this.category.deleteWord(this);
    	this.category = category;
    	category.addWord(this);
		dao.update(this);
	}
    
    public List<Match> getMatches() {
		return matches;
	}
    
    public void setMatches(List<Match> matches) throws Exception {
		this.matches = matches;
		dao.update(this);
	}
    
    public void addMatch(Match match) throws Exception {
    	this.matches.add(match);
    	dao.update(this);
    }
    
    public void deleteMatch(Match match) throws Exception {
    	this.matches.remove(match);
    	dao.update(this);
    }
}
