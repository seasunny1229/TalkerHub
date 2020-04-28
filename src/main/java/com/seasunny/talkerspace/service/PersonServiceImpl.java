package com.seasunny.talkerspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasunny.talkerspace.bean.Person;
import com.seasunny.talkerspace.mapper.PersonMapper;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonMapper personMapper;
	
	@Override
	public Person selectByPrimaryKey(Integer id) {
		return personMapper.selectByPrimaryKey(id);
	}

	
}
