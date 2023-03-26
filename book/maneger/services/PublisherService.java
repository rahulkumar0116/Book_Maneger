package book.maneger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.maneger.dao.PublisherRepositry;
import book.maneger.entity.Publisher;

@Service
public class PublisherService {
	@Autowired
	private PublisherRepositry publisherrepositry;

	public List<Publisher> GetAllPublisher() {
		List<Publisher> list = (List<Publisher>) this.publisherrepositry.findAll();
		return list;
	}

	public Optional<Publisher> GetPublisher(int id) {
		Optional<Publisher> publ = null;
		try {
			publ = this.publisherrepositry.findById(id);
			return publ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return publ;
	}

	public Publisher AddPubl(Publisher publ) {
		return this.publisherrepositry.save(publ);
	}

	public void DeletePubl(int id) {
		this.publisherrepositry.deleteById(id);
	}

	public void UpdatePubl(Publisher publ, int id) {
		publ.setCode(id);
		this.publisherrepositry.save(publ);
	}
}
