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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling welcome and the login/logout functionality
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017. 
 *
 */
@Controller
public class LoginController {
	
	/**
	 * Redirects user to the welcome page.
	 * 
	 * Uses model to pass on the name of the username to be displayed on the welcome page.
	 * 
	 * @param model	Model container that holds the username
	 * @return		The Welcome view.
	 */
	@GetMapping("/welcome")
	public String showLogin(Model model){		
		model.addAttribute("name", getLoggedInUserName(model));
		return "welcome";
	}
	
	/**
	 * Handles the About request
	 * 
	 * Redirects user to the appropriate view
	 * 
	 * @return	About view
	 */
	@GetMapping("/about")
	public String about(){
		return "about";
	}
	
	/**
	 * Handles the Settings request
	 * 
	 * Redirects user to the appropriate view
	 * 
	 * @return	Settings view
	 */
	@GetMapping("/settings")
	public String settings(){
		return "settings";
	}

	/**
	 * Mapping method for redirecting access-denied error to the custom view page.
	 * 
	 * 403 mapping is called exclusively through Spring security, configured in SecurityConfiguration.java.
	 * When user logged in with USER role attempts to UPDATE or DELETE a Database entry, 403 is called.
	 *  
	 * @return Redirect to the access denied page
	 */
	@RequestMapping("/403")
	public String accessDenied(){
		return "403";
	}

	/**
	 * Spring security method that retrieves the username of the logged in user.
	 * 
	 * @param model	Model container that holds the username.
	 * @return		Username of the current user.
	 */
	private String getLoggedInUserName(Model model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	} 

	/**
	 * Spring security logout functionality.
	 * 
	 * Retrieves the current username, verifies it's not null, logs out the user and redirects to the login page.
	 * 
	 * @param request	Servlet request
	 * @param response	Servlet response
	 * @return			Redirect to the login page
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
