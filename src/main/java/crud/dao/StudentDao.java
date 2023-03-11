package crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crud.model.Student;

@Component
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create student
	@Transactional
	public void createStudent(Student student) {
		this.hibernateTemplate.saveOrUpdate(student);
	}
	
	//get all students
	public List<Student> getStudents(){
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	//delete single student
	@Transactional
	public void deleteStudent(int studentId) {
		Student load = this.hibernateTemplate.load(Student.class, studentId);
		this.hibernateTemplate.delete(load);
	}
	
	//get single student
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}
}
