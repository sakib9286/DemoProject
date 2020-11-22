package com.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.model.User;
import com.boot.service.UserService;

@Controller
@RequestMapping("/api")
public class MyController {

	@Autowired
	private UserService userService;

	// Show Home Page
	
	@GetMapping(value = { "/", "/home", "/index", "default" })
	public ModelAndView showHomePage() {
		return new ModelAndView("index");
	}
	// -----------------------------------------------------

	// Login

	@RequestMapping("/login-user")
	public ModelAndView loginUser(@ModelAttribute User user, HttpSession session ) {

		if (userService.Credential(user.getEmail(), user.getPassword()) != null) {
			
			session.setAttribute("email", user.getEmail());
			
			return new ModelAndView("redirect:/api/user");

		} else {
			return new ModelAndView("index");
		}

	}

	// Show user Form

	@GetMapping("/registration")
	public ModelAndView registrationForm() {
		ModelAndView mav = new ModelAndView("registartionpage");
		mav.addObject("userRegister", new User());
		return mav;
	}

	
	  public String MD5(String md5) { try 
	  {
		  java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5"); 
		  byte[] array = md.digest(md5.getBytes()); 
		  StringBuffer sb = new StringBuffer(); 
		  for (int i = 0; i < array.length; ++i) 
		  { 
			  sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3)); 
		  } 
		  return sb.toString(); 
		  } catch (
			  java.security.NoSuchAlgorithmException e) {
			  
		  } return null; 
		  }
	 
	// Save user details
	@PostMapping("/saveUserDetails")
	public ModelAndView createUser(@ModelAttribute("userRegister") User user, HttpServletRequest request) {
		
		  if(user.getId()==0 ) { user.setPassword(MD5(user.getPassword())); }else {
		  User temp = userService.getUserById(user.getId());
		  user.setPassword(temp.getPassword()); }
		 
		userService.saveOrUpdateUser(user);
		return new ModelAndView("redirect:/api/users");
	}

	// --------------------------------------------------------------
	// Update user By id
	@GetMapping("/updateUser/{id}")
	public ModelAndView editEmployee(@PathVariable("id") long id, Model model) {
		System.out.println(this.getClass().getSimpleName() + ":update user ..." + id);
		User user = userService.getUserById(id);
		user.setInterest(user.getInter().split(","));
		ModelAndView mav = new ModelAndView("registartionpage");
		mav.addObject("userRegister", user);
		model.addAttribute("testData", "testData");
		// model.addAttribute("passwords", user.getPassword());
		return mav;
	}

	// Delete User By id

	@GetMapping("/deleteUser/{id}")
	public ModelAndView removeEmployee(@PathVariable("id") long id) {
		System.out.println(this.getClass().getSimpleName() + ":deleting employee... " + id);
		userService.deleteUser(id);
		return new ModelAndView("redirect:/api/users");
	}

	// Show All Employee

	@GetMapping("/users")
	public ModelAndView showAllUsers() {
		ModelAndView mav = new ModelAndView("details"); // Here employees is a jsp page name
		List<User> userList = userService.getAllUsrs();

		mav.addObject("userLists", userList); // Set the attribute as "employeeList"
		return mav;
	}

	@GetMapping("/user")
	public ModelAndView showAllUser(@ModelAttribute User user, HttpSession session) {
		
		session.getAttribute(user.getEmail());
		
		ModelAndView mav = new ModelAndView("userdetail"); // Here employees is a jsp page name
		
		User userList = userService.getUserDetails(user.getEmail());

		mav.addObject("userList", userList); // Set the attribute as "employeeList"
		return mav;
	}

	
}
