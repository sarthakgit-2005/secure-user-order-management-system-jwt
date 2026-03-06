package Programs.User_Order_Management.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Programs.User_Order_Management.dto.OrderResponseDto;
import Programs.User_Order_Management.dto.UserResponseDto;
import Programs.User_Order_Management.service.OrderService;
import Programs.User_Order_Management.service.UserService;

@RestController // @ResponseBody + @Controller
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")	
public class AdminController {

		private final OrderService orderService;
		private final UserService userService;
		
		public AdminController(OrderService orderService, UserService userService) {
			super();
			this.orderService = orderService;
			this.userService = userService;
		}
		
		@GetMapping("/users")
		public ResponseEntity<List<UserResponseDto>> getAllUsers()
		{
			 List<UserResponseDto> users =userService.getAllUsers().stream().map(user -> new UserResponseDto(
			                            user.getId(),
			                            user.getEmail(),
			                            user.getRole()
			                    		)).toList();
			 
			 return ResponseEntity.ok(users);
		}
		
		 @GetMapping("/orders")
		 public ResponseEntity<List<OrderResponseDto>> getAllOrders() {

		        List<OrderResponseDto> orders =orderService.getAllOrders().stream().map(order -> new OrderResponseDto(
		                                order.getId(),
		                                order.getProductName(),
		                                order.getQuantity()
		                        		))
		                        .collect(Collectors.toList());

		        return ResponseEntity.ok(orders);
		}
		 
		 @DeleteMapping("/users/{id}")
		 public ResponseEntity<String> deleteUser(@PathVariable int id) {
		        
			 userService.deleteUserById(id);
		     return ResponseEntity.ok("User deleted successfully");
		    }
}


/*
 @PreAuthorize: Spring Security Annotation used to enforce method level security 
 It checks:
 	Roles (authorities)	
	Permissions
	Custom conditions (like checking the logged-in user’s ID)
	
	"hasRole('ADMIN')" is a SpEL (Spring Expression Language) expression.
	If the logged-in user does not have the ADMIN role, Spring Security will prevent access and throw an exception.
 */ 
