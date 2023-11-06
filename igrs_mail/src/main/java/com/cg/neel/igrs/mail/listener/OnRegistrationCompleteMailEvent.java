/**
 * 
 */
package com.cg.neel.igrs.mail.listener;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.cg.neel.igrs.mail.users.UserRegMailAccessBean;

/**
 * @author Preeti
 *
 */
@SuppressWarnings("serial")
public class OnRegistrationCompleteMailEvent extends ApplicationEvent{

	private final String appUrl;
	private final Locale locale;
	private final UserRegMailAccessBean userRegAccessBean;
	
	
	/**
	 * @param appUrl
	 * @param locale
	 * @param userRegAccessBean
	 */
	public OnRegistrationCompleteMailEvent(final String appUrl, final Locale locale,
			final UserRegMailAccessBean userRegAccessBean) {
		super(userRegAccessBean);
		this.appUrl = appUrl;
		this.locale = locale;
		this.userRegAccessBean = userRegAccessBean;
	}

	/**
	 * @return the appUrl
	 */
	public String getAppUrl() {
		return appUrl;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the userRegAccessBean
	 */
	public UserRegMailAccessBean getUserRegAccessBean() {
		return userRegAccessBean;
	}
	
	

	
}
