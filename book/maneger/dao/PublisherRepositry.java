package book.maneger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.maneger.entity.Publisher;
@Repository
public interface PublisherRepositry extends JpaRepository<Publisher, Integer> {

}
