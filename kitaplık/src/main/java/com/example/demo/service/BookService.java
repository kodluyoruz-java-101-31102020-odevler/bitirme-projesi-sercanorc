package com.example.demo.service;

import com.example.demo.annotation.RunTime;
import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.jpa.repository.BookRepository;
import com.example.demo.service.model.BookContext;
import com.example.demo.service.model.BookProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RunTime(active = true)
	public Book findByBook(Long id) {
		return bookRepository.findWithId(id);
	}
	
	@RunTime(active = true)
	public Book findByName(String name) {

		return bookRepository.findWithName(name);
	}
	
	@RunTime(active = true)
	public List<Book> getAllBookList() {
		
		return bookRepository.getAllBookList();
	}
	
	@RunTime(active = true)
	public List<Author> getAllAuthorList() {
		
		return bookRepository.getAllAuthorList();
	}
	@Transactional
	@RunTime(active = true)
	public Long save(BookContext bookContext) {
		Book book = new Book();
		book.setId(bookContext.getId());
		book.setName(bookContext.getName());
		book.setYear(bookContext.getYear());
		book.setDescription(bookContext.getDescription());
		book.setNote(bookContext.getNote());
		book.setAuthor(bookContext.getAuthor());

		book = bookRepository.save(book);
		return book.getId();
	}

	@Transactional
	@RunTime(active = true)
	public void update(Book book) {
		bookRepository.save(book);
	}

	@Transactional
	@RunTime(active = true)
	public void delete(Long id) {
		if(bookRepository.findWithId(id)!= null) {
			bookRepository.deleteById(id);
		}
	}

	@RunTime(active = true)
	public List<BookProfile> getAllBookProfileList(String name) {

		return bookRepository.getAllBookProfileList(name);
	}


}
