/**
 * 
 */
package com.cg.neel.igrs.mail.users.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.neel.igrs.mail.users.UserRegDto;
import com.cg.neel.igrs.mail.users.services.UserMailService;
import com.cg.neel.igrs.mail.users.utils.GenericResponse;
import com.cg.neel.igrs.mail.users.utils.Utils;

/**
 * @author Preeti
 *
 */
@RestController
@RequestMapping("/mail")
public class MailCmdImpl implements MailCmd{

	@Autowired
	private UserMailService userService;
	
	@Autowired
	private MailSender mailSender;

	@Override
	public GenericResponse constructEmailMessage(UserRegDto userRegDto, String token,HttpServletRequest request) {
		// Save token in VerificationToken table
		userService.createVerificationTokenForUser(userRegDto, token);
		
		//getting appUrl 
		String appUrl = Utils.getAppUrl(request);
		
		//Send a mail for Confirmation
		final SimpleMailMessage mail = userService.constructEmailMessage(userRegDto, token,appUrl);
		mailSender.send(mail);

		return null;
	}
}
