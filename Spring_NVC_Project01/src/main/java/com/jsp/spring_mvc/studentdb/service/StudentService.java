package com.jsp.spring_mvc.studentdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public ModelAndView addStudent(Student student) {
		studentRepository.addStudent(student);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		
		return mav;
		
	}
	
	public ModelAndView displayAllStudents() {
		List<Student> students=studentRepository.displayStudent();
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("DisplayStudent.jsp");
		mav.addObject("studentList",students);
		
		return mav;
	}

}