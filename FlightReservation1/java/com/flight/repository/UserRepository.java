package com.flight.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
// spring data generate query for the user as select * from user where email = ?;
	User findByEmail(String email);

	
	
}
