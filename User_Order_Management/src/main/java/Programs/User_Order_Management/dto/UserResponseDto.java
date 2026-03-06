package Programs.User_Order_Management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserResponseDto {

		private int id;
		private String email;
		private String role;
		
		public UserResponseDto(int id, String email, String role) {
			super();
			this.id = id;
			this.email = email;
			this.role = role;
		}
}
