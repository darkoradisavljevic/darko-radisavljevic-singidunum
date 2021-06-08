package darko.radisavljevic.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.SubjectsDAO;
import darko.radisavljevic.singidunum.entities.Subject;

@Service("subjectsService")
public class SubjectsService {

	private SubjectsDAO subjectsDAO;

	@Autowired
	public void setSubjectsDao(SubjectsDAO subjectsDAO) {
		this.subjectsDAO = subjectsDAO;
	}

	public List<Subject> getAllSubjects() {
		return subjectsDAO.getAllSubjects();
	}

	public Subject getOneSubject(int subjectId) {
		return subjectsDAO.getOneSubject(subjectId);
	}

	public boolean deleteSubject(Subject subject) {
		subjectsDAO.deleteSubject(subject);
		return true;
	}

	public boolean saveOrUpdateSubject(Subject subject) {
		subjectsDAO.saveOrUpdateSubject(subject);
		return true;
	}

}
