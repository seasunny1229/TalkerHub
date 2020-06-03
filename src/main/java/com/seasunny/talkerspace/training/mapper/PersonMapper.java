package com.seasunny.talkerspace.training.mapper;

import org.apache.ibatis.annotations.Select;

import com.seasunny.talkerspace.training.bean.Person;

public interface PersonMapper {

	@Select("select id,name,age,gender from person where id=#{id}")
	Person selectByPrimaryKey(Integer id);
	
}
