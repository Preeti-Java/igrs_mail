/**
 * 
 */
package com.cg.neel.igrs.mail.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.neel.igrs.mail.ui.content.ChildMenuRoleMailAccessBean;
import com.cg.neel.igrs.mail.ui.content.MenuRoleMailAccessBean;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This table stores the roles defined, Once a role is created,
 *              you cannot change the name or description of a role
 *
 */

@Entity
@Table(name = "ROLES")
@Data
public class RolesMailAccessBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserRegMailAccessBean userRegAccessBean;

	@OneToMany(mappedBy = "rolesAccessBean", fetch = FetchType.EAGER)
	private List<PrivilegeMailAccessBean> privilegeAccessBean;

	@OneToMany(mappedBy = "rolesAccessBean")
	private List<MenuRoleMailAccessBean> menuRoleAccessBean;

	@OneToMany(mappedBy = "rolesAccessBean")
	private List<ChildMenuRoleMailAccessBean> childMenuRoleAccessBean;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "OPTCOUNTER")
	private int optCounter;

}
