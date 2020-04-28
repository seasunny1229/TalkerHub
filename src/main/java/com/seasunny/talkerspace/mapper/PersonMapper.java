package com.seasunny.talkerspace.mapper;

import org.apache.ibatis.annotations.Select;

import com.seasunny.talkerspace.bean.Person;

public interface PersonMapper {

	@Select("select id,name,age,gender from person where id=#{id}")
	Person selectByPrimaryKey(Integer id);
	
}
