package com.skilldistillery.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.books.dao.BookDAO;
import com.skilldistillery.books.entities.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO dao;
	
	@RequestMapping(path = {"/", "index.do"})
	public String index(Model model) {
		model.addAttribute("book", dao.findAll());
		return "index";
	}
	
	@RequestMapping(path="getTitle.do")
	public String getTitle(List<Book> title, Model model) {
		List<Book> book = dao.findByTitle(title);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path="getAuthor.do")
	public String getAuthor(List<Book> author, Model model) {
		List<Book> book = dao.findByAuthor(author);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path="getGenre.do")
	public String getGenre(List<Book> genre, Model model) {
		List<Book> book = dao.findByGenre(genre);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path="getSeriesName.do")
	public String getSeries(List<Book> seriesName, Model model) {
		List<Book> book = dao.findBySeriesName(seriesName);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path="getDescription.do")
	public String getDescription(List<Book> description, Model model) {
		List<Book> book = dao.findByDescription(description);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path = "add.do", method = RequestMethod.POST)
    public String add(Book book, Model model) {
    	return "addBook";
    }
	
	@RequestMapping(path = "added.do", method = RequestMethod.POST)
	public String added(Book book, Model model) {
		dao.add(book);
		model.addAttribute("book", book);
		return "added";
	}
	
	

}

