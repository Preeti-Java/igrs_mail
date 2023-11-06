/**
 * 
 */
package com.cg.neel.igrs.mail.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.mail.users.UserRegMailAccessBean;

/**
 * @author User
 *
 */
@Repository
public interface UserRegMailRepository extends JpaRepository<UserRegMailAccessBean, Long>{

	/**
	 * @param username - mobile No
	 * @return List
	 */
	UserRegMailAccessBean findByLogonId(String username);
	
	

}
