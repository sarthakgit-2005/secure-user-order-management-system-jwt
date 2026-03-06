package Programs.User_Order_Management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Programs.User_Order_Management.dto.AuthResponseDto;
import Programs.User_Order_Management.dto.LoginRequestDto;
import Programs.User_Order_Management.dto.RegisterRequestDto;
import Programs.User_Order_Management.security.JwtUtil;
import Programs.User_Order_Management.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
		private final UserService userService;
		private final JwtUtil jwtUtil;
		private final AuthenticationManager authenticationManager;
		
		public AuthController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
			super();
			this.userService = userService;
			this.jwtUtil = jwtUtil;
			this.authenticationManager = authenticationManager;
		}
		
		@PostMapping("/register")
		public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDto registerRequestDto)
		{
			    userService.registeruser(registerRequestDto);
				return ResponseEntity.ok("User Registered Successfully");
		}
		@PostMapping("/login")
		public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto request) 
		{
		        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

		        String token = jwtUtil.generateToken(authentication.getName());

		        return ResponseEntity.ok(new AuthResponseDto(token));
		    }
}

/*
 	@Valid : used in spring for Bean Validation 
 	It tells the spring to validate the input objects as per contraints defined in model/entity
 	
 	if the constraints are not satisfied it throws 
 	Exception:
 	MethodArgumentNotValidException or ConstraintViolationException
 	
 	package : jakarta.validation
 */
