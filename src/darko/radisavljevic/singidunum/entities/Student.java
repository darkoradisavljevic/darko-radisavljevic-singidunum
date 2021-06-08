package darko.radisavljevic.singidunum.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = { "student_id", "index_number",
		"student_email" }))
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id", updatable = false, length = 10, nullable = false)
	private int id;
	@Size(min = 3)
	@Column(name = "index_number", updatable = true, length = 10, nullable = false)
	private String student_index;
	@Size(min = 3)
	@Column(name = "first_name", updatable = true, length = 30, nullable = false)
	private String firstName;
	@Size(min = 3)
	@Column(name = "last_name", updatable = true, length = 30, nullable = false)
	private String lastName;
	@Email
	@Column(name = "student_email", updatable = true, length = 30, nullable = false)
	private String email;
	@Size(min = 3)
	@Column(name = "address", updatable = true, length = 50, nullable = false)
	private String address;
	@Size(min = 6)
	@Column(name = "phone", updatable = true, length = 15, nullable = false)
	private String phone;
	@Column(name = "current_year_of_study", updatable = true, length = 7, nullable = false)
	private int currentYear;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
	private List<Exam> exams = new ArrayList<Exam>();

	public void addExam(Exam exam) {
		this.exams.add(exam);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_index() {
		return student_index;
	}

	public void setStudent_index(String student_index) {
		this.student_index = student_index;
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

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", student_index=" + student_index + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", address=" + address + ", phone=" + phone + ", currentYear="
				+ currentYear + "]";
	}

}
