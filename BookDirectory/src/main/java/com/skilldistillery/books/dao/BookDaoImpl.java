package com.skilldistillery.books.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.books.entities.Book;

@Service
@Transactional
public class BookDaoImpl implements BookDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Book findById(int bookId) {
		return em.find(Book.class, bookId);
	}

	@Override
	public List<Book> findAll() {
		String jpql = "SELECT b FROM Book b";
		return em.createQuery(jpql, Book.class).getResultList();
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> bookList = new ArrayList<Book>();
		String jpql = "SELECT b FROM Book b WHERE b.title LIKE :title";
		bookList = em.createQuery(jpql, Book.class)
					 .setParameter("title", "%" + title + "%")
					 .getResultList();
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> bookList = new ArrayList<Book>();
		String jpql = "SELECT b FROM Book b WHERE b.author LIKE :author";
		bookList = em.createQuery(jpql, Book.class)
				 .setParameter("author", "%" + author + "%")
				 .getResultList();
	return bookList;
	}

	@Override
	public List<Book> findByGenre(String genre) {
		List<Book> bookList = new ArrayList<Book>();
		String jpql = "SELECT b FROM Book b WHERE b.genre LIKE :genre";
		bookList = em.createQuery(jpql, Book.class)
				 .setParameter("genre", "%" + genre + "%")
				 .getResultList();
	return bookList;
	}

	@Override
	public List<Book> findBySeriesName(String seriesName) {
		List<Book> bookList = new ArrayList<Book>();
		String jpql = "SELECT b FROM Book b WHERE b.seriesName LIKE :seriesName";
		bookList = em.createQuery(jpql, Book.class)
				 .setParameter("seriesName", "%" + seriesName + "%")
				 .getResultList();
	return bookList;
	}

	@Override
	public List<Book> findByDescription(String description) {
		List<Book> bookList = new ArrayList<Book>();
		String jpql = "SELECT b FROM Book b WHERE b.description LIKE :description";
		bookList = em.createQuery(jpql, Book.class)
				 .setParameter("description", "%" + description + "%")
				 .getResultList();
	return bookList;
	}

	@Override
	public Book add(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book edit(int id, Book book) {
		Book updtdBook = em.find(Book.class, id);

		if (updtdBook != null) {
			updtdBook.setTitle(book.getTitle());
			updtdBook.setAuthor(book.getAuthor());
			updtdBook.setGenre(book.getGenre());
			updtdBook.setSeries(book.isSeries());
			updtdBook.setSeriesName(book.getSeriesName());
			updtdBook.setNumber(book.getNumber());
			updtdBook.setDescription(book.getDescription());
			updtdBook.setPageCount(book.getPageCount());
			updtdBook.setReleaseDate(book.getReleaseDate());
		}

		return updtdBook;
	}

	@Override
	public boolean delete(int id) {
		boolean successfulDelete = false;
		Book deletedBook = em.find(Book.class, id);

		if (deletedBook != null) {
			em.remove(deletedBook);
			
			successfulDelete = em.contains(deletedBook);
		}

		return successfulDelete;
	}

}
