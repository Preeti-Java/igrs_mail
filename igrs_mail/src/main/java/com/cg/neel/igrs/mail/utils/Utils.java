package com.cg.neel.igrs.mail.utils;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @author Preeti
 *
 */
@Component
public class Utils {
	

	/**
	 * @param request
	 * @return url
	 */
	public static String getAppUrl(HttpServletRequest request) {
		return "http://"+ request.getServerName()+":" + request.getServerPort() + request.getContextPath();
	}
	
}
