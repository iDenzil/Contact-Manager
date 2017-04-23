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

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		StringTrimmerEditor sTrim = new StringTrimmerEditor(true); //contrusctor argument TRUE trims whitespace down to null
		dataBinder.registerCustomEditor(String.class, sTrim);
	}

	@GetMapping("/list")
	public String listCountries(Model theModel){
		
		List<Country> theCountries = countryService.getCountryList();
		theModel.addAttribute("countries", theCountries);

		return "list-countries";
	}
	
	@GetMapping("/addCountryForm")
	public String addCountry(Model theModel){

		Country newCountry = new Country();
		theModel.addAttribute("addcountry", newCountry);
		
		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model
		
		return "add-country-form";
	}

	@PostMapping("/saveCountry")
	public String saveCountry (@Valid @ModelAttribute("addcountry") Country saveCountry, BindingResult bind){
		if (bind.hasErrors()) return "add-country-form";
		else {
			countryService.saveCountry(saveCountry);
			return "redirect:/country/list";
		}
	}

	@GetMapping("/update")
	public String updateCountry(@RequestParam("countryId") long theId, Model theModel ){
		
		Country theCountry = countryService.getCountry(theId);
		theModel.addAttribute("addcountry", theCountry);   // add the countryList to the model

		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model

		return "add-country-form";
	}
	
	@GetMapping("/delete")
	public String deleteCountry(@RequestParam("countryId") long theId, Model theModel){
		countryService.deleteCountry(theId);
		return "redirect:/country/list";
	}
	
}
