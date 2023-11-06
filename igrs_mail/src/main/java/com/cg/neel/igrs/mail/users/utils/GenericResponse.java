/**
 * 
 */
package com.cg.neel.igrs.mail.users.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.Builder;
import lombok.Data;

/**
 * @author Preeti
 * @Des For return response-> message and error
 *
 */
@Data
@Builder
public class GenericResponse {
	
	private String message;
	private String error;
	private HttpStatus status;
	private Map<String,String> data;
	
	public GenericResponse(final String message) {
		super();
		this.message = message;
	}
	
	
	public GenericResponse(String message, String error) {
		super();
		this.message = message;
		this.error = error;
	}
	
	public GenericResponse(final String message, final String error, final Map<String,String> data) {
		super();
		this.message = message;
		this.error = error;
		this.data = data;
	}
	
	public GenericResponse(final String message, final String error, final HttpStatus status, final Map<String,String> data) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.data = data;
	}
	
	//For Multiple Error
	public GenericResponse(List<ObjectError> allErrors, String error) {
		this.error =  error;
		String temp = allErrors.stream().map(e -> 
				{
					if(e instanceof FieldError) {
						return "{\"field\":\""+ ((FieldError) e).getField()+ "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
					}
					else
					{
						return "{\"object\":\""+ e.getObjectName() + "\",\"defaultMessage\":\"" + e.getDefaultMessage() + "\"}";
					}
					
				}
				).collect(Collectors.joining(","));
		this.message = "[" +temp+"]";
	}

}
