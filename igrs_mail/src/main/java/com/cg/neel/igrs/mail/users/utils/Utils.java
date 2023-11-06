package com.cg.neel.igrs.mail.users.utils;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Preeti
 *
 */
public class Utils {
	
	private Utils() {
		throw new IllegalStateException("Utils Class");
	}

	/**
	 * @return today date
	 */
	public static Date getDate() {
	    return new Date();
	}

	/**
	 * @return local time
	 */
	public static LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}

	/**
	 * @param request
	 * @return url
	 */
	public static String getAppUrl(HttpServletRequest request) {
		return "http://"+ request.getServerName()+":" + request.getServerPort() + request.getContextPath();
	}
	
}
