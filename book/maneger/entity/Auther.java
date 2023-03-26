package book.maneger.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Auther {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int autherid;
	private String f_name;
	private String l_name;
	private String langause;

	
	@OneToOne
	private Book book;

	public Auther() {

	}

	public int getAutherid() {
		return autherid;
	}

	public void setAutherid(int autherid) {
		this.autherid = autherid;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getLangause() {
		return langause;
	}

	public void setLangause(String langause) {
		this.langause = langause;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Auther(int autherid, String f_name, String l_name, String langause, Book book) {
		super();
		this.autherid = autherid;
		this.f_name = f_name;
		this.l_name = l_name;
		this.langause = langause;
		this.book = book;
	}
}
