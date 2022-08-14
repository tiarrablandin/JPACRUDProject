package com.skilldistillery.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.books.dao.BookDAO;
import com.skilldistillery.books.entities.Book;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;

	@RequestMapping(path = { "/", "index.do" })
	public String index(Model model) {
		model.addAttribute("book", dao.findAll());
		return "index";
	}

	@RequestMapping(path = "findAll.do")
	public String findAll(Model model) {
		List<Book> book = dao.findAll();
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "getTitle.do")
	public String getTitle(String title, Model model) {
		List<Book> book = dao.findByTitle(title);
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "getAuthor.do")
	public String getAuthor(String author, Model model) {
		List<Book> book = dao.findByAuthor(author);
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "getGenre.do")
	public String getGenre(String genre, Model model) {
		List<Book> book = dao.findByGenre(genre);
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "getSeriesName.do")
	public String getSeriesName(String seriesName, Model model) {
		List<Book> book = dao.findBySeriesName(seriesName);
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "getDescription.do")
	public String getDescription(String description, Model model) {
		List<Book> book = dao.findByDescription(description);
		model.addAttribute("book", book);
		return "result";
	}

	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public String add(Book book, Model model) {
		return "add";
	}

	@RequestMapping(path = "added.do", method = RequestMethod.POST)
	public String added(Book book, Model model) {
		dao.add(book);
		model.addAttribute("book", book);
		return "index";
	}
	
	@RequestMapping(path = "edit.do", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam int id) {
		Book book = dao.findById(id);
		model.addAttribute("book", book);
		return "edit";
	}
	
	@RequestMapping(path = "edited.do", method = RequestMethod.POST)
	public String edited(Book book, Model model) {
		dao.edit(0, book);
		model.addAttribute("book", book);
		return "result";
	}
	
	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public String delete(int id, Model model) {
		dao.delete(id);
		return "index";
	}

}
