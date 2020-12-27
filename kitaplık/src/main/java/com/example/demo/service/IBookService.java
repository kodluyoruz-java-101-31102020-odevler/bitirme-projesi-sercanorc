package com.example.demo.service;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.service.model.BookContext;
import com.example.demo.service.model.BookProfile;

import java.util.List;

public interface IBookService {

    public Book findByBook(Long id);
    public Book findByName(String name);
    public List<Book> getAllBookList();
    public List<Author> getAllAuthorList();
    public Long save(BookContext book);
    public void update(Book book);
    public void delete(Long id);
}
