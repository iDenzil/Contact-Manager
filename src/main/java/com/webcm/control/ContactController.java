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

import com.webcm.entity.City;
import com.webcm.entity.Contact;
import com.webcm.entity.Sex;
import com.webcm.service.CityService;
import com.webcm.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	//inject the contact service into the controller
	@Autowired
	private ContactService contactService;
	@Autowired
	private CityService cityService;	
	
	
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

		List<Sex> sexList = contactService.getSexList();  //get full sex table from the DB via service impl
		theModel.addAttribute("sexoptions", sexList);   // add the sexList to the model

		List<City> cityList = cityService.getCityList();
		theModel.addAttribute("cityoptions", cityList);   // add the cityList to the model

//		List<Country> countryList = contactService.getCountryList();
//		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model
		
		return "add-contact-form";
	}
	
	@PostMapping("/saveContact")
	public String saveContact (@ModelAttribute("addcontact") Contact saveContact){  // na neku foru ovdje umjesto atributa addcontact moze biti bilokaj - TESTIRANO
		contactService.saveContact(saveContact);
		return "redirect:/contact/list";
	}

	@GetMapping("/update")
	public String updateContact(@RequestParam("contactId") long theId, Model theModel ){
		
		Contact theContact = contactService.getContact(theId);  //get the contact from the DB via service
		theModel.addAttribute("addcontact", theContact);  //set the contact as model to prepopulate the form
		
		List<Sex> sexList = contactService.getSexList();  //get full sex table from the DB via service impl
		theModel.addAttribute("sexoptions", sexList);   // add the sexList to the model
		
		List<City> cityList = cityService.getCityList();
		theModel.addAttribute("cityoptions", cityList);   // add the cityList to the model

//		List<Country> countryList = contactService.getCountryList();
//		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model
		return "add-contact-form";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") long theId, Model theModel){
		//delete the contact
		contactService.deleteContact(theId);
		return "redirect:/contact/list";
	}
}
