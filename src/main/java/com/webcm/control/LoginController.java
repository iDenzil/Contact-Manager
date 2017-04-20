package com.webcm.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {
	

	@GetMapping("/welcome")
	public String showLogin(Model model){		
		model.addAttribute("name", getLoggedInUserName(model));
		return "welcome";
	}

	
	/**
	 * Spring security. Method retrieves the username of the logged in user.
	 * @param model Model container that contains the username.
	 * @return Username of the current user.
	 */
	
	private String getLoggedInUserName(Model model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	} 

	/**
	 * Logout functionality.
	 * Retreives the current user, checks to see if it-s not null and then logs out the user.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
		}
		return "redirect:/";
	}

}
