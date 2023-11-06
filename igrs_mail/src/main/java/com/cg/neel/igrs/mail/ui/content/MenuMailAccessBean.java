/**
 * 
 */
package com.cg.neel.igrs.mail.ui.content;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Preeti
 * @Description : This table stores menu present in software with HIndi and English
 *   
 *
 */

@Entity
@Table(name="MENU")
@Data
public class MenuMailAccessBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuId;
	
	@OneToMany(mappedBy = "menuAccessBean")
	private List<ChildMenuMailAccessBean> childMenuAccessBean;
	
	@OneToMany(mappedBy = "menuAccessBean")
	private List<MenuRoleMailAccessBean> menuRoleAccessBeans;
	
	@Column(name="EN_LABEL")
	private String labelEn;

	@Column(name="HI_LABEL")
	private String labelHi;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="OPTCOUNTER")
	private int optCounter;
	
}
