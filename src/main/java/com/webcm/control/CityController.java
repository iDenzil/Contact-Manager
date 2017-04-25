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
import com.webcm.entity.Country;
import com.webcm.service.CityService;
import com.webcm.service.CountryService;

/**
 * Controller for handling all requests related to City objects.
 * 
 * Handles requests for CRUD operations and performs validation on the data using Hibernate Validator. 
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
 *
 */
@Controller
@RequestMapping("/city")
public class CityController {
	
	/**
	 * Injects the Country service into controller
	 */
	@Autowired
	private CountryService countryService;
	
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
	 * Handles the list cities request
	 * 
	 * Retrieves all the City entries from the DB into a list, adds the list to the model and passes it onto the appropriate view.
	 *  
	 * @param theModel	Model container for the result list
	 * @return 			City-list view
	 */
	@GetMapping("/list")
	public String listContacts(Model theModel){
		List<City> theCities = cityService.getCityList();
		theModel.addAttribute("cities", theCities);
		return "list-cities";
	}
	
	/**
	 * Handles the add city request
	 * 
	 * Creates a new City object and adds it to the model, for the form to store data in.
	 * Retrieves all the Country entries and adds it to the model - required for the dropdown country selection.
	 * 
	 * @param theModel	Model container with the data
	 * @return 			Add-city view
	 */
	@GetMapping("/addCityForm")
	public String addCity(Model theModel){
		City newCity = new City();
		theModel.addAttribute("addcity", newCity);
		
		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList); 
		return "add-city-form";
	}

	/**
	 * Handles the save city request received from the add-city page and validates the data
	 * 
	 * Redirected from the add-city form page containing the data in the model. 
	 * Data validation is requested using Valid annotation and the validation result is stored in the BindingResult object.
	 * If the result has errors, the user is returned back to the add-city form. Controller has to request the Country list again to populate the dropdown menu.
	 * IF the result has no errors, the save method is called and the user is redirected to the city-list page.  
	 * 
	 * @param saveCity	Model attribute containing the new city data
	 * @param bind		The validation result object
	 * @param theModel	Model container for Country list required to populate the dropdown menu
	 * @return			Redirects the user to the city-list page if validation contains no errors, add-city view if it does
	 */
	@PostMapping("/saveCity")
	public String saveCity (@Valid @ModelAttribute("addcity") City saveCity, BindingResult bind, Model theModel){
		if (bind.hasErrors()){
			List<Country> countryList = countryService.getCountryList(); //required for dropdown country list 
			theModel.addAttribute("countryoptions", countryList); 		 //required for dropdown country list
			return "add-city-form";
		}
		else {
			cityService.saveCity(saveCity);
			return "redirect:/city/list";
		}
	}

	/**
	 * Handles the update request from the city-list page
	 * 
	 * Uses the parameter ID to retrieve the selected City entry from the database. The add-city form uses this data to prepopulate the form.
	 * Retrieves the list of countries required for dropdown list selection. The data is placed in the model and the user redirected to the add-city view.
	 * 
	 * @param theId		ID of the selected city the update is being performed on
	 * @param theModel	Model container with the City and Country list data
	 * @return			Add-city form, prepopulated with the selected City object data
	 */
	@GetMapping("/update")
	public String updateCity(@RequestParam("cityId") long theId, Model theModel ){
		City theCity = cityService.getCity(theId);
		theModel.addAttribute("addcity", theCity);

		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList);
		return "add-city-form";
	}

	/**
	 * Handles the delete request from the city-list page
	 * 
	 * Uses the parameter ID to specify the City entry in the database.
	 * Calls the delete method and redirects the user back to the city-list page
	 * 
	 * @param theId	ID of the selected City the delete is requested for
	 * @return		Redirects the user back to the city-list page. On invalid delete attempt returns the error view
	 */
	@GetMapping("/delete")
	public String deleteCity(@RequestParam("cityId") long theId){
		try {
			cityService.deleteCity(theId);
		} catch(Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		} 
		return "redirect:/city/list";
	}

}
