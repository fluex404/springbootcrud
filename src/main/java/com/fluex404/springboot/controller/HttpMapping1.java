package com.fluex404.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fluex404.springboot.model.Student;
import com.fluex404.springboot.repository.StudentRepository;

@Controller
public class HttpMapping1 {
	@Autowired
	private StudentRepository repo;

	@RequestMapping("/")
	public String createHome(Model model) {		
		model.addAttribute("student", repo.findAll());
		return "home";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create1(Model model) {
		model.addAttribute("student", new Student());
		return "formStudent";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create2(Model model, Student student) {
		model.addAttribute("student", repo.save(student));
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("student", repo.getOne(id));
		return "formStudent";
	}
	
	@RequestMapping(value="/hapus/{id}", method=RequestMethod.GET)
	public String hapus(@PathVariable Integer id) {
		repo.deleteById(id);
		return "redirect:/";
	}
}
