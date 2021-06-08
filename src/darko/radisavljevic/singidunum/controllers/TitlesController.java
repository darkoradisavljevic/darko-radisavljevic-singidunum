package darko.radisavljevic.singidunum.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import darko.radisavljevic.singidunum.entities.Title;
import darko.radisavljevic.singidunum.services.TitlesService;

@Controller
public class TitlesController {

	@Autowired
	private TitlesService titlesService;

	@RequestMapping("/titles")
	public String ShowTitles(Model model) {
		List<Title> titles = titlesService.getAllTitles();
		model.addAttribute("titles", titles);
		return "titles";
	}

	@RequestMapping("createtitle")
	public String createTitle(Model model) {
		return "createtitle";
	}

	@RequestMapping(value = "/docreate-title", method = RequestMethod.POST)
	public String doCreateTitle(Model model, @Valid Title title) {
		titlesService.saveOrUpdateTitle(title);
		return "redirect:/titles";
	}

	@RequestMapping(value = "edit-title/{id}")
	public String editTitle(Model model, @PathVariable int id) {
		Title title = titlesService.getOneTitle(id);
		model.addAttribute("title", title);
		model.addAttribute(model);
		return "edittitle";
	}

	@RequestMapping(value = "/updatetitle", method = RequestMethod.POST)
	public String update(Model model, Title title) {
		titlesService.saveOrUpdateTitle(title);
		return "redirect:/titles";
	}

	@RequestMapping(value = "/deletetitle/{id}")
	public String deleteTitle(@PathVariable int id, Title title) {
		titlesService.deleteTitle(title);
		return "redirect:/titles";
	}

}
