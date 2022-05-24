package practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import practice.model.User;
import practice.repository.UserRepository;

@Slf4j
@Controller
@RequestMapping("/authen")
@SessionAttributes("currentUser")
public class AuthenController {
	
	@Autowired
	private UserRepository userRepo;
	
	@ModelAttribute("currentUser")
	public User user() {
		return new User();
	}
	
	@GetMapping
	public String getUser(
			@ModelAttribute("currentUser") User currentUser
//			HttpSession session
			) {
		String currentUserName = SecurityContextHolder
				.getContext().getAuthentication().getName();
		User user = userRepo.findByUsername(currentUserName).orElse(null);
		if(user!=null) {
			currentUser.setup(user);
//			session.setAttribute("currentUser", user);
		}
		log.info("Current: " + currentUser);
		return "redirect:/";
		
	}
}
