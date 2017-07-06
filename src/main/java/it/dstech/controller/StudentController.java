package it.dstech.controller;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Corso;
import it.dstech.model.Student;
import it.dstech.service.CorsoService;
import it.dstech.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger logger = Logger.getLogger(StudentController.class.getName());

	@Autowired
	private StudentService studentService;

	@Autowired
	private CorsoService corsoService;

	/**
	 * Return a new instance of Student in json.
	 * 
	 * @return
	 */
	@GetMapping("/getModel")
	public Student getModel() {
		return new Student();
	}

	/**
	 * Save a Student.
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		try {
			Student saved = studentService.saveStudent(student);
			logger.info("Student saved: " + saved);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Return a Student by id. Specify the id in url's PathVariable.
	 * 
	 * @param id
	 * @return Student
	 */
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		try {
			Student student = studentService.getStudentById(id);
			if (student == null)
				throw new Exception();
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Return a Student by id. Specify the id in header.
	 * 
	 * @param id
	 * @return Student
	 */
	@GetMapping("/getById")
	public ResponseEntity<Student> getStudent(@RequestHeader("id") int id) {
		try {
			Student student = studentService.getStudentById(id);
			if (student == null)
				throw new Exception();
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Get list of students.
	 * 
	 * @return
	 */
	@GetMapping("/getList")
	public ResponseEntity<ArrayList<Student>> getListStudents() {
		try {
			ArrayList<Student> listStudents = studentService.getListStudents();
			logger.info("List Students");
			return new ResponseEntity<>(listStudents, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Return a list of Student of one Course.
	 * 
	 * @param idCorso
	 * @return
	 */
	@GetMapping("/getListStudentsByCorso/{idCorso}")
	public ResponseEntity<ArrayList<Student>> getListStudentsByCorso(@PathVariable("idCorso") int idCorso) {
		try {
			ArrayList<Student> listStudents = studentService.getListStudentByCorso(idCorso);
			logger.info("List Students in corso");
			return new ResponseEntity<>(listStudents, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Update a Student.
	 * 
	 * @param student
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		try {
			Student updated = studentService.updateStudent(student);
			logger.info("Student updated");
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete a Student by id. Specify the id in url's PathVariable.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("id") int id) {
		try {
			studentService.deleteStudentById(id);
			logger.info("Student deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Aggiunge un corso a uno studente. Il corso deve prima essere creato.
	 * 
	 * @param idStudent
	 * @param idCorso
	 * @return
	 */
	@PostMapping("/addCorsoToStudent/{idStudent}/{idCorso}")
	public ResponseEntity<Student> addCorsoToStudent(@PathVariable("idStudent") int idStudent,
			@PathVariable("idCorso") int idCorso) {
		try {
			Corso corso = corsoService.getCorsoById(idCorso);
			Student student = studentService.getStudentById(idStudent);
			student.getListCorsi().add(corso);
			studentService.updateStudent(student);
			logger.info("Aggiunto corso a studente: " + student);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Rimuove l'asssociazione tra un corso e uno studente.
	 * 
	 * @param idStudent
	 * @param idCorso
	 * @return
	 */
	@DeleteMapping("/removeCorsoToStudent/{idStudent}/{idCorso}")
	public ResponseEntity<Student> removeCorsoToStudent(@PathVariable("idStudent") int idStudent,
			@PathVariable("idCorso") int idCorso) {
		try {
			Corso corso = corsoService.getCorsoById(idCorso);
			Student student = studentService.getStudentById(idStudent);
			student.getListCorsi().remove(corso);
			studentService.updateStudent(student);
			logger.info("Corso rimosso da studente: " + student);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
