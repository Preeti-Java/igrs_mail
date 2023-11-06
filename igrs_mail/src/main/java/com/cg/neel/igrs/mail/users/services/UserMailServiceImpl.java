/**
 * 
 */
package com.cg.neel.igrs.mail.users.services;

import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.cg.neel.igrs.mail.users.UserRegDto;
import com.cg.neel.igrs.mail.users.UserRegMailAccessBean;
import com.cg.neel.igrs.mail.users.VerificationMailToken;
import com.cg.neel.igrs.mail.users.repository.TokenMailRepository;
import com.cg.neel.igrs.mail.users.repository.UserRegMailRepository;




/**
 * @author Preeti
 *
 */
@Component
@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix = "mail")
public class UserMailServiceImpl implements UserMailService {
	
	private static final String TOKEN_INVALID = "invalidToken";
	private static final String TOKEN_VALID = "validToken";
	private static final String TOKEN_EXPIRED = "expiredToken";
	
	private static final String MAIL_MESSAGE = "You registered successfully. To confirm your registration, please click on the below link.";
	
	@Autowired
	private TokenMailRepository tokenRepository;
	
	@Autowired
	private UserRegMailRepository userRegRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private Environment env;

	@Override
	public void createVerificationTokenForUser(final UserRegDto userRegDto, final String token) {
		
		//Convert UserRegDto -> UserRegAccessBean
		UserRegMailAccessBean userRegAccessBean = modelMapper.map(userRegDto, UserRegMailAccessBean.class);
		
		final VerificationMailToken verificationToken=new VerificationMailToken(token, userRegAccessBean);
		tokenRepository.save(verificationToken);
	}

	@Override
	public String validateVerificationToken(String token) {
		final VerificationMailToken verificationToken = tokenRepository.findByToken(token);
		if(verificationToken == null) {
			return TOKEN_INVALID;
		}
		
		final UserRegMailAccessBean userRegMailAccessBean = verificationToken.getUserRegMailAccessBean();
		//Check date is not past date
		final Calendar cal = Calendar.getInstance();
		if((verificationToken.getExpiryDate()
							.getTime() - cal.getTime().getTime()) <= 0) {
			tokenRepository.delete(verificationToken);
			return TOKEN_EXPIRED;
		}
		
		userRegMailAccessBean.setStatus(1);
		userRegRepository.save(userRegMailAccessBean);
		return TOKEN_VALID;
	}

	@Override
	public UserRegMailAccessBean getUser(String token) {
		final VerificationMailToken verificationToken = tokenRepository.findByToken(token);
		if(verificationToken != null) {
			return verificationToken.getUserRegMailAccessBean();
		}
		return null;
	}

	/**
	 * @param event
	 * @param userRegAccessBean
	 * @param token
	 * @return
	 */
	@Override
	public SimpleMailMessage constructEmailMessage(
			final UserRegDto userRegDto,final String token ,String appUrl) {
		
		//Change UserRegDto -> UserRegAccessBean
		UserRegMailAccessBean userRegAccessBean = modelMapper.map(userRegDto, UserRegMailAccessBean.class);
		 
		 final String recipientAddress = userRegAccessBean.getLogonId();
		    final String subject = "Registration Confirmation";
		    final String confirmationUrl = appUrl + "/mail-user/registrationConfirm?token=" + token;
		    final String message = messageSource.getMessage("message.regSuccLink", null, MAIL_MESSAGE, LocaleContextHolder.getLocale());

		    final SimpleMailMessage email = new SimpleMailMessage();
		    email.setTo(recipientAddress);
		    email.setSubject(subject);
		    email.setText(message + "\r\n" + confirmationUrl);
		    email.setFrom(env.getProperty("support.mail"));

		    return email;
	
	}

}
