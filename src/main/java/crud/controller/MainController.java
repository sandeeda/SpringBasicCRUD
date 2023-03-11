package crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crud.dao.StudentDao;
import crud.model.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDao studentDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Student> students = studentDao.getStudents();
		m.addAttribute("students", students);
		return "index";
	}
	
	//add student form
	@RequestMapping("/add-student")
	public String addStudent(Model m) {
		return "add_student_form";
	}
	
	//handle add student form
	@RequestMapping(value = "/handle-student", method = RequestMethod.POST)
	public RedirectView handleStudent(@ModelAttribute Student student, HttpServletRequest request) {
		System.out.println(student);
		studentDao.createStudent(student);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//Delete Handler
	@RequestMapping("/delete-student/{studentId}")
	public RedirectView deleteStudent(@PathVariable("studentId") int studentId, HttpServletRequest request) {
		this.studentDao.deleteStudent(studentId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update-student/{studentId}")
	public String updateForm(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.studentDao.getStudent(studentId);
		model.addAttribute(student);
		return "update_form";
	}
}
