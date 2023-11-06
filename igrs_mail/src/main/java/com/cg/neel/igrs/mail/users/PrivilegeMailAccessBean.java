/**
 * 
 */
package com.cg.neel.igrs.mail.users;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Description  PRIVILEGE -> READ,WRITE,DELETE,UPDATE,DOWNLOAD
 * 
 *  */

@Entity
@Table(name = "PRIVILEGE")
@Data
public class PrivilegeMailAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="PRIVILEGE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long privilegeId;
	

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private RolesMailAccessBean rolesAccessBean;

	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;

}
