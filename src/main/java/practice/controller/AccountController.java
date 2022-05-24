package practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import practice.model.Client;
import practice.model.User;
import practice.repository.ClientRepository;
import practice.repository.UserRepository;

@Slf4j
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public String account(Model model, HttpSession session) {
		if(session.getAttribute("currentUser") != null) {
			User user = (User) session.getAttribute("currentUser");
			model.addAttribute("user", user);
			String fullname = user.getFullName();
			model.addAttribute("fullname", fullname);
//			log.info("Current: " + user);
		}
		return "account";
	}
	
	@GetMapping("/create")
	public String createAccount(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("user", new User());
		return "createAccount";
	}
	
	@PostMapping("/create")
	public String registerAccount(User user, Client client) {
//		log.info("Hey");
		user.setActive(true);
		user.setRoles("ROLE_USER");
		user.setFullName(client.getFullname());
		userRepo.save(user);
		
		client.setUser(user);
		clientRepo.save(client);
//		log.info("Client: " + client);
		return "redirect:/";
	}
}
