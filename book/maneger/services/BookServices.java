package book.maneger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.maneger.dao.BookRepository;
import book.maneger.entity.Book;

@Service
public class BookServices {
	@Autowired
	private BookRepository bookrepositry;

	public List<Book> getallbook() {
		List<Book> book = (List<Book>) this.bookrepositry.findAll();
		return book;
	}

	public Optional<Book> getbookbyid(int id) {
		Optional<Book> book = null;
		try {
			
			book=this.bookrepositry.findById(id);
			return book;
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

		return book;
	}

	public Book addbook(Book book) {
		return this.bookrepositry.save(book);

	}

	public void deletebook(int id) {
		this.bookrepositry.deleteById(id);
	}

	public void updatebook(Book book, int id) {
		book.setId(id);
		this.bookrepositry.save(book);
	}

}
