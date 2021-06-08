package darko.radisavljevic.singidunum.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import darko.radisavljevic.singidunum.entities.Professor;
import darko.radisavljevic.singidunum.entities.Subject;
import darko.radisavljevic.singidunum.services.ProfessorsService;
import darko.radisavljevic.singidunum.services.SubjectsService;

@Controller
public class SubjectsController {

	@Autowired
	private SubjectsService subjectsService;

	@Autowired
	private ProfessorsService professorsService;

	@RequestMapping("/subjects")
	public String ShowSubjects(Model model) {
		List<Subject> subjects = subjectsService.getAllSubjects();
		model.addAttribute("subjects", subjects);
		return "subjects";

	}

	@RequestMapping("createsubject")
	public String createSubject(Model model) {
		return "createsubject";
	}

	@RequestMapping(value = "/docreate-subject", method = RequestMethod.POST)
	public String doCreateSubject(Model model, @Valid Subject subject) {
		subjectsService.saveOrUpdateSubject(subject);
		return "redirect:/subjects";
	}

	@RequestMapping(value = "edit-subject/{subjectId}")
	public String editSubject(Model model, @PathVariable int subjectId) {
		Subject subject = subjectsService.getOneSubject(subjectId);
		model.addAttribute("subject", subject);
		model.addAttribute(model);
		return "editsubject";
	}

	@RequestMapping(value = "/updatesubject", method = RequestMethod.POST)
	public String doUpdateSubject(Model model, Subject subject) {
		subjectsService.saveOrUpdateSubject(subject);
		return "redirect:/subjects";
	}

	@RequestMapping(value = "/deletesubject/{subjectId}")
	public String delete(@PathVariable int subjectId, Subject subject) {
		subjectsService.deleteSubject(subject);
		return "redirect:/subjects";
	}

	@RequestMapping(value = "/subject/professors/{subjectId}")
	public String subjectProfessors(@PathVariable int subjectId, Model model) {
		Subject subject = subjectsService.getOneSubject(subjectId);
		model.addAttribute("subject", subject);

		return "subjectprofessors";

	}

	@RequestMapping(value = "/subject/edit-professors/{subjectId}")
	public String editProfessorsInSubject(@PathVariable int subjectId, Model model, Professor professor) {
		Subject subject = subjectsService.getOneSubject(subjectId);
		model.addAttribute("subject", subject);
		Set<Professor> subProfessors = subject.getProfessors();
		model.addAttribute("subProfessors", subProfessors);
		List<Professor> professors = professorsService.getAllProfessors();
		model.addAttribute("professors", professors);

		return "editprofessorsinsubject";
	}

	@RequestMapping(value = "/subject/updateprofessors", method = RequestMethod.POST)
	public String subjectUpdateProfessors(Model model, Subject subject, Professor professor) {
		try {
			Subject subject1 = subjectsService.getOneSubject(subject.getSubjectId());
			Professor professor1 = professorsService.getOneProfessor(professor.getProfessorId());
			Set<Professor> profSet = subject1.getProfessors();
			profSet.add(professor1);
			subjectsService.saveOrUpdateSubject(subject1);

			return "redirect:/subjects";
		} catch (Exception e) {
			String message = "Not update professor for this subjects";
			model.addAttribute("message", message);
			ShowSubjects(model);
			return "redirect:/subjects";
		}
	}

	@RequestMapping(value = "/subject/deleteprofessor/{subjectId}/{professorId}")
	public String professorDeleteFromSubject(@PathVariable int subjectId, @PathVariable int professorId,
			Subject subject, Professor proffesor) {
		Subject subject1 = subjectsService.getOneSubject(subjectId);
		System.out.println("jedan " + subject1);
		Set<Professor> professors = subject1.getProfessors();
		System.out.println();

		Professor professor1 = professorsService.getOneProfessor(professorId);
		System.out.println("dva" + professor1);

		professors.remove(professor1);
		subject1.setProfessors(professors);
		System.out.println(professors);
		System.out.println("tri + " + subject1);

		subjectsService.saveOrUpdateSubject(subject1);
		System.out.println();

		return "redirect:/subjects";

	}

}
