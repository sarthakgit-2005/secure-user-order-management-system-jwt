package Programs.User_Order_Management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthResponseDto {

	private String token;
	private String type="Bearer";
	
	public AuthResponseDto(String token) {
		super();
		this.token = token;
	}
}
