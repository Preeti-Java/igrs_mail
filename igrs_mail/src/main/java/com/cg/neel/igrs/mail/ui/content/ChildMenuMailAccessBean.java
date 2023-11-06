/**
 * 
 */
package com.cg.neel.igrs.mail.ui.content;

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

import lombok.Data;

/**
 * @author Preeti
 * @Description : This table stores child menu of menu bar for UI with Hindi and English
 *
 */

@Entity
@Table(name="CHILDMENU")
@Data
public class ChildMenuMailAccessBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHILDMENU_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long childMenuId;
	
    @ManyToOne
    @JoinColumn(name="menuId") 
    private MenuMailAccessBean menuAccessBean;
    
    @OneToMany(mappedBy = "childMenuAccessBean",fetch = FetchType.EAGER)
    private List<ChildMenuRoleMailAccessBean> childMenuRoleAccessBeans;
    
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
