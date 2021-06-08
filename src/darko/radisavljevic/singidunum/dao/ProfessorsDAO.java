package darko.radisavljevic.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.Professor;

@Repository

public class ProfessorsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProfessorsDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Professor> getAllProfessors() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Professor", Professor.class).getResultList();
	}

	@Transactional
	public Professor getOneProfessor(int professorId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Professor.class, professorId);
	}

	@Transactional
	public boolean deleteProfessor(Professor professor) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(professor);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateProfessor(Professor professor) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(professor);
		return true;
	}
	@Transactional
	public Professor getOneProfessorByName(String name) {
		System.out.println(name);
		Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Professor where firstName =" + name, Professor.class).getSingleResult();
      
   }

}