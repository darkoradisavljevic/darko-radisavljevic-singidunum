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
import darko.radisavljevic.singidunum.entities.Student;
import darko.radisavljevic.singidunum.services.CitiesService;
import darko.radisavljevic.singidunum.services.StudentsService;

@Controller
public class StudentsController {

	@Autowired
	private StudentsService studentsService;

	@Autowired
	private CitiesService citiesService;

	@RequestMapping("/students")
	public String ShowStudents(Model model) {
		List<City> cities = citiesService.getAllCities();
		List<Student> students = studentsService.getAllStudents();
		model.addAttribute("cities", cities);
		model.addAttribute("students", students);
		return "students";

	}

	@RequestMapping("createstudent")
	public String createStudent(Model model) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		return "createstudent";
	}

	@RequestMapping(value = "/docreate-student", method = RequestMethod.POST)
	public String doCreateStudent(Model model, @Valid Student student) {
		List<City> cities = citiesService.getAllCities();
		try {
			studentsService.saveOrUpdateStudent(student);
			return "redirect:/students";
		} catch (Exception e) {
			String message = "Invalid inputs!";
			model.addAttribute("message", message);
			model.addAttribute("cities", cities);
			return "createstudent";
		}
	}

	@RequestMapping(value = "edit-student/{id}")
	public String editStudent(Model model, @PathVariable int id) {
		List<City> cities = citiesService.getAllCities();
		model.addAttribute("cities", cities);
		Student student = studentsService.getOneStudent(id);
		model.addAttribute("student", student);
		model.addAttribute(model);
		return "editstudent";
	}

	@RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
	public String doUpdateStudent(Model model, Student student) {
		studentsService.saveOrUpdateStudent(student);
		return "redirect:/students";
	}

	@RequestMapping(value = "/deletestudent/{id}")
	public String delete(@PathVariable int id, Student student) {
		studentsService.deleteStudent(student);
		return "redirect:/students";
	}

}
