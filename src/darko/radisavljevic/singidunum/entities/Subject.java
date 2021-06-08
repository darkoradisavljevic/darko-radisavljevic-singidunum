package darko.radisavljevic.singidunum.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "subjects", uniqueConstraints = { @UniqueConstraint(columnNames = "subject_id") })
public class Subject {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((professors == null) ? 0 : professors.hashCode());
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
		Subject other = (Subject) obj;
		if (professors == null) {
			if (other.professors != null)
				return false;
		} else if (!professors.equals(other.professors))
			return false;
		return true;
	}

	@Id
	@Column(name = "subject_id", updatable = false, length = 10, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	@Column(name = "name", updatable = true, length = 30, nullable = false)
	@Size(min = 3)
	private String name;
	@Column(name = "description", length = 200)
	private String description;
	@Column(name = "year_of_study", length = 1)
	private int yearOfStudy;
	@Column(name = "semester", length = 10)
	private String semester;
	private Date maintenanceDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "subject_professor", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private Set<Professor> professors = new HashSet<Professor>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "subject")
	private List<Exam> exams = new ArrayList<Exam>();

	public void addExam(Exam exam) {
		this.exams.add(exam);
	}

	public Subject() {

	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public Set<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", description=" + description + ", yearOfStudy="
				+ yearOfStudy + ", semester=" + semester + ", maintenanceDate=" + maintenanceDate + "]";
	}

}
