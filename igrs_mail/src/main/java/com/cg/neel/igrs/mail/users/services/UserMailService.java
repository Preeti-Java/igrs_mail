/**
 * 
 */
package com.cg.neel.igrs.mail.users.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.cg.neel.igrs.mail.listener.OnRegistrationCompleteMailEvent;
import com.cg.neel.igrs.mail.users.UserRegMailAccessBean;
import com.cg.neel.igrs.mail.users.UserRegDto;

/**
 * @author Preeti
 *
 */
@Service
public interface UserMailService {

	/**
	 * @param userRegAccessBean
	 * @param token
	 */
	void createVerificationTokenForUser(UserRegDto userRegDto, String token);

	/**
	 * @param token
	 * @return TOKEN_EXPIRED , TOKEN_INVALID, TOKEN_VALID
	 */
	String validateVerificationToken(String token);

	/**
	 * @param token
	 * @return User
	 */
	UserRegMailAccessBean getUser(String token);

	/**
	 * @param event 
	 * @param event
	 * @param userRegDto
	 * @param token
	 * @return
	 */
	SimpleMailMessage constructEmailMessage(UserRegDto userRegDto, String token ,String appUrl);

}
