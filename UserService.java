package Programs.User_Order_Management.service;

import java.util.List;

import Programs.User_Order_Management.dto.RegisterRequestDto;
import Programs.User_Order_Management.entity.UserAccount;

public interface UserService {

	void	registeruser(RegisterRequestDto request);
	
	//UserAccount	registeruser(RegisterRequestDto request);
	
	UserAccount getUserByEmail(String email);
	
	//ADMIN
	List<UserAccount> getAllUsers();		//for Admin Purpose (Admin Controller)
	
	//ADMIN
	void deleteUserById(int id);
}
