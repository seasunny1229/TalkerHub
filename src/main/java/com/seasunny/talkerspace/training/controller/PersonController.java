package com.seasunny.talkerspace.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seasunny.talkerspace.training.bean.Person;
import com.seasunny.talkerspace.training.service.PersonService;


@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/find")
	public Person find(@RequestParam(value="id", defaultValue="1") int id) {
		return personService.selectByPrimaryKey(id);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world!";
	}
}
