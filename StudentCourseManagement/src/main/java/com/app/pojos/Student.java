package com.app.pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {
	@Column(length = 20)
	private String name;
	private String address;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	private double cgpa;

	// many to one bi dir association between 2 entities (Student n Course)
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false) // FK col name
	private Course selectedCourse;

	public Student() {
		System.out.println("in student ctor");
	}

	public Student(String name, String address, LocalDate dob, double cgpa) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

}
