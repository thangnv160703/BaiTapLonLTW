package practice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(targetEntity = Room.class, cascade = CascadeType.MERGE)
	private Room room;
	
	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.MERGE)
	private Client client;
	
	private Date checkin;
	private Date checkout;
	private Long totalPrice;
	private boolean isCheckIn;
	private boolean isPaid;
	private String note;
}
