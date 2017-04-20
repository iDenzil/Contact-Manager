package com.webcm.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcm.entity.Contact;
import com.webcm.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	//inject the contact service into the controller
	@Autowired
	private ContactService contactService;
	
	
	@GetMapping("/about")
	public String about(Model theModel){
		//contactService.doTest();  testna metoda, obrisati kasnije
		return "about";
	}
	
	@GetMapping("/settings")
	public String settings(){
		return "settings";
	}
	
	
	@GetMapping("/list")
	public String listContacts(Model theModel){
		
		// get contacts from the service
		List<Contact> theContacts = contactService.getContacts();
		// add the contacts and sexall to the model
		theModel.addAttribute("contacts", theContacts);
		//System.out.println(theContacts);
		return "list-contacts";
	}
	
	@GetMapping("/addContactForm")
	public String addContact(Model theModel){
		
		//create model attribute to bind form data
		Contact newContact = new Contact();
		theModel.addAttribute("addcontact", newContact);

		
		//List<Sex> sexAll = contactService.getSexAll();  //get full sex table from the DB via service impl
		//theModel.addAttribute("sexall", sexAll);   // add the contacts and sexall to the model

		/*to je sve tu zbog radiobuttonsa za add-contact-form skupa sa implementacijom metode getSexAll
		<td><form:radiobuttons items="${addcontact.sex}" path="sex.id"></form:radiobuttons></td>
		ali trenutno nije implementirano jer imam pametnijeg posla */
		
		return "add-contact-form";
	}
	
	@PostMapping("/saveContact")
	public String saveContact (@ModelAttribute("contact") Contact saveContact){
		contactService.saveContact(saveContact);
		return "redirect:/contact/list";
	}

	@GetMapping("/update")
	public String showUpdateFor(@RequestParam("contactId") long theId, Model theModel ){
		//get the contact from the DB via service
		Contact theContact = contactService.getContact(theId);
		
		//set the contact as model to prepopulate the form
		theModel.addAttribute("addcontact", theContact); System.out.println("added contact attribute");

		return "add-contact-form";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") long theId, Model theModel){
		//delete the contact
		contactService.deleteContact(theId);
		return "redirect:/contact/list";
	}
}
