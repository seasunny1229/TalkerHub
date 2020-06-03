package com.seasunny.talkerspace.training.service;

import com.seasunny.talkerspace.training.bean.Person;

public interface PersonService {

	Person selectByPrimaryKey(Integer id);
	
}
