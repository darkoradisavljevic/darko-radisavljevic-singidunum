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
import darko.radisavljevic.singidunum.entities.Professor;
import darko.radisavljevic.singidunum.entities.Title;
import darko.radisavljevic.singidunum.services.CitiesService;
import darko.radisavljevic.singidunum.services.ProfessorsService;
import darko.radisavljevic.singidunum.services.TitlesService;

@Controller
public class ProfessorsController {

	@Autowired
	private ProfessorsService professorsService;

	@Autowired
	private CitiesService citiesService;

	@Autowired
	private TitlesService titlesService;

	@RequestMapping("/professors")
	public String ShowProfessors(Model model) {
		List<Professor> professors = professorsService.getAllProfessors();
		List<City> cities = citiesService.getAllCities();
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("cities", cities);
		model.addAttribute("titles", titles);
		model.addAttribute("professors", professors);
		return "professors";

	}

	@RequestMapping("createprofessor")
	public String createProfessor(Model model) {
		List<City> cities = citiesService.getAllCities();
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("cities", cities);
		model.addAttribute("titles", titles);
		return "createprofessor";
	}

	@RequestMapping(value = "/docreate-professor", method = RequestMethod.POST)
	public String doCreateProfessor(Model model, @Valid Professor professor) {
		List<City> cities = citiesService.getAllCities();
		List<Title> titles = titlesService.getAllTitles();
		try {
			professorsService.saveOrUpdateProfessor(professor);
			return "redirect:/professors";
		} catch (Exception e) {
			String message = "Invalid inputs!";
			model.addAttribute("message", message);
			model.addAttribute("cities", cities);
			model.addAttribute("titles", titles);
			return "createprofessor";
		}
	}

	@RequestMapping(value = "edit-professor/{professorId}")
	public String editProfessor(Model model, @PathVariable int professorId) {
		List<City> cities = citiesService.getAllCities();
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("cities", cities);
		model.addAttribute("titles", titles);
		Professor professor = professorsService.getOneProfessor(professorId);
		model.addAttribute("professor", professor);
		model.addAttribute(model);
		return "editprofessor";
	}

	@RequestMapping(value = "/updateprofessor", method = RequestMethod.POST)
	public String doUpdateStudent(Model model, Professor professor) {
		professorsService.saveOrUpdateProfessor(professor);
		return "redirect:/professors";
	}

	@RequestMapping(value = "/deleteprofessor/{professorId}")
	public String delete(@PathVariable int professorId, Professor professor) {
		professorsService.deleteProfessor(professor);
		return "redirect:/professors";
	}

}