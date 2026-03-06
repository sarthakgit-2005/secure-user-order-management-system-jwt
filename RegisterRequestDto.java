package Programs.User_Order_Management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequestDto {

		@Email
	    @NotBlank
	    private String email;

	    @NotBlank
	    private String password;
	    
	    //optional part
	    private String role;
	    

}
