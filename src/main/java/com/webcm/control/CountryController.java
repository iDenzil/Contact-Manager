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

import com.webcm.entity.Country;
import com.webcm.service.CountryService;

/**
 * Controller for handling all requests related to Country objects.
 * 
 * Handles requests for CRUD operations and performs validation on the data using Hibernate Validator. 
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
 *
 */
@Controller
@RequestMapping("/country")
public class CountryController {

	/**
	 * Injects the Country service into controller
	 */
	@Autowired
	private CountryService countryService;

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
		StringTrimmerEditor sTrim = new StringTrimmerEditor(true); //contrusctor argument TRUE trims whitespace down to null
		dataBinder.registerCustomEditor(String.class, sTrim);
	}

	/**
	 * Handles the list countries request
	 * 
	 * Retrieves all the Country entries from the DB into a list, adds the list to the model and passes it onto the appropriate view.
	 *  
	 * @param theModel	Model container for the result list
	 * @return 			Country-list view
	 */
	@GetMapping("/list")
	public String listCountries(Model theModel){
		List<Country> theCountries = countryService.getCountryList();
		theModel.addAttribute("countries", theCountries);
		return "list-countries";
	}

	/**
	 * Handles the add country request
	 * 
	 * Creates a new Country object and adds it to the model, for the form to store data in.
	 * 
	 * @param theModel	Model container with the data
	 * @return 			Add-country view
	 */
	@GetMapping("/addCountryForm")
	public String addCountry(Model theModel){
		Country newCountry = new Country();
		theModel.addAttribute("addcountry", newCountry);
		return "add-country-form";
	}

	/**
	 * 
	 * Handles the save country request received from the add-country page and validates the data
	 * 
	 * Redirected from the add-country form page containing the data in the model. 
	 * Data validation is requested using Valid annotation and the validation result is stored in the BindingResult object.
	 * If the result has errors, the user is returned back to the add-country form.
	 * If the result has no errors, data is validated against database, the save method is called and the user is redurected to the country-list page.  
	 * 
	 * @param saveCountry	Model attribute containing the new country data
	 * @param bind			The validation result object
	 * @return				Redirects the user to the country-list page if validation contains no errors, add-country view if it does
	 */
	@PostMapping("/saveCountry")
	public String saveCountry (@Valid @ModelAttribute("addcountry") Country saveCountry, BindingResult bind){
		if (bind.hasErrors()) return "add-country-form";							//validation failed -> return to add-form
		else {																		//validation passed -> call Save method
			if (countryService.saveCountry(saveCountry)) return "error-exist";		//TRUE return value -> error view 
			return "redirect:/country/list";										//FALSE return value -> save is complete, redirect to the list
		}
	}

	/**
	 * Handles the update request from the country-list page
	 * 
	 * Uses the parameter ID to retrieve the selected Country entry from the database. The add-country form uses this data to prepopulate the form.
	 * The data is placed in the model and the user redirected to the add-city view.
	 * 
	 * @param theId		ID of the selected country the update is being performed on
	 * @param theModel	Model container with the Country object
	 * @return			Add-country form, prepopulated with the selected Country object data
	 */
	@GetMapping("/update")
	public String updateCountry(@RequestParam("countryId") long theId, Model theModel ){
		Country theCountry = countryService.getCountry(theId);
		theModel.addAttribute("addcountry", theCountry);
		return "add-country-form";
	}
	
	/**
	 * Handles the delete request from the country-list page
	 * 
	 * Uses the parameter ID to specify the Country entry in the database.
	 * Calls the delete method and redirects the user back to the city-list page
	 * 
	 * @param theId	ID of the selected Countryy the delete is requested for
	 * @return		Redirects the user back to the country-list page
	 */
	@GetMapping("/delete")
	public String deleteCountry(@RequestParam("countryId") long theId){
		if (countryService.deleteCountry(theId)) return "error-delete";		//calls boolean Delete. If TRUE return value -> error view 
		return "redirect:/country/list";									//FALSE return value -> delete is complete, redirect to the list
	}
}
