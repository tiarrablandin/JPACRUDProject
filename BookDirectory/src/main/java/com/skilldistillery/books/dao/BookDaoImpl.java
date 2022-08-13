package com.skilldistillery.books.dao;

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
		return null;
	}

	@Override
	public Book findByTitle(String title) {
		return null;
	}

}
