package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ViewEnqFilterRequest;
import com.example.demo.entity.Enquiry;

public interface EnquiryService {
	public boolean addEnquiry(Enquiry enq,Integer CousellorId) throws Exception;
	public List<Enquiry> getAllEnquiries(Integer CousellorId);
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filerReq,Integer CousellorId);
	
	public Enquiry getEnquiryById(Integer enqId);
	
}
