package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses_tbl")
public class Course extends BaseEntity {
	@Column(length = 30)
	private String title;
	private double fees;

	// one to many association
	// value of the mappedBy : name of the property as it appears in the owning
	// side.
	@OneToMany(mappedBy = "selectedCourse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Student> students = new ArrayList<>();

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String title, double fees) {
		super();
		this.title = title;
		this.fees = fees;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [title=" + title + ", fees=" + fees + "]";
	}

	public void addStudent(Student s) {
		students.add(s);
		s.setSelectedCourse(this);
	}

	public void removeStudent(Student s) {
		students.remove(s);
		s.setSelectedCourse(null);
	}

}
