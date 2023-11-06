/**
 * 
 */
package com.cg.neel.igrs.mail.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.neel.igrs.mail.users.utils.GenericResponse;

/**
 * @author Preeti 
 * @Description User Registration 
 *
 */

@RequestMapping("/default")
public interface UserRegistrationMailCmd {
	
	@GetMapping("/registrationConfirm")
	public GenericResponse confirmRegistration(final HttpServletRequest request, final ModelMap model,
			@RequestParam("token") final String token);
	
	
	
	
}
