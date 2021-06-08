package darko.radisavljevic.singidunum.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "professors", uniqueConstraints = @UniqueConstraint(columnNames = { "professor_id", "professor_email" }))
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id", updatable = false, nullable = false)
	private int professorId;
	@Column(name = "first_name", updatable = true, length = 30, nullable = false)
	@Size(min = 3)
	private String firstName;
	@Column(name = "last_name", updatable = true, length = 30, nullable = false)
	@Size(min = 3)
	private String lastName;
	@Column(name = "professor_email", updatable = true, length = 30, nullable = false)
	@Email
	private String email;
	@Column(name = "address", updatable = true, length = 50, nullable = false)
	@Size(min = 3)
	private String address;
	@Column(name = "phone", updatable = true, length = 15, nullable = false)
	@Size(min = 6)
	private String phone;
	@Column(name = "reelection_date", updatable = true, nullable = false)
	private Date reelectionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "title_id")
	private Title title;

	@ManyToMany(mappedBy = "professors", fetch = FetchType.EAGER)
	private Set<Subject> subjects = new HashSet<Subject>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "professor")
	private List<Exam> exams = new ArrayList<Exam>();

	public void addExam(Exam exam) {
		this.exams.add(exam);
	}

	public Professor() {

	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReelectionDate() {
		return reelectionDate;
	}

	public void setReelectionDate(Date reelectionDate) {
		this.reelectionDate = reelectionDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address=" + address + ", phone=" + phone + ", reelectionDate="
				+ reelectionDate + "]";
	}

}
