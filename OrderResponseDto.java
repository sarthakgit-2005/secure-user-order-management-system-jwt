package Programs.User_Order_Management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderResponseDto {

		private int id;
		private String productName;
		private int quantity;
		
		public OrderResponseDto(int id, String poductName, int quantity) {
			super();
			this.id = id;
			this.productName = poductName;
			this.quantity = quantity;
		}
}
