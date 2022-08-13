package com.skilldistillery.books.dao;

import java.util.List;

import com.skilldistillery.books.entities.Book;

public interface BookDAO {
	
	Book findById(int bookId);
	
	List<Book> findAll();
	
	List<Book> findByTitle(List<Book> title);
	
	List<Book> findByAuthor(List<Book> author);
	
	List<Book> findByGenre(List<Book> genre);
	
	List<Book> findBySeriesName(List<Book> seriesName);
	
	List<Book> findByDescription(List<Book> description);
	
	public Book add(Book book);
	
	public Book update(int id, Book book);

	public boolean delete(int id);
	
}
