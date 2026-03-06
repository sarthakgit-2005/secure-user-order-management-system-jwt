package Programs.User_Order_Management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import Programs.User_Order_Management.dto.OrderRequestDto;
import Programs.User_Order_Management.entity.OrderAccount;
import Programs.User_Order_Management.entity.UserAccount;
import Programs.User_Order_Management.repo.OrderRepo;
import Programs.User_Order_Management.repo.UserRepo;
import Programs.User_Order_Management.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private final OrderRepo orderRepo;
	private final UserRepo userRepo;

	public OrderServiceImpl(OrderRepo orderRepo ,UserRepo userRepo) {
		super();
		this.orderRepo = orderRepo;
		this.userRepo = userRepo;
	}

	@Override
	public OrderAccount createOrder(OrderRequestDto orderRequestDto, String email) {
		// TODO Auto-generated method stub
		
		UserAccount userAccount=userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
		OrderAccount orderAccount=new OrderAccount();
		orderAccount.setProductName(orderRequestDto.getProductName());
		orderAccount.setQuantity(orderRequestDto.getQuantity());
		orderAccount.setUser(userAccount);
		return orderRepo.save(orderAccount);
	}

	@Override
	public List<OrderAccount> getOrdersForUser(String email) {
		// TODO Auto-generated method stub
		
		UserAccount userAccount= userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("User Not Found"));
		return orderRepo.findByUser(userAccount);
	}

	@Override
	public List<OrderAccount> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}
}
