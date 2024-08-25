package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Student;
import com.test.service.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl studentService;

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("student", new Student());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Student student, Model m) {
		String email = student.getEmail();
		String password = student.getPassword();

		if (email.isEmpty()) {
			m.addAttribute("error", "email is required");
			return "login";
		}
		if (password.isEmpty()) {
			m.addAttribute("email", email);
			m.addAttribute("error", "password is required");

			return "login";
		}
		Student st = studentService.findStudentByEmailAndPassword(email, password);
		if (st == null) {
			m.addAttribute("error", "Invalid username and password");
			return "login";
		}
		m.addAttribute("studentList", studentService.studentList());
		return "home";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model m) {
		m.addAttribute("student", new Student());
		return "addStudent";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student student, Model m) {
		try {
			String name = student.getName();
			String dob = student.getDob();
			String address = student.getAddress();
			String email = student.getEmail();
			String password = student.getPassword();
			
			if(name.isEmpty()) {
				m.addAttribute("error", "Name is required");
				return "addStudent";
			}
			if(dob.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("error", "DOB is required");
				return "addStudent";
			}
			if(address.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("error", "Address is required");
				return "addStudent";
			}
			if(email.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("address", address);
				m.addAttribute("error", "Email is required");
				return "addStudent";
			}
			if(password.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("address", address);
				m.addAttribute("email", email);
				m.addAttribute("error", "password is required");
				return "addStudent";
			}
			Student addStudent = studentService.addStudent(student);
			if(addStudent == null) {
				m.addAttribute("error", "something went wrong");
				return "addStudent";
			}
			m.addAttribute("studentList", studentService.studentList());
			return "home";
		} catch (Exception e) {
			// TODO: handle exception
			m.addAttribute("error", e);
			return "addStudent";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id , Model m ) {
		Student student = studentService.findStudentById(id);
		m.addAttribute("student", student);
		
		return "editStudent";
	}
	
	@PostMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id ,@ModelAttribute Student student ,Model m )  {
		try {
			String name = student.getName();
			String dob = student.getDob();
			String address = student.getAddress();
			String email = student.getEmail();
			String password = student.getPassword();
			
			if(name.isEmpty()) {
				m.addAttribute("error", "Name is required");
				return "addStudent";
			}
			if(dob.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("error", "DOB is required");
				return "addStudent";
			}
			if(address.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("error", "Address is required");
				return "addStudent";
			}
			if(email.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("address", address);
				m.addAttribute("error", "Email is required");
				return "addStudent";
			}
			if(password.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("dob", dob);
				m.addAttribute("address", address);
				m.addAttribute("email", email);
				m.addAttribute("error", "password is required");
				return "addStudent";
			}
			Student updateStudent = studentService.updateStudent(student, id);
			if(updateStudent == null) {
				m.addAttribute("error", "something went wrong");
				return "addStudent";
			}
			m.addAttribute("studentList", studentService.studentList());
			return "home";
		} catch (Exception e) {
			// TODO: handle exception
			m.addAttribute("error", e);
			return "addStudent";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id, Model m)
	{
		Student deleteStudent = studentService.deleteStudent(id);
		if(deleteStudent == null) {
			m.addAttribute("error", "something went wrong");
			return "home";
		}
		m.addAttribute("studentList", studentService.studentList());
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(Model m) {
		m.addAttribute("student", new Student());
		return "login";
	}
}
