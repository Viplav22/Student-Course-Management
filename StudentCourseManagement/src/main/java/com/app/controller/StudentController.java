package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.ICourseService;
import com.app.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;

	public StudentController() {
		System.out.println("in init of  " + getClass().getName() + " " + studentService);
	}

	@GetMapping("/admit")
	public String showStudentAdmissionFrom(@RequestParam int cid, Student s, HttpSession hs, Model modelMap) {
		System.out.println("in showStudentAdmissionFrom " + cid + s);
		try {
			Course c = courseService.getCourseById(cid);
			System.out.println("selected course : " + c);
			hs.setAttribute("selected_course", c);
			return "/student/admit";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			modelMap.addAttribute("message", "Error getting course course details");
			return "redirect:/course/choose";
		}
	}

	@PostMapping("/admit")
	public String processStudentAdmissionFrom(@Valid Student s, BindingResult res, Model modelMap, HttpSession hs) {
		System.out.println("in processStudentAdmissionFrom " + modelMap);
		System.out.println("student details : " + s);
		if (res.hasErrors()) {
			System.out.println("in P.L. validation failure");
			return "/student/admit";
		}
		try {
			Course c = (Course) hs.getAttribute("selected_course");
			System.out.println("in process : "+c);
			modelMap.addAttribute("message", studentService.admitStudent(s, c));
			return "redirect:/course/choose";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			modelMap.addAttribute("message", "Student Admission failed(controller)!!!");
			return "/course/choose";
		}
	}
}
