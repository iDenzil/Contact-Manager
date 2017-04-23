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
import com.webcm.entity.Country;
import com.webcm.service.CityService;
import com.webcm.service.CountryService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private CityService cityService;	
		
	@GetMapping("/list")
	public String listContacts(Model theModel){
		
		List<City> theCities = cityService.getCityList();
		theModel.addAttribute("cities", theCities);

		return "list-cities";
	}
	
	@GetMapping("/addCityForm")
	public String addCity(Model theModel){

		City newCity = new City();
		theModel.addAttribute("addcity", newCity);
		
		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model
		
		return "add-city-form";
	}

	@PostMapping("/saveCity")
	public String saveCity ( @ModelAttribute("addcity") City saveCity){
		cityService.saveCity(saveCity);
		return "redirect:/city/list";
	}

	@GetMapping("/update")
	public String updateCity(@RequestParam("cityId") long theId, Model theModel ){
		
		City theCity = cityService.getCity(theId);
		theModel.addAttribute("addcity", theCity);   // add the cityList to the model

		List<Country> countryList = countryService.getCountryList();
		theModel.addAttribute("countryoptions", countryList);   // add the countryList to the model

		return "add-city-form";
	}
	
	@GetMapping("/delete")
	public String deleteCity(@RequestParam("cityId") long theId, Model theModel){
		//delete the contact
		cityService.deleteCity(theId);
		return "redirect:/city/list";
	}
}
