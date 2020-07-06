package com.real.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
	String about = "Spring is a powerful, lightweight framework used for application development. In broader terms, you can say that the Spring framework is a well-defined tool that supports several web applications using Java as a programming language. ... Performance of the system got affected due to the heaviness of the applications.Oct 15, 2018\n";
	
	@GetMapping({"/","home"})
	String homepage(Model model) {
	model.addAttribute("msg", about);
		
		return "index";
		
	}
	
	@GetMapping("about")
	
	String aboutUs(Model model) {
		model.addAttribute("msg", about);
		return "about";
		
	}
	
	@GetMapping("contactus")
	
	String contactUs(Model model) {
		model.addAttribute("message", "Contact us page");
		return "contactus";
		
	}
	

	@GetMapping("login")
	String loginPage(Model model) {
		
		model.addAttribute("msg","Login");
	
		return "login";
	}
	@PostMapping("login")
	String login(RedirectAttributes redirect,Model model,@RequestParam String email, @RequestParam String password) {
		if(email.equals("a@mail.com")&&password.equals("1234")) {
		redirect.addFlashAttribute("success","***Login Succeed***");}
		else {
			model.addAttribute("error", "Invalid Input"+" " +email+" "+password);
			return "register";
		}
		return "redirect:/profile";
	}
	

	

	@GetMapping("profile")
	String profile(Model model) {
		
		model.addAttribute("msg","My Profile Page");
		
		return "profile";
	}
	
	@GetMapping("page")
	String getPage(Model model,@RequestParam String link,@RequestParam String name) {
		model.addAttribute("message","Link is "+ link+"and Name is "+name);
		return "contactus";
	}
	
	@GetMapping("pathvar-{link}-{name}")
	String getPaths(Model model,@PathVariable String link,@PathVariable String name) {
		model.addAttribute("message","Link is "+ link+"and Name is "+name);
		return "contactus";
	}
	
	
	
	@GetMapping("spring")
	@ResponseBody
	String aboutspring() {
		return "spring about"+about;
		
	}
}
