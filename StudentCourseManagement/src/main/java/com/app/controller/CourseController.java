package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Course;
import com.app.service.ICourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;

	public CourseController() {
		System.out.println("in init of  " + getClass().getName() + " " + courseService);
	}

	@GetMapping("/choose")
	public String showchooseCourseForm(Model modelMap) {
		System.out.println("in showchooseCourseForm");
		modelMap.addAttribute("all_courses", courseService.getAllCourses());
		return "/course/choose";
	}

	@GetMapping("/delete")
	public String deleteCourse(@RequestParam int cid, Model modelMap) {
		System.out.println("in deleteCourse ");
		try {
			String msg = courseService.cancelCourse(cid);
			modelMap.addAttribute("message", msg);
			return "redirect:/course/choose";
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
			modelMap.addAttribute("message", "Cannot delete course");
			return "/course/choose";
		}
	}
}
