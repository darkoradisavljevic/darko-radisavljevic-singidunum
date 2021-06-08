package darko.radisavljevic.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.ProfessorsDAO;
import darko.radisavljevic.singidunum.entities.Professor;

@Service("proffesorsService")
public class ProfessorsService {

	private ProfessorsDAO professorsDAO;

	@Autowired
	public void setProfessorsDao(ProfessorsDAO professorsDAO) {
		this.professorsDAO = professorsDAO;
	}

	public List<Professor> getAllProfessors() {
		return professorsDAO.getAllProfessors();
	}

	public Professor getOneProfessor(int professorId) {
		return professorsDAO.getOneProfessor(professorId);
	}

	public boolean deleteProfessor(Professor professor) {
		professorsDAO.deleteProfessor(professor);
		return true;
	}

	public boolean saveOrUpdateProfessor(Professor professor) {
		professorsDAO.saveOrUpdateProfessor(professor);
		return true;
	}

	public Professor getOneProfessorByName(String name) {
		return professorsDAO.getOneProfessorByName(name);
	}

}
