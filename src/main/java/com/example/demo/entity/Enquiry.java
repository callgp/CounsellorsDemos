package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "enquiry")
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqId;
	private String stuName;
	private String studentPhno;
	private String courseName;
	private String classMode;
	private String enqStatus;
	@CreationTimestamp
	private static LocalDateTime createdDate;
	@UpdateTimestamp
	private static LocalDateTime updatedDate;
	@ManyToOne
	@JoinColumn(name = "cousellorId")
	private Counsellor counsellor;

	public Integer getEnqId() {
		return enqId;
	}

	public void setEnqId(Integer enqId) {
		this.enqId = enqId;
	}



	public String getStudentPhno() {
		return studentPhno;
	}

	public void setStudentPhno(String studentPhno) {
		this.studentPhno = studentPhno;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnqStatus() {
		return enqStatus;
	}

	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}

	public static LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public static void setCreatedDate(LocalDateTime createdDate) {
		Enquiry.createdDate = createdDate;
	}

	public static LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public static void setUpdatedDate(LocalDateTime updatedDate) {
		Enquiry.updatedDate = updatedDate;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	

}
