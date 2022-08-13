package com.skilldistillery.books.dao;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookDAO {
	
	Book findById(int bookId);
	
	List<Book> findAll();
	
	Book findByTitle(String title);

}
