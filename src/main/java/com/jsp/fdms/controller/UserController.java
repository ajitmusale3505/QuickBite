package com.jsp.fdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.fdms.entity.Restaurant;
import com.jsp.fdms.entity.User;
import com.jsp.fdms.service.RestaurentService;
import com.jsp.fdms.service.UserService;
import com.jsp.fdms.service.UserServiceImpl;
 
import com.jsp.fdms.util.PasswordUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private RestaurentService restServ;
	
	@GetMapping("/")
	public String loginPage(HttpSession session, Model model) {
		 Object msg = session.getAttribute("msg");

		    if (msg != null) {
		        model.addAttribute("msg", msg);
		        session.removeAttribute("msg");  
		    }

		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public  String registerUser(@ModelAttribute User user, Model model) {	
	    String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
	    user.setPassword(hashedPassword);
		user.setRole("USER");
	    service.register(user);
		model.addAttribute("msg", "Reg Sucess");
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user,Model model, HttpSession session) {
		User isPresent = service.findByEmail(user.getEmail());
		
		if (isPresent==null) {
			model.addAttribute("msg","User Not Found");
			return "redirect:/";
		}
		
		String hashPassword = PasswordUtil.hashPassword(user.getPassword());
		
		System.out.println("Hashed Passwprd : "+hashPassword);
		
		if (hashPassword.equals(isPresent.getPassword())) {
			model.addAttribute("msg", "Login Sucessfull");
			session.setAttribute("user", isPresent);
			if (isPresent.getRole().equals("ADMIN")) {
				return  "admin_dashboard";
			}
			else if ("OWNER".equals(isPresent.getRole())) {

		        List<Restaurant> list = restServ.getByOwner(isPresent);

		        if (list == null || list.isEmpty()) {
		            return "add_restaurant";   // form page
		        } else {
		            model.addAttribute("restaurants", list);
		            return "owner_dashboard";
		        }
		    }
			else {
				model.addAttribute("restaurants", restServ.getAllRestaurent());
				return "user_dashboard";
			}
		}
		
		else {
//			model.addAttribute("msg", "Invalid Credentials");
			session.setAttribute("msg","Invalid Credentials");
			return "redirect:/";
		}
		
	}
	
	
	 @GetMapping("/userDashboard")
	    public String getUserDashboard(Model model) {
	    	model.addAttribute("restaurants", restServ.getAllRestaurent());
	    	return "user_dashboard";
	    }
	  
	 
	  @GetMapping("/help")
	    public String helpPage() {
	        return "help";
	    }
	  
	  
	  @PostMapping("/submitIssue")
	    public String submitIssue() {
	        // later you can store this in DB
	        return "redirect:/help";
	    }
	 

    
    // ================= FORGOT PASSWORD =================

    @GetMapping("/forgot")
    public String forgotPage(HttpSession session, Model model) {

        Object step = session.getAttribute("step");

        if (step == null) {
            step = "email";  // 👈 default
            session.setAttribute("step", step);
        }


        model.addAttribute("step", step);

        Object msg = session.getAttribute("msg");
        if (msg != null) {
            model.addAttribute("msg", msg);
            session.removeAttribute("msg");
        }

        return "forgot";
    }
    
    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email, HttpSession session) {

        User user = service.findByEmail(email);

        if (user == null) {
            session.setAttribute("msg", "Email not found");
            return "redirect:/forgot";
        }

        int otp = 100000 + new java.util.Random().nextInt(900000);

        session.setAttribute("otp", otp);
        session.setAttribute("resetEmail", email);
        session.setAttribute("otpTime", System.currentTimeMillis());

        session.setAttribute("step", "otp");  // 👈 important
        session.setAttribute("msg", "OTP is: " + otp);

        return "redirect:/forgot";
    }
    
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam int otp, HttpSession session) {

        Integer sessionOtp = (Integer) session.getAttribute("otp");

        if (sessionOtp == null) {
            session.setAttribute("msg", "Please generate OTP first");
            return "redirect:/forgot";
        }

        if (!sessionOtp.equals(otp)) {
            session.setAttribute("msg", "Invalid OTP");
            session.setAttribute("step", "otp"); // stay on OTP
            return "redirect:/forgot";
        }

        // ✅ OTP verified
        session.setAttribute("step", "reset");

        return "redirect:/forgot";
    }
    
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String password, HttpSession session) {

        String step = (String) session.getAttribute("step");

        // ❌ BLOCK if OTP not verified
        if (step == null || !step.equals("reset")) {
            session.setAttribute("msg", "Verify OTP first");
            return "redirect:/forgot";
        }

        String email = (String) session.getAttribute("resetEmail");

        if (email == null) {
            session.setAttribute("msg", "Session expired");
            return "redirect:/forgot";
        }

        User user = service.findByEmail(email);

        String hashed = PasswordUtil.hashPassword(password);
        user.setPassword(hashed);

        service.register(user);

        // cleanup
        session.removeAttribute("otp");
        session.removeAttribute("resetEmail");
        session.removeAttribute("step");

        session.setAttribute("msg", "Password reset successful");

        return "redirect:/";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
    
}
