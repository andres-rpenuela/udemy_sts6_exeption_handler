package com.tokioschool.spring.domain;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
//@Component
public class User {
	private static Long count = 1L;
	
	@Default
	private Long id = count++;
	private String name;
	private String lastName;
	
	@PostConstruct
	public void init() {
		generateId();
	}
	
	private synchronized void generateId() {
		count++;
		this.id = count;
	}

}
