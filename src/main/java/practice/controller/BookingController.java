package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import practice.model.Booking;
import practice.model.Room;
import practice.model.User;
import practice.repository.RoomRepository;

@Controller
@RequestMapping("/booking")
@SessionAttributes("currentBooking")
public class BookingController {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@ModelAttribute("currentBooking")
	public Booking booking() {
		return new Booking();
	}
	
	@GetMapping("/{id}")
	public String booking(Model model, @PathVariable("id") String id, 
			@ModelAttribute("curentBooking") Booking currentBooking) {
		Room room = roomRepo.findById(id).orElse(null);
		if(room != null) {
			currentBooking.setRoom(room);
		}
		model.addAttribute("booking", currentBooking);
		model.addAttribute("room", room);
		return "bookingInfo";
	}
	
}
