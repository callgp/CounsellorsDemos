package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="counsellor_tbl")
public class Counsellor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private static Integer counsellorId;
	@Column(unique=true)
private static String name;
private static String email;
private static String pwd;
private static String phno;
@CreationTimestamp
private static LocalDateTime created_date;
@UpdateTimestamp
private static LocalDateTime updated_date;
public static Integer getCounsellorId() {
	return counsellorId;
}
public static void setCounsellorId(Integer counsellorId) {
	Counsellor.counsellorId = counsellorId;
}
public static String getName() {
	return name;
}
public static void setName(String name) {
	Counsellor.name = name;
}
public static String getEmail() {
	return email;
}
public static void setEmail(String email) {
	Counsellor.email = email;
}
public static String getPwd() {
	return pwd;
}
public static void setPwd(String pwd) {
	Counsellor.pwd = pwd;
}
public static String getPhno() {
	return phno;
}
public static void setPhno(String phno) {
	Counsellor.phno = phno;
}
public static LocalDateTime getCreated_date() {
	return created_date;
}
public static void setCreated_date(LocalDateTime created_date) {
	Counsellor.created_date = created_date;
}
public static LocalDateTime getUpdated_date() {
	return updated_date;
}
public static void setUpdated_date(LocalDateTime updated_date) {
	Counsellor.updated_date = updated_date;
}




}
