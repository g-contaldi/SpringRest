package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.dao.StudentDao;
import it.dstech.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	@Override
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

}
