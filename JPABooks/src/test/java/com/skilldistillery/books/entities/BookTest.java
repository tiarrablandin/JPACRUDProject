package com.skilldistillery.books.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Book book;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPABooks");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		book = em.find(Book.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		book = null;
	}

	@Test
	void test() {
		assertNotNull(book);
		assertEquals("Sample Title", book.getTitle());
		assertEquals("Fake Author", book.getAuthor());
		assertEquals("Fake", book.getGenre());
		assertEquals(false, book.isSeries());
		assertEquals(null, book.getSeriesName());
		assertEquals(null, book.getNumber());
		assertEquals("Fake", book.getDescription());
		assertEquals(null, book.getPageCount());
		assertEquals(2022, book.getReleaseDate().getYear());
		assertEquals(8, book.getReleaseDate().getMonthValue());
		assertEquals(12, book.getReleaseDate().getDayOfMonth());
		assertEquals(2022, book.getDateCreated().getYear());
		assertEquals(null, book.getDateUpdated());
	}

}