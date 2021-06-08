package darko.radisavljevic.singidunum.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import darko.radisavljevic.singidunum.entities.City;


@Repository
public class CitiesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CitiesDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public List<City> getAllCities() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM City", City.class).getResultList();
	}
	
	@Transactional
	public City getOneCity(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(City.class, id);
	}

	@Transactional
	public boolean deleteCity(City city) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(city);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdateCity(City city) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(city);
		return true;
	}
	
}



