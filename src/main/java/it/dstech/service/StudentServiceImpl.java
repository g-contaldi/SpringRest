package it.dstech.service;

import java.util.ArrayList;

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

	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteStudentById(id);
	}

	@Override
	public ArrayList<Student> getListStudents() {
		return studentDao.getListStudents();
	}

	@Override
	public ArrayList<Student> getListStudentByCorso(int idCorso) {
		return studentDao.getListStudentByCorso(idCorso);
	}

}
