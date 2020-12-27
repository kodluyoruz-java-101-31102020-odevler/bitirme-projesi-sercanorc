package com.example.demo.dao.entity.jpa.repository;

import com.example.demo.annotation.RunTime;
import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.service.model.BookProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	@RunTime(active = true)
	@Query(value = "FROM Book b WHERE b.id = :id")
	public Book findWithId(@Param("id") Long id);
	
	@RunTime(active = true)
	@Query(value = "FROM Book b WHERE b.name = :name")
	public Book findWithName(@Param("name") String name);

	@RunTime(active = true)
	@Query(value = "SELECT b FROM Book b")
	public List<Book> getAllBookList();

	@RunTime(active = true)
	@Query(value = "SELECT a FROM Author a")
	public List<Author> getAllAuthorList();

	@RunTime(active = true)
	@Query(value = "SELECT new com.example.demo.service.model.BookProfile(b, aut.autName) FROM Book b LEFT OUTER JOIN b.authors aut where b.name = :name")
	public List<BookProfile> getAllBookProfileList(@Param("name") String name);

}
