package it.dstech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String nome;

	private int eta;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "stud_corsi", joinColumns = {
			@JoinColumn(name = "id_student", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_corsi", nullable = false) })
	private List<Corso> listCorsi = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public List<Corso> getListCorsi() {
		return listCorsi;
	}

	public void setListCorsi(List<Corso> listCorsi) {
		this.listCorsi = listCorsi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eta;
		result = prime * result + id;
		result = prime * result + ((listCorsi == null) ? 0 : listCorsi.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (eta != other.eta)
			return false;
		if (id != other.id)
			return false;
		if (listCorsi == null) {
			if (other.listCorsi != null)
				return false;
		} else if (!listCorsi.equals(other.listCorsi))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", eta=" + eta + "]";
	}

}
