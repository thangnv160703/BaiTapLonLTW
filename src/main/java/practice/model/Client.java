package practice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullname;
	private String idCard;
	private String phoneNumber;
	private String email;
	private String address;
	private String bankAccount;
	private String note;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.MERGE)
	private User user;
}
