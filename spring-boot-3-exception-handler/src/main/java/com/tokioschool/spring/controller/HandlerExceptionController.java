package com.tokioschool.spring.controller;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tokioschool.spring.dto.ErrorDto;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class HandlerExceptionController {
	
	@ExceptionHandler
	public ResponseEntity<String> exceptionHandler(Exception ex){
		return ResponseEntity.internalServerError().body(ex.getMessage());
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorDto> numberformatExceptionHandler(NumberFormatException ex,HttpServletRequest request ){
		ErrorDto errorDto = ErrorDto.builder()
				.url(request.getRequestURL().toString())
				.error("Error of type Number Format")
				.message(ex.getMessage())
				.date(LocalDateTime.now()).status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.build();
		
		return ResponseEntity.internalServerError().body(errorDto);
	}

}
