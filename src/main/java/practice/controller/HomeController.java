package practice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;
import practice.model.User;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
//		if(user != null) {
//			model.addAttribute(user);
//		}
		if(session.getAttribute("currentUser") != null) {
			model.addAttribute("user", session.getAttribute("currentUser"));
		}
		return "homepage";
	}
	
	@GetMapping("/user")
	public String user() {
		return ("<h1>Hello user!</h1>");
	}
	
	@GetMapping("/admin")
	public String admin() {
		return ("<h1>Long time no see, admin.</h1>");
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		if(session.getAttribute("currentUser") != null) {
			return "logout";
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(@SessionAttribute("currentUser") User user) {
		log.info("Log out: " + user);
		return "logout";
	}
	
}
