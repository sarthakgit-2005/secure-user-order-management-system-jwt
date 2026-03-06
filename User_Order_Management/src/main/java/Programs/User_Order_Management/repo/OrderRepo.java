package Programs.User_Order_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Programs.User_Order_Management.entity.OrderAccount;
import Programs.User_Order_Management.entity.UserAccount;


@Repository
public interface OrderRepo extends JpaRepository<OrderAccount, Integer>{
	
	List<OrderAccount> findByUser(UserAccount user);
	/*
	List<OrderAccount>findByUserId(int id);
	
	dont write findByUserId unless you have an userId field explicitly defined in OrderAccount 
	write findByUser it automatically find the user by id 
	*/
}	
