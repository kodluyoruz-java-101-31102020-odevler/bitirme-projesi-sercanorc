package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/pages")
public class PageController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String getAllBook(Model model) {

		List<Book> book = bookService.getAllBookList();
		model.addAttribute("books", book);

		return "book";
	}

	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String getAuthorList(Model model) {
		
		List<Author> authors=bookService.getAllAuthorList();
		
		model.addAttribute("author", authors);
		
		return "author";
	}

}
