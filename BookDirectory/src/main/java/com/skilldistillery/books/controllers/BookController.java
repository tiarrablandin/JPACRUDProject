package com.skilldistillery.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.books.dao.BookDAO;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO dao;
	
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("DELETEME", dao.findById(1));
		return "index";
	}

}
