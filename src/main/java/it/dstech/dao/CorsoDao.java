package it.dstech.dao;

import java.util.ArrayList;

import it.dstech.model.Corso;

public interface CorsoDao {

	Corso saveCorso(Corso corso);

	Corso getCorsoById(int id);

	ArrayList<Corso> getListCorsi();

	Corso updateCorso(Corso corso);

	void deleteCorsoById(int id);

	ArrayList<Corso> getListCorsiByStudent(int idStudent);

}
