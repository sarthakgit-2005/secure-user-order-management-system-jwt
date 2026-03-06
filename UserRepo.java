package Programs.User_Order_Management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Programs.User_Order_Management.entity.UserAccount;

@Repository
public interface UserRepo extends JpaRepository<UserAccount, Integer> {

	Optional<UserAccount> findByEmail(String email);	//fetches a single user from database
	boolean existsByEmail(String email);					//check whether user with already  that email exists or not 
	
}
