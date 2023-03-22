package book.maneger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import book.maneger.entity.Book;
import book.maneger.services.BookServices;

@RestController
public class BookController {
	@Autowired
	private BookServices bookservices;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookservices.getallbook();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Optional<Book>> getbook(@PathVariable ("id")int id) {
		Optional<Book> book = bookservices.getbookbyid(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}

	@PostMapping("/books")
	public ResponseEntity<Book> addbook(@RequestBody Book book) {
		Book ans = null;
		try {
			ans = this.bookservices.addbook(book);
			return ResponseEntity.of(Optional.of(ans));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deltebook(@PathVariable int id) {
		try {
			this.bookservices.deletebook(id);
			return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updatebook(@RequestBody Book book, @PathVariable("id") int id) {
		try {
			this.bookservices.updatebook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
