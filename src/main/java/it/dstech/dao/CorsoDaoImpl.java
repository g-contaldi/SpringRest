package it.dstech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.model.Corso;

@Repository
@Transactional
public class CorsoDaoImpl extends AbstractDao implements CorsoDao {

	@Override
	public Corso saveCorso(Corso corso) {
		return (Corso) persist(corso);
	}

	@Override
	public Corso getCorsoById(int id) {
		Criteria criteria = getSession().createCriteria(Corso.class);
		return (Corso) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Corso> getListCorsi() {
		return (ArrayList<Corso>) getSession().createCriteria(Corso.class).list();
	}

	@Override
	public Corso updateCorso(Corso corso) {
		return (Corso) update(corso);
	}

	@Override
	public void deleteCorsoById(int id) {
		delete(getCorsoById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Corso> getListCorsiByStudent(int idStudent) {
		Criteria criteria = getSession().createCriteria(Corso.class, "corso");
		criteria.createAlias("corso.listStudents", "listStudents");
		return (ArrayList<Corso>) criteria.add(Restrictions.eq("listStudents.id", idStudent)).list();
	}

}
