package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.dao.ICourseDao;
import com.app.pojos.Course;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private ICourseDao courseDao;

	@Override
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	@Override
	public Course getCourseById(int cid) {
		return courseDao.getCourseById(cid);
	}

	@Override
	public String cancelCourse(int cid) {
		return courseDao.cancelCourse(cid);
	}

}
