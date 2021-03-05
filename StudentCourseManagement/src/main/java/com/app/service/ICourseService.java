package com.app.service;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseService {
	List<Course> getAllCourses();

	Course getCourseById(int cid);

	String cancelCourse(int cid);
}
