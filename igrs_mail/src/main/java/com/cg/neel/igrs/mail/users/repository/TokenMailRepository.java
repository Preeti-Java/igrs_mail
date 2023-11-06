/**
 * 
 */
package com.cg.neel.igrs.mail.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.neel.igrs.mail.users.VerificationMailToken;

/**
 * @author Preeti
 *
 */

@Repository
public interface TokenMailRepository extends JpaRepository<VerificationMailToken, Long>{

	/**
	 * @param token
	 * @return VerificationToken
	 */
	VerificationMailToken findByToken(String token);
}
