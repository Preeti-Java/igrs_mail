/**
 * 
 */
package com.cg.neel.igrs.mail.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.neel.igrs.mail.users.utils.DateAudit;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Preeti
 * @Description : This table contains all registered users login info
 *
 */

@Entity
@Table(name = "USERREG")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRegMailAccessBean extends DateAudit  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERS_ID") //Foreign key to the USERS table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private UsersAccessBean
	 * userAccessBean;
	 */
	
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private UserDemoAccessBean
	 * userDemoAccessBean;
	 */
	/*
	 * @OneToOne(mappedBy = "userRegAccessBean") private AddressAccessBean
	 * addressAccessBean;
	 */
	
	/*
	 * @OneToMany(mappedBy = "userRegAccessBean") private List<MemberAccessBean>
	 * memberAccessBean;
	 */
	@OneToMany(mappedBy="userRegAccessBean", fetch = FetchType.EAGER)
	private List<RolesMailAccessBean> rolesAccessBeans;
	
	@Column(name="STATUS") //1=enabled 0=disabled
	private int status;
	
	@Column(name="LOGONID")
	private String logonId;
	
	@Column(name="MOBILENO")
	private String mobileNo;
	
	@Column(name="MOBILEVERIFIED")
	private boolean mobileVerified;
	
	@Column(name="LOGONPASSWORD")
	private String logonPassword;
	
	@Column(name="PASSWORDEXPIRED") //1=expired 0=not expired 
	private int passwordExpired;
	
	@Column(name="PASSWORDCREATION") //The last time the password for the user was created or updated.
	private Date passwordCreation;
	
	
}

