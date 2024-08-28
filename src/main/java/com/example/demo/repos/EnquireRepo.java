package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Enquiry;

public interface EnquireRepo extends JpaRepository<Enquiry,Integer> {
   //@Query...retieve from db select find by
	@Query(value = "select * from enquiry where cousellor_id=:counsellorId", nativeQuery = true)
	//public List<Enquiry> getEnquriesByCounsellorId(Integer counsellorId);
	java.util.List<Enquiry> getEnquiriesByCounsellorId(Integer counsellorId);
	

}
