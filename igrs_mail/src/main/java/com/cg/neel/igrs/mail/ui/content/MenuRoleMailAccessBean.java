/**
 * 
 */
package com.cg.neel.igrs.mail.ui.content;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.neel.igrs.mail.users.RolesMailAccessBean;

import lombok.Data;

/**
 * @author Preeti
 * @Description :  This table show relation between   menu bar and roles software with HIndi and English
 *   
 *
 */

@Entity
@Table(name="MENUROLE")
@Data
public class MenuRoleMailAccessBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENUROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuRoleId;
	
	
	@ManyToOne
	@JoinColumn(name ="roleId")
	private RolesMailAccessBean rolesAccessBean;
	
	@ManyToOne
	@JoinColumn(name ="menuId")
	private MenuMailAccessBean menuAccessBean;
	    
}
