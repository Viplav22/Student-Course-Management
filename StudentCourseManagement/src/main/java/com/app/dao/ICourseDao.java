package com.app.dao;

import java.util.List;

import com.app.pojos.Course;

public interface ICourseDao {
	public String cancelCourse(int cid);
	List<Course> getAllCourses();
	Course getCourseById(int cid);
}
