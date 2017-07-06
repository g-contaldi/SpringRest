package it.dstech.service;

import java.util.ArrayList;

import it.dstech.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	Student getStudentById(int id);

	ArrayList<Student> getListStudents();

	Student updateStudent(Student student);

	void deleteStudentById(int id);

	ArrayList<Student> getListStudentByCorso(int idCorso);

}
