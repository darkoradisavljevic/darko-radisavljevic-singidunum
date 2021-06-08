package darko.radisavljevic.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.CitiesDAO;
import darko.radisavljevic.singidunum.entities.City;
@Service("citiesService")
public class CitiesService {
	
	@Autowired
	private CitiesDAO citiesDAO;
	
	
	
	public List<City> getAllCities () {
		return citiesDAO.getAllCities();
	}
	public City getOneCity (int id) {
		return citiesDAO.getOneCity(id);
	}
	
	public boolean deleteCity(City city) {
		citiesDAO.deleteCity(city);
		return true;
	}
	
	public boolean saveOrUpdateCity(City city) {
		citiesDAO.saveOrUpdateCity(city);
		return true;
	}
}
