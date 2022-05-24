package practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import practice.model.Room;
import practice.repository.RoomRepository;

@Slf4j
@Controller
@RequestMapping("/view")
public class ViewController {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@GetMapping
	public String viewList(Model model) {
		List<Room> rooms = (List<Room>) roomRepo.findAll();
		model.addAttribute("rooms", rooms);
		return "view";
	}
	
	@GetMapping("/details/{id}")
	public String viewDetails(Model model, @PathVariable("id") String id) {
		Room room = roomRepo.findById(id).orElse(null);
		model.addAttribute("room", room);
		log.info("Room details");
		return "details";
	}
}
