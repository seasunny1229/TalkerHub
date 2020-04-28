package com.seasunny.talkerspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seasunny.talkerspace.bean.Person;
import com.seasunny.talkerspace.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/find")
	public Person find(@RequestParam(value="id", defaultValue="1") int id) {
		return personService.selectByPrimaryKey(id);
	}
}
