package darko.radisavljevic.singidunum.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "city", uniqueConstraints = @UniqueConstraint(columnNames = {"city_id"}))
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id", updatable = false, length = 10, nullable = false)
	private int id;
	@Column(name = "zip_code", updatable = true, nullable = false)
	private int zipCode;
	@Column(name = "name", updatable = true, length = 30, nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
	private List<Professor> professors = new ArrayList<Professor>();

	public void addProfessor(Professor professor) {
		this.professors.add(professor);
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "city")
	private List<Student> students = new ArrayList<Student>();

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public City() {

	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", zipCode=" + zipCode + ", name=" + name + "]";
	}

}
