package com.webcm.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webcm.entity.City;
import com.webcm.entity.Contact;
import com.webcm.entity.Sex;
import com.webcm.service.CityService;
import com.webcm.service.ContactService;
/**
 * Controller for handling all requests related to Contact objects.
 * 
 * Handles requests for CRUD operations and performs validation on the data using Hibernate Validator. 
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017.
 *
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
	
	/**
	 * Injects the Contact service into controller
	 */
	@Autowired
	private ContactService contactService;
	
	/**
	 * Injects the City service into controller
	 */
	@Autowired
	private CityService cityService;	
	
	/**
	 * Performs white space trimming on Strings as a part of validation process.
	 * 
	 * Removes leading and trailing white space from String objects.
	 * If String only has white space it will be trimmer down to NULL object.
	 * Annotation InitBinder works as a pre-processor - it will pre-process each web request to the controller.
	 * Constructs a StringTrimmerEditor (part of Spring API) with the argument TRUE - forces the white space trimm down to NULL.
	 * Uses WebDataBinder to register this as a custom editor and apply it to every String class.
	 * 
	 * @param dataBinder	WebDataBinder object used to register the custom editor
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor sTrim = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, sTrim);
	}
	
	/**
	 * Handles the list contacts request
	 * 
	 * Retrieves all the Contact entries from the DB into a list, adds the list to the model and passes it onto the appropriate view.
	 *  
	 * @param theModel	Model container for the result list
	 * @return			Contact-list view
	 */
	@GetMapping("/list")
	public String listContacts(Model theModel){
		List<Contact> theContacts = contactService.getContacts();
		theModel.addAttribute("contacts", theContacts);
		return "list-contacts";
	}
	
	/**
	 * Handles the add contact request
	 * 
	 * Creates a new Contact object and adds it to the model, for the form to store data in.
	 * Retrieves all the Sex and City entries and adds them to the model - required for the dropdown selection.
	 * 
	 * @param theModel	Model container with the data
	 * @return			Add-contact view
	 */
	@GetMapping("/addContactForm")
	public String addContact(Model theModel){
		Contact newContact = new Contact();
		theModel.addAttribute("addcontact", newContact);

		List<Sex> sexList = contactService.getSexList();
		theModel.addAttribute("sexoptions", sexList);
		List<City> cityList = cityService.getCityList();
		theModel.addAttribute("cityoptions", cityList);

		return "add-contact-form";
	}
	
	/**
	 * 
	 * Handles the save contact request received from the add-contact page and validates the data
	 * 
	 * Redirected from the add-contact form page containing the data in the model. 
	 * Data validation is requested using Valid annotation and the validation result is stored in the BindingResult object.
	 * If the result has errors, the user is returned back to the add-contact form. Controller has to request the City/Sex list again to populate the dropdown menu.
	 * IF the result has no errors, the save method is called and the user is redirected to the contact-list page.  
	 * 
	 * @param saveContact	Model attribute containing the new contact data
	 * @param bind			The validation result object
	 * @param theModel		Model container for City/Sex list required to populate the dropdown menus
	 * @return				Redirects the user to the contact-list page if validation contains no errors, add-contact view if it does
	 */
	@PostMapping("/saveContact")
	public String saveContact (@Valid @ModelAttribute("addcontact") Contact saveContact, BindingResult bind, Model theModel){  // na neku foru ovdje umjesto atributa addcontact moze biti bilokaj - TESTIRANO
		if (bind.hasErrors()){
			List<Sex> sexList = contactService.getSexList();	//required for dropdown sex list
			theModel.addAttribute("sexoptions", sexList);	 	//required for dropdown sex list
			List<City> cityList = cityService.getCityList();	//required for dropdown city list 
			theModel.addAttribute("cityoptions", cityList); 	//required for dropdown city list
			return "add-contact-form";							//validation failed -> return to add-form
		}
		else {													
			contactService.saveContact(saveContact);			//validation passed -> call Save method
			return "redirect:/contact/list";
		}
	}
	
	/**
	 * Handles the update request from the contact-list page
	 * 
	 * Uses the parameter ID to retrieve the selected Contact entry from the database. The add-contact form uses this data to prepopulate the form.
	 * Retrieves the cities/sex list required for dropdown list selection. The data is placed in the model and the user redirected to the add-city view.
	 * 
	 * @param theId		ID of the selected contact the update is being performed on
	 * @param theModel	Model container with the Contact and City/Sex list data
	 * @return			Add-contact form, prepopulated with the selected Contact object data
	 */
	@GetMapping("/update")
	public String updateContact(@RequestParam("contactId") long theId, Model theModel ){
		Contact theContact = contactService.getContact(theId);
		theModel.addAttribute("addcontact", theContact);
		
		List<Sex> sexList = contactService.getSexList();
		theModel.addAttribute("sexoptions", sexList);	
		List<City> cityList = cityService.getCityList();
		theModel.addAttribute("cityoptions", cityList);
		
		return "add-contact-form";
	}
	
	/**
	 * Handles the delete request from the contact-list page
	 * 
	 * Uses the parameter ID to specify the Contact entry in the database.
	 * Calls the delete method and redirects the user back to the contact-list page
	 * 
	 * @param theId	ID of the selected Contact the delete is requested for
	 * @return		Redirects the user back to the contact-list page
	 */
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("contactId") long theId){
		contactService.deleteContact(theId);
		return "redirect:/contact/list";
	}
}
