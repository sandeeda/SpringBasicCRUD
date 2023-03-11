package crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crud.model.Admin;
import crud.model.Student;

@Component
public class AdminDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	//get all admins
	public List<Admin> getAdmins(){
		return this.hibernateTemplate.loadAll(Admin.class);
	}
	
	
}
