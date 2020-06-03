package com.seasunny.talkerspace.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasunny.talkerspace.training.bean.Person;
import com.seasunny.talkerspace.training.mapper.PersonMapper;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public Person selectByPrimaryKey(Integer id) {
		return personMapper.selectByPrimaryKey(id);
	}

	
}
