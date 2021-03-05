package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Course;

@Repository
public class CourseDaoImpl implements ICourseDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public String cancelCourse(int cid) {
		Course c = mgr.find(Course.class, cid);
		System.out.println();
		mgr.remove(c);
		return "Course deleted successfull!!!";
	}

	@Override
	public List<Course> getAllCourses() {
		String jpql = "select c from Course c";
		return mgr.createQuery(jpql, Course.class).getResultList();
	}

	@Override
	public Course getCourseById(int cid) {
		return mgr.find(Course.class, cid);
	}
}
