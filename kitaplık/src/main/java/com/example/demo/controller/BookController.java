package com.example.demo.controller;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.model.BookContext;
import com.example.demo.service.model.BookProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookController {
	@Autowired
	public BookService bookService;
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book findByBkNo(@PathVariable("id") Long id) {
		return bookService.findByBook(id);
	}
	
	@RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
	public Book findByName(@PathVariable("name") String name) {
		
		return bookService.findByName(name);
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public List<Book> getAllBookList() {
		
		return bookService.getAllBookList();
	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public List<Author> getAllAuthorList() {

		return bookService.getAllAuthorList();
	}
	@RequestMapping(value = "/book/save", method = RequestMethod.POST)
	public void saveBook(@RequestBody BookContext book) {
		bookService.save(book);

	}
	@RequestMapping(value = "/book/update", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book) {

		bookService.update(book);
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable Long bookId) {

		bookService.delete(bookId);
	}
	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public List<BookProfile> getAllBookProfileList(@PathVariable("name") String name) {

		List<BookProfile> profiles = bookService.getAllBookProfileList(name);

		return profiles;
	}

	

}
