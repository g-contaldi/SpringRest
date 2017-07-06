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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.model.Corso;
import it.dstech.service.CorsoService;

@RestController
@RequestMapping("/corso")
public class CorsoController {

	private static final Logger logger = Logger.getLogger(CorsoController.class.getName());

	@Autowired
	private CorsoService service;

	/**
	 * Return a new instance of Corso in json.
	 * 
	 * @return
	 */
	@GetMapping("/getModel")
	public Corso getModel() {
		return new Corso();
	}

	/**
	 * Save a new Corso.
	 * 
	 * @param corso
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Corso> saveCorso(@RequestBody Corso corso) {
		try {
			Corso saved = service.saveCorso(corso);
			logger.info("Corso saved: " + saved);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Get corso by id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getCorsoById/{id}")
	public ResponseEntity<Corso> getCorsoById(@PathVariable int id) {
		try {
			Corso corso = service.getCorsoById(id);
			if (corso == null)
				throw new Exception();
			return new ResponseEntity<>(corso, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * get list Corsi.
	 * 
	 * @return
	 */
	@GetMapping("/getListCorsi")
	public ResponseEntity<ArrayList<Corso>> getListCorsi() {
		try {
			ArrayList<Corso> listCorsi = service.getListCorsi();
			return new ResponseEntity<>(listCorsi, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Return a list of Course from one Student.
	 * 
	 * @param idStudent
	 * @return
	 */
	@GetMapping("/getListCorsiByStudent/{idStudent}")
	public ResponseEntity<ArrayList<Corso>> getListCorsiByStudent(@PathVariable int idStudent) {
		try {
			ArrayList<Corso> listCorsi = service.getListCorsiByStudent(idStudent);
			return new ResponseEntity<>(listCorsi, HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Update a Course.
	 * 
	 * @param corso
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<Corso> updateCorso(@RequestBody Corso corso) {
		try {
			Corso updated = service.updateCorso(corso);
			logger.info("Corso saved: " + updated);
			return new ResponseEntity<>(updated, HttpStatus.CREATED);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete a Course.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Corso> deleteCorsoById(@PathVariable("id") int id) {
		try {
			service.deleteCorsoById(id);
			logger.info("Corso deleted");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
