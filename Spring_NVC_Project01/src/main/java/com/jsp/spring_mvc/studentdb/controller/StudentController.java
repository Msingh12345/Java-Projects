package com.jsp.spring_mvc.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "add-student" , method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {
		
		return studentService.addStudent(student) ;
	}
	@RequestMapping(value="/DisplayAllStudents", method = RequestMethod.GET)
	public ModelAndView displayAStudent() {
		return studentService.displayAllStudents();
	}

}