/**
 * 
 */
package com.cg.neel.igrs.mail.users;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Des Store Unique token for register user with expiryDate
 *
 */
@Data
@Entity
@Table(name = "VERIFICATIONTOKEN") 
public class VerificationMailToken implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int EXPIRATION = 60 * 24;
	
	@Id
	@Column(name = "VERIFICATIONTOKEN_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long verificationTokenId;
	
	
	@Column(name = "TOKEN")
	private String token;
	
	@OneToOne(targetEntity = UserRegMailAccessBean.class, 	fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,
	             name = "user_Id",
	             foreignKey = @ForeignKey (name = "FK_VERIFY_USER"))
	private UserRegMailAccessBean userRegMailAccessBean;
	
	@Column(name = "EXPIRYDATE")
	private Date expiryDate;
	
	public VerificationMailToken() {
		super();
	}
	
	public VerificationMailToken(final String token) {
		super();
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public VerificationMailToken(final String token, final UserRegMailAccessBean userRegAccessBean) {
		super();
		
		this.token = token;
		this.userRegMailAccessBean =  userRegAccessBean;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
		
	}
	
	/**
	 * @param expiration2
	 * @return
	 */
	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}

}
