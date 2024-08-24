package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Enquiry;

public interface EnquireRepo extends JpaRepository<Enquiry,Integer> {
   //@Query...
	java.util.List<Enquiry> getEnquiriesByCounsellorId(Integer counsellorId);
	

}
