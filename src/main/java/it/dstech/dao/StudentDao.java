package it.dstech.dao;

import java.util.ArrayList;

import it.dstech.model.Student;

public interface StudentDao {

	Student saveStudent(Student student);

	Student getStudentById(int id);

	ArrayList<Student> getListStudents();

	Student updateStudent(Student student);

	void deleteStudentById(int id);

	ArrayList<Student> getListStudentByCorso(int idCorso);

}
