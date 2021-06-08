package darko.radisavljevic.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.Subject;

@Repository
public class SubjectsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SubjectsDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Subject> getAllSubjects() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Subject", Subject.class).getResultList();
	}

	@Transactional
	public Subject getOneSubject(int subjectId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Subject.class, subjectId);
	}

	@Transactional
	public boolean deleteSubject(Subject subject) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(subject);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateSubject(Subject subject) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(subject);
		return true;
	}

}
