package com.tokioschool.spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokioschool.spring.dto.UserDto;
import com.tokioschool.spring.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApiController {

	private final UserService userService;
	
	
	@GetMapping({"","/"})
	public List<UserDto> getAllUserHandler(){
		return userService.findAll();
	}
	
	@GetMapping({"/{id}"})
	public UserDto getUserByIdHandler(@PathVariable("id") Long id){
		return userService.findById(id);
	}
}
