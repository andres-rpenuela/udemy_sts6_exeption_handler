package com.tokioschool.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor	
public class UserDto {
	
	private Long id;
	private String name;
	private String lastName;
	
}
