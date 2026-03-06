package Programs.User_Order_Management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderRequestDto {

	@NotBlank
	private String productName;
	
	@NotNull
	private int quantity;
	
}
