/**
 * 
 */
package com.cg.neel.igrs.mail.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.mail.users.UserRegDto;
import com.cg.neel.igrs.mail.users.utils.GenericResponse;

/**
 * @author Preeti
 *
 */
@RequestMapping("/default")
public interface MailCmd {

	@PostMapping("/constructEmail")
	public GenericResponse constructEmailMessage(
			/* final OnRegistrationCompleteMailEvent event, */
			@RequestBody  UserRegDto userRegDto, 
			@RequestParam("token")  String token,
	        HttpServletRequest request);

}
