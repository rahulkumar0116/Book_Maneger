package book.maneger.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;
	
	
	@Column(name="publisher_name")
	private String name;
	private String address;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> books;
	
	public Publisher() {
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Publisher(int code, String name, String address, List<Book> books) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [code=" + code + ", name=" + name + ", address=" + address + ", books=" + books + "]";
	}
}
