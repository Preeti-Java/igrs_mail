/**
 * 
 */
package com.cg.neel.igrs.mail.users.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.mail.users.services.UserMailService;
import com.cg.neel.igrs.mail.users.utils.GenericResponse;

/**
 * @author   Preeti
 *
 */

@RestController
@RequestMapping("/mail-user")
public class UserRegistrationMailCmdImpl implements UserRegistrationMailCmd{
	

	@Autowired
	private UserMailService userService;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public GenericResponse confirmRegistration(HttpServletRequest request, ModelMap model,final String token) {
		Map<String,String> response = new HashMap<>();
		Locale locale = request.getLocale();
		final String result = userService.validateVerificationToken(token);
		if(result.equals("validToken")) {
			response.put("token", token);
			return new GenericResponse(messageSource.getMessage("message.accountVerified", null, locale),result,response);
		}
		return new GenericResponse(messageSource.getMessage("auth.message."+result, null, locale),result,response);
	}


}
