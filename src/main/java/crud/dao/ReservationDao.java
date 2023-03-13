package crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import crud.model.Reservation;

@Component
public class ReservationDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create reservation
	@Transactional
	public void createReservation(Reservation reservation) {
		this.hibernateTemplate.saveOrUpdate(reservation);
	}
	
	//get all reservations
	public List<Reservation> getReservation(){
		return this.hibernateTemplate.loadAll(Reservation.class);
	}
}
