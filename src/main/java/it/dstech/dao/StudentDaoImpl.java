package it.dstech.dao;

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

}
