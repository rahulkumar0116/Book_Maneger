package book.maneger.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
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
	@Column(name = "First_name")
	private String firstname;
	private String lastname;
	private String langause;
	
	
	@JsonBackReference
	@OneToOne(mappedBy = "auther")
	private Book book;
	

	public Auther() {

	}

	public int getAutherid() {
		return autherid;
	}

	public void setAutherid(int autherid) {
		this.autherid = autherid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public Auther(int autherid, String firstname, String lastname, String langause, Book book) {
		super();
		this.autherid = autherid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.langause = langause;
		this.book = book;
	}

}
