package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor,Integer> {
	
	public Counsellor findByEmailAndPwd(String email, String pwd);

	
}
