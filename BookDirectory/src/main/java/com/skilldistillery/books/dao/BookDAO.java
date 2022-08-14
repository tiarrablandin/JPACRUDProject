package com.skilldistillery.books.dao;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookDAO {
	
	Book findById(int bookId);
	
	List<Book> findAll();
	
	List<Book> findByTitle(String title);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByGenre(String genre);
	
	List<Book> findBySeriesName(String seriesName);
	
	List<Book> findByDescription(String description);
	
	public Book add(Book book);
	
	public Book edit(int id, Book book);

	public boolean delete(int id);
	
}
