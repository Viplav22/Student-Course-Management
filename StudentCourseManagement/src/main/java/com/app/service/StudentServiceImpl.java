package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IStudentDao;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private IStudentDao studentDao;

	@Override
	public String admitStudent(Student student, Course c) {
		return studentDao.admitStudent(student, c);
	}

	@Override
	public boolean validateStudent(Student s) {
		return studentDao.validateStudent(s);
	}
}
