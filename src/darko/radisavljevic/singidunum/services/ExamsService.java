package darko.radisavljevic.singidunum.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.ExamsDAO;
import darko.radisavljevic.singidunum.entities.Exam;
import darko.radisavljevic.singidunum.entities.Student;
import darko.radisavljevic.singidunum.entities.Subject;

@Service("examsService")
public class ExamsService {

	@Autowired
	private ExamsDAO examsDAO;

	public List<Exam> getAllExams() {
		return examsDAO.getAllExams();
	}

	public Exam getOneExam(int id) {
		return examsDAO.getOneExam(id);
	}

	public boolean deleteExam(Exam exam) {
		examsDAO.deleteExam(exam);
		return true;
	}

	public boolean saveOrUpdateExam(Exam exam) {
		examsDAO.saveOrUpdateExam(exam);
		return true;
	}

	public Object checkStudent(String index) {
		return examsDAO.checkStudent(index);

	}

	public List<Student> listStudentChecked(int currentYear) {
		return examsDAO.listStudentChecked(currentYear);
	}

	public List<Subject> validDateSubject() {
		return examsDAO.validDateSubject();
	}

}
