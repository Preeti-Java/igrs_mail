/**
 * 
 */
package com.cg.neel.igrs.mail.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.neel.igrs.mail.users.utils.DateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Preeti
 * @Description : This dto contains all registered users login info
 *
 */

@Data
@EqualsAndHashCode(callSuper=false)
//@PasswordMatches
public class UserRegDto extends DateAudit{
	
	@ToString.Exclude
	private int status;
	
	@NotNull
	private Long userId;

	@NotNull
//	@Size(min = 10, max = 10, message = "{Size.userRegDto.mobile}")
//	@ValidMobile
	private String logonId; //Mobile Number or Email Id
	
	@NotNull
	//@ValidPassword
	@Size(min = 1, message = "{Size.userRegDto.password}")
	private String logonPassword;
	
	@NotNull
	private String mobileNo;
	
	@NotNull
	private boolean mobileVerified;
	
	@NotNull
	@Size(min = 1)
	@ToString.Exclude
	private String logonMatchPassword;
	
	@ToString.Exclude
	private int passwordExpired;
	
	@ToString.Exclude
	private Date passwordCreation;
	
	
}

