package Programs.User_Order_Management.service;

import java.util.List;

import Programs.User_Order_Management.dto.OrderRequestDto;
import Programs.User_Order_Management.entity.OrderAccount;

public interface OrderService {

	OrderAccount createOrder(OrderRequestDto orderRequestDto , String email);
	List<OrderAccount>  getOrdersForUser(String email);				
	List<OrderAccount> getAllOrders();			// for Admin
}
