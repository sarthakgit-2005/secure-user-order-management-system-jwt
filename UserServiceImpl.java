 package Programs.User_Order_Management.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Programs.User_Order_Management.dto.RegisterRequestDto;
import Programs.User_Order_Management.entity.UserAccount;
import Programs.User_Order_Management.exception.DuplicateResourceException;
import Programs.User_Order_Management.repo.UserRepo;
import Programs.User_Order_Management.service.UserService;

@Service
public class UserServiceImpl implements UserService{

		private final UserRepo userRepo;
		private final PasswordEncoder passwordEncoder;

		public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
			super();
			this.userRepo = userRepo;
			this.passwordEncoder = passwordEncoder;
		}

		@Override
		public void registeruser(RegisterRequestDto request) {
			// TODO Auto-generated method stub
			
			if(userRepo.existsByEmail(request.getEmail()))
					throw new DuplicateResourceException("Email already registered");
			
			UserAccount userAccount=new UserAccount();
			userAccount.setEmail(request.getEmail());
			userAccount.setPassword(passwordEncoder.encode(request.getPassword()));
			  
			String role=request.getRole();
			
			if(role==null || role.isBlank())
					role="ROLE_USER";
			else if(role.equalsIgnoreCase("ADMIN"))
					role="ROLE_ADMIN";
			else						//default
				role="ROLE_USER";
			
			userAccount.setRole(role);
	
			userRepo.save(userAccount);
		}

		@Override
		public UserAccount getUserByEmail(String email) {
			// TODO Auto-generated method stub
			return userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User Not Found"));
		}

		@Override
		public List<UserAccount> getAllUsers() {
			// TODO Auto-generated method stub
			return userRepo.findAll();
		}

		@Override
		public void deleteUserById(int id) {
			// TODO Auto-generated method stub
			
			if(!userRepo.existsById(id))
					throw new RuntimeException("User Not Found");
			userRepo.deleteById(id);
			
		}		
}
