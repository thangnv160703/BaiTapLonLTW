package practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String fullName;
	private boolean active;
	private String roles;
	
	public void setup(User user2) {
		this.id = user2.id;
		this.username = user2.username;
		this.password = user2.password;
		this.fullName = user2.fullName;
		this.active = user2.active;
		this.roles = user2.roles;
	}
}
