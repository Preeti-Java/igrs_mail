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
 * @Description : This table show relation between child menu of menu bar and roles for UI with Hindi and English
 *
 */

@Entity
@Table(name="CHILDMENUROLE")
@Data
public class ChildMenuRoleMailAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHILDMENUROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long childMenuRoleId;
    
	@ManyToOne
	@JoinColumn(name ="roleId")
	private RolesMailAccessBean rolesAccessBean;
	
	@ManyToOne
	@JoinColumn(name ="childMenuId")
	private ChildMenuMailAccessBean childMenuAccessBean;
    
	
}
