package darko.radisavljevic.singidunum.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import darko.radisavljevic.singidunum.entities.Exam;
import darko.radisavljevic.singidunum.entities.Professor;
import darko.radisavljevic.singidunum.entities.Student;
import darko.radisavljevic.singidunum.entities.Subject;
import darko.radisavljevic.singidunum.services.ExamsService;
import darko.radisavljevic.singidunum.services.ProfessorsService;
import darko.radisavljevic.singidunum.services.StudentsService;
import darko.radisavljevic.singidunum.services.SubjectsService;

@Controller
public class ExamsController {
	@Autowired
	private ExamsService examsService;

	@Autowired
	private StudentsService studentsService;

	@Autowired
	private SubjectsService subjectsService;

	@Autowired
	private ProfessorsService professorsService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/exams")
	public String ShowExams(Model model) {
		List<Exam> allExams = examsService.getAllExams();
		List<Student> students = studentsService.getAllStudents();
		List<Subject> subjects = subjectsService.getAllSubjects();
		List<Professor> professors = professorsService.getAllProfessors();
		model.addAttribute("students", students);
		model.addAttribute("subjects", subjects);
		model.addAttribute("professors", professors);
		model.addAttribute(model);
		model.addAttribute("allExams", allExams);
		return "allexams";
	}

	@RequestMapping(value = "/exams", method = RequestMethod.POST)
	public String ShowExams2(Model model, String index) {
		try {
			String indexI = index;
			Object object = examsService.checkStudent(indexI);
			Student student = Student.class.cast(object);
			int current = student.getCurrentYear();

			List<Student> students = examsService.listStudentChecked(current);
			List<Subject> subjects = subjectsService.getAllSubjects();
			List<Professor> professors = professorsService.getAllProfessors();
			if (object != null) {
				model.addAttribute("object", object);
				model.addAttribute("students", students);
				model.addAttribute("subjects", subjects);
				model.addAttribute("professors", professors);
				model.addAttribute("indexI", indexI);
				model.addAttribute(model);
				return "exams";
			} else {
				return "login";
			}
		} catch (NullPointerException e) {
			String message = "Invalid index number!";
			model.addAttribute("message", message);
			return "login";
		}
	}

	@RequestMapping(value = "/docreate-exam", method = RequestMethod.POST)
	public String doCreateExam(Model model, int id, int subjectId, int professorId, String indexI) {
		Student student = studentsService.getOneStudent(id);
		Professor professor = professorsService.getOneProfessor(professorId);
		List<Subject> subjects1 = examsService.validDateSubject();
		for (Subject subject2 : subjects1) {

			if (subject2.getSubjectId() == subjectId) {
				Exam exam = new Exam();
				exam.setStudent(student);
				exam.setSubject(subject2);
				exam.setProfessor(professor);
				Calendar calendar = Calendar.getInstance();
				exam.setDateOfApplication(new Date(calendar.getTime().getTime()));
				examsService.saveOrUpdateExam(exam);
				ShowExams(model);
				return "allexams";
			}
		}

		String message = "You can't apply for this subject, is not in range of 7 days";
		model.addAttribute("message", message);
		ShowExams2(model, indexI);
		return "exams";
	}

	@RequestMapping(value = "/deleteexam/{examId}")
	public String deleteExam(@PathVariable int examId, Exam exam, Model model) {
		examsService.deleteExam(exam);
		ShowExams(model);
		return "allexams";
	}

}
