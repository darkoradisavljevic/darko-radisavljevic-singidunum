package darko.radisavljevic.singidunum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import darko.radisavljevic.singidunum.dao.TitlesDAO;
import darko.radisavljevic.singidunum.entities.Title;

@Service
public class TitlesService {

	@Autowired
	private TitlesDAO titlesDAO;

	public List<Title> getAllTitles() {
		return titlesDAO.getAllTitles();
	}

	public Title getOneTitle(int id) {
		return titlesDAO.getOneTitle(id);
	}

	public boolean deleteTitle(Title title) {
		titlesDAO.deleteTitle(title);
		return true;
	}

	public boolean saveOrUpdateTitle(Title title) {
		titlesDAO.saveOrUpdateTitle(title);
		return true;
	}
}
