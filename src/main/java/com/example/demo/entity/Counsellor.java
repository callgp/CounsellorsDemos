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
private  Integer counsellorId;
	@Column(unique=true)
private  String name;
private  String email;
private  String pwd;
private  String phno;
@CreationTimestamp
private  LocalDateTime created_date;
@UpdateTimestamp
private  LocalDateTime updated_date;
public Integer getCounsellorId() {
	return counsellorId;
}
public void setCounsellorId(Integer counsellorId) {
	this.counsellorId = counsellorId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}
public LocalDateTime getCreated_date() {
	return created_date;
}
public void setCreated_date(LocalDateTime created_date) {
	this.created_date = created_date;
}
public LocalDateTime getUpdated_date() {
	return updated_date;
}
public void setUpdated_date(LocalDateTime updated_date) {
	this.updated_date = updated_date;
}



}
