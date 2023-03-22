package book.maneger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import book.maneger.entity.Auther;
@Repository
public interface AutherRepositry extends JpaRepository<Auther, Integer>{

}
