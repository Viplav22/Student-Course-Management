package com.app.service;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface IStudentService {
//student admission with course title n basic student details (name , email)
	String admitStudent(Student student, Course c);

	boolean validateStudent(Student s);
}
