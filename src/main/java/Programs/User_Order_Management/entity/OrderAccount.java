package Programs.User_Order_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_account")
@Getter
@Setter

public class OrderAccount {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		private String productName;
		
		private int quantity;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id" ,nullable=false)
		private UserAccount user;
}
