package it.dstech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.model.Student;

@Repository
@Transactional
public class StudentDaoImpl extends AbstractDao implements StudentDao {

	@Override
	public Student saveStudent(Student student) {
		return (Student) persist(student);
	}

	@Override
	public Student getStudentById(int id) {
		Criteria criteria = getSession().createCriteria(Student.class);
		return (Student) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> getListStudents() {
		return (ArrayList<Student>) getSession().createCriteria(Student.class).list();
	}

	@Override
	public Student updateStudent(Student student) {
		return (Student) update(student);
	}

	@Override
	public void deleteStudentById(int id) {
		delete(getStudentById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Student> getListStudentByCorso(int idCorso) {
		Criteria criteria = getSession().createCriteria(Student.class, "student");
		criteria.createAlias("student.listCorsi", "listCorsi");
		return (ArrayList<Student>) criteria.add(Restrictions.eq("listCorsi.id", idCorso)).list();
	}

}
