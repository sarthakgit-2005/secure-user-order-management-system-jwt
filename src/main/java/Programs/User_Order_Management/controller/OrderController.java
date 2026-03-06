package Programs.User_Order_Management.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Programs.User_Order_Management.dto.OrderRequestDto;
import Programs.User_Order_Management.dto.OrderResponseDto;
import Programs.User_Order_Management.entity.OrderAccount;
import Programs.User_Order_Management.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")			//user
public class OrderController {

		private final OrderService orderService;

		public OrderController(OrderService orderService) {
			this.orderService = orderService;
		}
		
		@PostMapping("/order")
		public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto requestDto , Principal principal)
		{
			OrderAccount account=orderService.createOrder(requestDto, principal.getName());
			return ResponseEntity.ok(new OrderResponseDto(account.getId(), account.getProductName(), account.getQuantity()));
		}
		
		@GetMapping("/getAll")
		public ResponseEntity<List<OrderResponseDto>> getMyOrders(Principal principal)
		{
			List<OrderResponseDto> orders =
		            orderService.getOrdersForUser(principal.getName())
		                    .stream()
		                    .map(order -> new OrderResponseDto(
		                            order.getId(),
		                            order.getProductName(),     // ✅ FIXED
		                            order.getQuantity()
		                    ))
		                    .toList(); // ✅ Java 16+
			
			return ResponseEntity.ok(orders);
		}
}
