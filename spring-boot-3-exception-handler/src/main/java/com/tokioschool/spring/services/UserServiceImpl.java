package com.tokioschool.spring.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tokioschool.spring.domain.User;
import com.tokioschool.spring.dto.UserDto;
import com.tokioschool.spring.exceptions.UserNotFoundException;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	List<User> users;
	
	@PostConstruct
	public void init() {
		users = Arrays.asList(
				User.builder().name("Andres").lastName("RuiZ Peñuela").build(),
				User.builder().name("Ricardo").lastName("Peñuela").build(),
				User.builder().name("Ramon").lastName("Ruid Peñuela").build(),
				User.builder().name("Fabio").lastName("Ruid Peñuela").build());
	}
	@Override
	public List<UserDto> findAll() {
		// TODO Auto-generated method stub
		return users.stream().map(UserServiceImpl::mapper).toList();
	}

	@Override
	public UserDto findById(Long id) {
		return users.stream().filter(user -> user.getId() == id ).findFirst().map(UserServiceImpl::mapper)
				.orElseThrow(() ->new  UserNotFoundException("User with id %d not found!".formatted(id)));
	}
	
	private static UserDto mapper(User user) {
		return UserDto.builder().id(user.getId()).name(user.getName()).lastName(user.getLastName()).build();
	}

}
