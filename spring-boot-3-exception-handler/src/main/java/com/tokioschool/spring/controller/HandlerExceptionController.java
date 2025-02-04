package com.tokioschool.spring.controller;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.tokioschool.spring.dto.ErrorDto;
import com.tokioschool.spring.exceptions.UserNotFoundException;

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
	
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ErrorDto> noResourceFoundException(NoResourceFoundException ex,HttpServletRequest request ){
		ErrorDto errorDto = ErrorDto.builder()
				.url(request.getRequestURL().toString())
				.error("Error url not found!")
				.message(ex.getMessage())
				.date(LocalDateTime.now()).status(HttpStatus.BAD_REQUEST.value())
				.build();
		
		return ResponseEntity.internalServerError().body(errorDto);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,String> userNotFoundExceptionExceptionHandler(UserNotFoundException ex,HttpServletRequest request ){
		Map<String, String> errors = new HashMap<>();
		errors.put("url",request.getRequestURL().toString());
		errors.put("error","Error to find user");
		errors.put("message", ex.getMessage());
		errors.put("date", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
		errors.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+"");
		
		return errors;
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String,Object> nullPointerExceptionHandler(NullPointerException ex,HttpServletRequest request ){
		
		Map<String, Object> errors = new HashMap<>();
		errors.put("url",request.getRequestURL().toString());
		errors.put("error","Error null pointer");
		errors.put("message", ex.getMessage());
		errors.put("date", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
		errors.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return errors;
	}
}
