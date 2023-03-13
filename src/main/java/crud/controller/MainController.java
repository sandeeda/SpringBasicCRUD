package crud.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crud.dao.AdminDao;
import crud.dao.ReservationDao;
import crud.model.Admin;
import crud.model.Reservation;

@Controller
public class MainController {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private ReservationDao reservationDao;

	@RequestMapping("/")
	public String home(Model m) {
		return "login";
	}

	// handle login form
	@RequestMapping(value = "/handle-login", method = RequestMethod.POST)
	public RedirectView handleLogin(@ModelAttribute Admin admin, HttpServletRequest request, Model m) {
		List<Admin> admins = adminDao.getAdmins();
		boolean approved = false;
		for (Iterator iterator = admins.iterator(); iterator.hasNext();) {
			Admin admin2 = (Admin) iterator.next();
			System.out.println(admin2.getUsername());
			System.out.println(admin2.getPassword());
			System.out.println(admin.getPassword());
			System.out.println(admin.getPassword());
			if (admin2.getPassword().equals(admin.getPassword()) && admin.getUsername().equals(admin2.getUsername())) {
				System.out.println("HERE");
				approved = true;
			}

		}
		if (approved) {
			// List<Student> students = studentDao.getStudents();
			// m.addAttribute("students", students);
			m.addAttribute("loggedinuser", admin.getUsername());
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/reservation");
			return redirectView;
		} else {
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/loginfailed");
			return redirectView;
		}

	}

	@RequestMapping("/loginfailed")
	public String showLoginFailed(Model m) {
		return "error";
	}

	@RequestMapping("/reservation")
	public String showReservationForm(Model m) {
		return "reservation";
	}

	// handle reservation form
	@RequestMapping(value = "/handle-reservation", method = RequestMethod.POST)
	public RedirectView handleReservation(@ModelAttribute Reservation reservation, HttpServletRequest request,
			Model m) {
		System.out.println(reservation);
		this.reservationDao.createReservation(reservation);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/listofreservations");
		return redirectView;
	}

	@RequestMapping("/listofreservations")
	public String showReservations(Model m) {
		List<Reservation> reservations = reservationDao.getReservation();
		m.addAttribute("reservations", reservations);
		return "indexOfReservations";
	}
	
	// add reservation form
	@RequestMapping("/add-reservation")
	public String addReservation(Model m) {
		return "reservation";
	}

	
}
