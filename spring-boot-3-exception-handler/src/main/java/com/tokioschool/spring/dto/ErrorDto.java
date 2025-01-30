package com.tokioschool.spring.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class ErrorDto {
	
	private String url;
	private String error;
	private String message;
	private Integer status;
	private LocalDateTime date;
}