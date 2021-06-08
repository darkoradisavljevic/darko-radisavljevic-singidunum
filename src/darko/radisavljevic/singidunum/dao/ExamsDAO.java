package darko.radisavljevic.singidunum.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.Exam;
import darko.radisavljevic.singidunum.entities.Student;
import darko.radisavljevic.singidunum.entities.Subject;

@Repository
public class ExamsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ExamsDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Exam> getAllExams() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Exam", Exam.class).getResultList();
	}

	@Transactional
	public Exam getOneExam(int examId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Exam.class, examId);
	}

	@Transactional
	public boolean deleteExam(Exam exam) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(exam);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateExam(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(exam);
		return true;
	}

	@Transactional
	public Object checkStudent(String index) {
		Session session = sessionFactory.getCurrentSession();
		String query = ("From Student Where student_index= '" + index + "'");
		return session.createQuery(query).uniqueResult();

	}

	@Transactional
	public List<Student> listStudentChecked(int currentYear) {
		Session session = sessionFactory.getCurrentSession();
		String query = ("From Student  Where  currentYear <= '" + currentYear + "'");
		return session.createQuery(query, Student.class).getResultList();

	}

	@Transactional
	public List<Subject> validDateSubject() {
		Session session = sessionFactory.getCurrentSession();
		String query = ("From Subject where datediff(maintenanceDate, now()) between 0 and 7");
		return session.createQuery(query, Subject.class).getResultList();

	}

}
