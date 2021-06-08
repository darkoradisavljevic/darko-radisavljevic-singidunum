package darko.radisavljevic.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.Student;

@Repository

public class StudentsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public StudentsDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student", Student.class).getResultList();
	}

	@Transactional
	public Student getOneStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}

	@Transactional
	public boolean deleteStudent(Student student) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(student);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
		return true;
	}


}