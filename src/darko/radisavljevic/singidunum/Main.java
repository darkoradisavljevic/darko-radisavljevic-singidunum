package darko.radisavljevic.singidunum;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import darko.radisavljevic.singidunum.entities.City;
import darko.radisavljevic.singidunum.entities.Exam;
import darko.radisavljevic.singidunum.entities.Professor;
import darko.radisavljevic.singidunum.entities.Student;
import darko.radisavljevic.singidunum.entities.Subject;
import darko.radisavljevic.singidunum.entities.Title;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Title title1 = new Title();
		Title title2 = new Title();
		Title title3 = new Title();
		Title title4 = new Title();

		title1.setName("Professor");
		title2.setName("Associate Professor");
		title3.setName("Assistant Professor");
		title4.setName("Instructor");

		City city1 = new City();
		City city2 = new City();

		city1.setName("Beograd");
		city1.setZipCode(11000);
		city2.setName("Novi Sad");
		city2.setZipCode(21000);

		Professor professor1 = new Professor();
		Professor professor2 = new Professor();
		Professor professor3 = new Professor();
		Professor professor4 = new Professor();

		String str = "2020-04-12";
		Date date = Date.valueOf(str);

		professor1.setFirstName("Miodrag");
		professor1.setLastName("Zivkovic");
		professor1.setEmail("dzivkovic@hotmail.com");
		professor1.setAddress("Milosa pocerca 12");
		professor1.setPhone("0656565654");
		professor1.setReelectionDate(date);

		professor2.setFirstName("Nebojsa");
		professor2.setLastName("Bacanin");
		professor2.setEmail("dzivkovic@hotmail.com");
		professor2.setAddress("Milosa pocerca 12");
		professor2.setPhone("0656565654");
		professor2.setReelectionDate(date);

		professor3.setFirstName("Angelina");
		professor3.setLastName("Njegus");
		professor3.setEmail("dzivkovic@hotmail.com");
		professor3.setAddress("Milosa pocerca 12");
		professor3.setPhone("0656565654");
		professor3.setReelectionDate(date);

		professor4.setFirstName("Milovan");
		professor4.setLastName("Milovanovic");
		professor4.setEmail("dzivkovic@hotmail.com");
		professor4.setAddress("Milosa pocerca 12");
		professor4.setPhone("0656565654");
		professor4.setReelectionDate(date);

		Student student1 = new Student();
		Student student2 = new Student();

		student1.setStudent_index("2017/120");
		student1.setFirstName("Darko");
		student1.setLastName("Radisavljevic");
		student1.setEmail("darko@hotmail.com");
		student1.setAddress("Jurija Gagarina 100");
		student1.setPhone("0661234325");
		student1.setCurrentYear(3);

		student2.setStudent_index("2017/121");
		student2.setFirstName("Marko");
		student2.setLastName("Markovic");
		student2.setEmail("darko@hotmail.com");
		student2.setAddress("Jurija Gagarina 100");
		student2.setPhone("0661234325");
		student2.setCurrentYear(2);

		city1.getProfessors().add(professor1);
		city1.getProfessors().add(professor2);
		city2.getProfessors().add(professor3);
		city2.getProfessors().add(professor4);
		city1.getStudents().add(student1);
		city1.getStudents().add(student2);
		title1.getProfessors().add(professor1);
		title1.getProfessors().add(professor2);
		title2.getProfessors().add(professor3);
		title3.getProfessors().add(professor4);

		professor1.setCity(city1);
		professor2.setCity(city1);
		professor3.setCity(city2);
		professor4.setCity(city2);
		student1.setCity(city1);
		student2.setCity(city1);
		professor1.setTitle(title1);
		professor2.setTitle(title1);
		professor3.setTitle(title2);
		professor4.setTitle(title3);

		Subject subject1 = new Subject();

		subject1.setName("Programming");
		subject1.setDescription("introducing in programning");
		subject1.setYearOfStudy(1);
		subject1.setSemester("Winter");
		subject1.setMaintenanceDate(date);

		Exam exam1 = new Exam();
		Exam exam2 = new Exam();

		exam1.setDateOfApplication(date);
		exam2.setDateOfApplication(date);
		subject1.getExams().add(exam1);
		student1.getExams().add(exam1);
		professor1.getExams().add(exam1);
		subject1.getExams().add(exam2);
		student2.getExams().add(exam2);
		professor1.getExams().add(exam2);

		exam1.setSubject(subject1);
		exam1.setStudent(student1);
		exam1.setProfessor(professor1);
		exam2.setSubject(subject1);
		exam2.setStudent(student2);
		exam2.setProfessor(professor1);

		session.save(city1);
		session.save(title1);
		session.save(professor1);
		session.save(professor2);
		session.save(title2);
		session.save(title3);
		session.save(title4);
		session.save(city2);
		session.save(professor3);
		session.save(professor4);
		session.save(student1);
		session.save(student2);
		session.save(subject1);
		session.save(exam1);
		session.save(exam2);

		session.getTransaction().commit();

		session.close();

		sessionFactory.close();

	}

}
