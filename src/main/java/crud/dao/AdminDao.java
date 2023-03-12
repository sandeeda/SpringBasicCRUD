package crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import crud.model.Admin;

@Component
public class AdminDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//get all admins
	public List<Admin> getAdmins(){
		String sql = "SELECT * FROM admin";
		return jdbcTemplate.query(sql, new AdminRowMapper());
	}
	
	// RowMapper for Student class
		class AdminRowMapper implements RowMapper<Admin> {
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				return admin;
			}
		}
	
}
