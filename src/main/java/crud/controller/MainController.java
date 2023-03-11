package crud.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crud.dao.AdminDao;
import crud.dao.StudentDao;
import crud.model.Admin;
import crud.model.Student;

@Controller
public class MainController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private AdminDao adminDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Student> students = studentDao.getStudents();
		m.addAttribute("students", students);
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
			//List<Student> students = studentDao.getStudents();
			//m.addAttribute("students", students);
			m.addAttribute("loggedinuser", admin.getUsername());
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/list");
			return redirectView;
		} else {
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath() + "/loginfailed");
			return redirectView;		}

	}

	@RequestMapping("/loginfailed")
	public String showLoginFailed(Model m) {
		return "error";
	}
	
	@RequestMapping("/list")
	public String showStudents(Model m) {
		List<Student> students = studentDao.getStudents();
		m.addAttribute("students", students);
		return "index";
	}

	// add student form
	@RequestMapping("/add-student")
	public String addStudent(Model m) {
		return "add_student_form";
	}

	// handle add student form
	@RequestMapping(value = "/handle-student", method = RequestMethod.POST)
	public RedirectView handleStudent(@ModelAttribute Student student, HttpServletRequest request, Model m) {
		System.out.println(student);
		studentDao.createStudent(student);
		request.setAttribute("loggedinuser", m.getAttribute("loggedinuser"));
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list");
		return redirectView;
	}

	// Delete Handler
	@RequestMapping("/delete-student/{studentId}")
	public RedirectView deleteStudent(@PathVariable("studentId") int studentId, HttpServletRequest request, Model m) {
		this.studentDao.deleteStudent(studentId);
		request.setAttribute("loggedinuser", m.getAttribute("loggedinuser"));
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/list");
		return redirectView;
	}

	@RequestMapping("/update-student/{studentId}")
	public String updateForm(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.studentDao.getStudent(studentId);
		model.addAttribute(student);
		return "update_form";
	}
}
