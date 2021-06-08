package darko.radisavljevic.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.Title;

@Repository
public class TitlesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TitlesDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<Title> getAllTitles() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Title", Title.class).getResultList();
	}
	
	@Transactional
	public Title getOneTitle(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Title.class, id);
	}

	@Transactional
	public boolean deleteTitle(Title title) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(title);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateTitle(Title title) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(title);
		return true;
	}
	
}
