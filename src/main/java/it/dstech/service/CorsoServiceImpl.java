package it.dstech.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.CorsoDao;
import it.dstech.model.Corso;

@Service
public class CorsoServiceImpl implements CorsoService {

	@Autowired
	private CorsoDao dao;

	@Override
	public Corso saveCorso(Corso corso) {
		return dao.saveCorso(corso);
	}

	@Override
	public Corso getCorsoById(int id) {
		return dao.getCorsoById(id);
	}

	@Override
	public ArrayList<Corso> getListCorsi() {
		return dao.getListCorsi();
	}

	@Override
	public Corso updateCorso(Corso corso) {
		return dao.updateCorso(corso);
	}

	@Override
	public void deleteCorsoById(int id) {
		dao.deleteCorsoById(id);
	}

	@Override
	public ArrayList<Corso> getListCorsiByStudent(int idStudent) {
		return dao.getListCorsiByStudent(idStudent);
	}

}
