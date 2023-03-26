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

import book.maneger.entity.Publisher;
import book.maneger.services.PublisherService;

@RestController
public class PublisherController {
	@Autowired
	private PublisherService publisherservice;

	@GetMapping("/publisher")
	public ResponseEntity<List<Publisher>> GetAllPubl() {
		List<Publisher> publ = this.publisherservice.GetAllPublisher();
		if (publ.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(publ);
	}

	@GetMapping("/publisher/{id}")
	public ResponseEntity<Optional<Publisher>> Getpubl(@PathVariable("id") int id) {
		Optional<Publisher> publ = this.publisherservice.GetPublisher(id);
		if (publ == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(publ));
	}

	@PostMapping("/publisher")
	public ResponseEntity<Publisher> AddPubl(@RequestBody Publisher publ) {
		Publisher ans = null;
		try {
			ans = this.publisherservice.AddPubl(publ);
			return ResponseEntity.of(Optional.of(ans));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/publisher/{id}")
	public ResponseEntity<Publisher> DeletePubl(@PathVariable int id) {
		try {
			this.publisherservice.DeletePubl(id);
			return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/publisher/{id}")
	public ResponseEntity<Publisher> updatePubl(@RequestBody Publisher publ, @PathVariable int id) {
		try {
			this.publisherservice.UpdatePubl(publ, id);
			return ResponseEntity.ok().body(publ);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
