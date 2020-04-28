package com.seasunny.talkerspace.service;

import com.seasunny.talkerspace.bean.Person;

public interface PersonService {

	Person selectByPrimaryKey(Integer id);
	
}
