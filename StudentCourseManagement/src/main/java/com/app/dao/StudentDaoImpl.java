package com.app.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public String admitStudent(Student student, Course c) {
		System.out.println("in admit student : " + student);
		System.out.println("in admit student : " + c);

		if (validateStudent(student)) {
			System.out.println("in validate student");
			c.addStudent(student);
			mgr.persist(student);
			return "Student admission successful!!!";
		}
		return "DOB must be before 1990 and cgpa > 7";
	}

	@Override
	public boolean validateStudent(Student s) {
		if (s.getCgpa() > 7 && s.getDob().isBefore(LocalDate.parse("1990-01-01")))
			return true;
		return false;
	}

}
