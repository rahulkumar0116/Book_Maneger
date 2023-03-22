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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import book.maneger.entity.Auther;
import book.maneger.services.AutherServices;

@RestController
public class AutherController {
	@Autowired
	private AutherServices autherservices;

	@GetMapping("/auther")
	public ResponseEntity<List<Auther>> getAuther() {
		List<Auther> list = this.autherservices.getAllAuther();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}

	@GetMapping("/auther/{id}")
	public ResponseEntity<Optional<Auther>> getAuther(@PathVariable("id") int id) {
		Optional<Auther> auther = this.autherservices.getAutherByid(id);
		if (auther == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(auther));
	}

	@PostMapping("/auther")
	public ResponseEntity<Auther> addauther(@RequestBody Auther auther) {
		Auther ans = null;
		try {
			ans = this.autherservices.addauther(auther);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(ans);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@DeleteMapping("/auther/{id}")
	public ResponseEntity<Auther> deleteauther(@PathVariable("id")int id){
		try {
			this.autherservices.deleteAuther(id);
			return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).build();
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	public ResponseEntity<Auther> updateauther(@RequestBody Auther auther, @PathVariable("id")int id){
		try {
			this.autherservices.updateAuther(auther, id);
			return ResponseEntity.ok().body(auther);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
