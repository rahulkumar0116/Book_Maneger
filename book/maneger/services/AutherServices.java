package book.maneger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.maneger.dao.AutherRepositry;
import book.maneger.entity.Auther;

@Service
public class AutherServices {

	@Autowired
	private AutherRepositry autherepositry;

	public List<Auther> getAllAuther() {
		List<Auther> list = (List<Auther>) this.autherepositry.findAll();
		return list;
	}

	public Optional<Auther> getAutherByid(int id) {
		Optional<Auther> auther = null;
		try {
			auther=this.autherepositry.findById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return auther;
	}

	public Auther addauther(Auther auther) {
		return this.autherepositry.save(auther);
	}

	public void deleteAuther(int id) {
		this.autherepositry.deleteById(id);
	}

	public void updateAuther(Auther auther, int id) {
		auther.setAutherid(id);
		this.autherepositry.save(auther);
	}
}
