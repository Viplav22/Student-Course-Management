package com.app.dao;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface IStudentDao {
//student admission with course title n basic student details (name , email)
	String admitStudent(Student student, Course c);

	boolean validateStudent(Student s);
}
