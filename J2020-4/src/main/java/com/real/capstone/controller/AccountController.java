package com.real.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.real.capstone.dao.UserRepository;
import com.real.capstone.model.Users;
@Controller
public class AccountController {
@Autowired
	private UserRepository userRepository;
	
	@GetMapping("register")
	String registerPage(Model model) {
		
		model.addAttribute("msg","Register");
		model.addAttribute("user", new Users());
	
		return "register";
	}
	
	@PostMapping("register")
	String register(@ModelAttribute Users user, RedirectAttributes redirect) {
		
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			redirect.addFlashAttribute("error", "User Exists");
			return "redirect:/register";
		};
		
		user.setRole("User");
		userRepository.save(user);
		redirect.addFlashAttribute("msg", "Registration Success");
		redirect.addFlashAttribute("user_account", user);
		
		
		return "redirect:/profile";
	}
	
	
	@GetMapping("admin")
	String admin(Model model) {
		
		model.addAttribute("msg","admin");
		model.addAttribute("users", userRepository.findAll());
	
		return "admin";
	}
}
