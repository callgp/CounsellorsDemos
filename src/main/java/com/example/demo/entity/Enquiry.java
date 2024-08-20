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
@Table(name="enquiry")	
	public class Enquiry {
	/*	private static int counsellor_id;
		private static String name;
		private static String email;
		private static String pwd;
		private static String phno;
		private static LocalDateTime created_date;
		private static LocalDateTime updated_date;
		public static int getCounsellor_id() {*/
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private static Integer enqId;
		private static String	studentName;
		private static String studentPhno;
		private static String courseName;
		private static String classMode;
		private static String enqStatus;
		@CreationTimestamp
		private static LocalDateTime createdDate;
		@UpdateTimestamp
		private static LocalDateTime updatedDate;
@ManyToOne
@JoinColumn(name="cousellorId")
		private Counsellor counsellor;
public static Integer getEnqId() {
	return enqId;
}
public static void setEnqId(Integer enqId) {
	Enquiry.enqId = enqId;
}
public static String getStudentName() {
	return studentName;
}
public static void setStudentName(String studentName) {
	Enquiry.studentName = studentName;
}
public static String getStudentPhno() {
	return studentPhno;
}
public static void setStudentPhno(String studentPhno) {
	Enquiry.studentPhno = studentPhno;
}
public static String getCourseName() {
	return courseName;
}
public static void setCourseName(String courseName) {
	Enquiry.courseName = courseName;
}
public static String getClassMode() {
	return classMode;
}
public static void setClassMode(String classMode) {
	Enquiry.classMode = classMode;
}
public static String getEnqStatus() {
	return enqStatus;
}
public static void setEnqStatus(String enqStatus) {
	Enquiry.enqStatus = enqStatus;
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


}
