package com.tokioschool.spring.services;

import java.util.List;

import com.tokioschool.spring.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();
	UserDto findById(Long id);
	
}