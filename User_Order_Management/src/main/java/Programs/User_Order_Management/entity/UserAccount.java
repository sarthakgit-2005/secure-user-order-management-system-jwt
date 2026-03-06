package Programs.User_Order_Management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_account")
@Getter
@Setter

public class UserAccount {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(unique=true, nullable=false)
		private String email;
		
		@Column(nullable=false)
		private String password;
		
		@Column(nullable=false)
		private String role;
		
		@OneToMany(mappedBy="user",cascade=CascadeType.REMOVE , fetch=FetchType.LAZY)
		private List<OrderAccount> order;
}
