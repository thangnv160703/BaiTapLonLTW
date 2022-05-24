//package practice.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttribute;
//
//import lombok.extern.slf4j.Slf4j;
//import practice.model.User;
//
//@Slf4j
//@Controller
//@RequestMapping("/logout")
//public class LogoutController {
//	@GetMapping
//	public String logout(@SessionAttribute("currentUser") User user) {
//		log.info("Log out: " + user);
//		return "logout";
//	}
//}
