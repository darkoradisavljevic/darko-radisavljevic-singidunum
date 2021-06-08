package darko.radisavljevic.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.StudentsDAO;
import darko.radisavljevic.singidunum.entities.Student;

@Service("studentsService")
public class StudentsService {

	private StudentsDAO studentsDAO;

	@Autowired
	public void setStudentsDao(StudentsDAO studentsDAO) {
		this.studentsDAO = studentsDAO;
	}

	public List<Student> getAllStudents() {
		return studentsDAO.getAllStudents();
	}

	public Student getOneStudent(int id) {
		return studentsDAO.getOneStudent(id);
	}

	public boolean deleteStudent(Student student) {
		studentsDAO.deleteStudent(student);
		return true;
	}

	public boolean saveOrUpdateStudent(Student student) {
		studentsDAO.saveOrUpdateStudent(student);
		return true;
	}


}
