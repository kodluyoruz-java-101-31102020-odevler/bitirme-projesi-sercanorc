package com.example.demo.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author  {

    @Id
    @Column(name = "id")
    private String autNo;

    @Column(name = "aut_name")
    private String autName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Book> books;

    public String getAutNo() {
        return autNo;
    }

    public void setAutNo(String autNo) {
        this.autNo = autNo;
    }

    public String getAutName() {
        return autName;
    }

    public void setAutName(String autName) {
        this.autName = autName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
