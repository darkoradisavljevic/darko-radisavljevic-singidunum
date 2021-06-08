package darko.radisavljevic.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import darko.radisavljevic.singidunum.entities.City;
import darko.radisavljevic.singidunum.services.CitiesService;

@Controller
public class CitiesController {

	@Autowired
	private CitiesService citiesService;

	@RequestMapping("/cities")
	public String ShowCities(Model model) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		return "cities";
	}

	@RequestMapping("createcity")
	public String createCity(Model model) {
		return "createcity";
	}

	@RequestMapping(value = "/docreate-city", method = RequestMethod.POST)
	public String doCreateCity(Model model, @Valid City city) {
		try {
			citiesService.saveOrUpdateCity(city);
			return "redirect:/cities";
		} catch (Exception e) {
			String message = "Invalid input!";
			model.addAttribute("message", message);
			return "createcity";
		}

	}

	@RequestMapping(value = "edit-city/{id}")
	public String editCity(Model model, @PathVariable int id) {
		City city = citiesService.getOneCity(id);
		model.addAttribute("city", city);
		model.addAttribute(model);
		return "editcity";
	}

	@RequestMapping(value = "/updatecity", method = RequestMethod.POST)
	public String update(Model model, City city) {
		citiesService.saveOrUpdateCity(city);
		return "redirect:/cities";
	}

	@RequestMapping(value = "/deletecity/{id}")
	public String deleteCity(@PathVariable int id, City city) {
		citiesService.deleteCity(city);
		return "redirect:/cities";
	}

}
