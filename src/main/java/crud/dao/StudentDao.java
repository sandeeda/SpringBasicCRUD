package crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import crud.model.Student;

@Component
public class StudentDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createStudent(Student student) {
		String sql = "INSERT INTO student (studentId, firstName, lastName, course) " + "VALUES (?, ?, ?, ?) "
				+ "ON DUPLICATE KEY UPDATE " + "firstName = VALUES(firstName), " + "lastName = VALUES(lastName), "
				+ "course = VALUES(course)";
		jdbcTemplate.update(sql, student.getStudentId(), student.getFirstName(), student.getLastName(), student.getCourse());

	}

	// get all students
	public List<Student> getStudents() {
		String sql = "SELECT * FROM student";
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

	// delete single student
	public void deleteStudent(int studentId) {
		String sql = "DELETE FROM student WHERE studentId=?";
		jdbcTemplate.update(sql, studentId);
	}

	// get single student
	public Student getStudent(int studentId) {
		String sql = "SELECT * FROM student WHERE studentId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { studentId }, new StudentRowMapper());
	}

	// RowMapper for Student class
	class StudentRowMapper implements RowMapper<Student> {
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt("studentId"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setCourse(rs.getString("course"));
			return student;
		}
	}
}
