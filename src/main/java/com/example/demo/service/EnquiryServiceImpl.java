package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ViewEnqFilterRequest;
import com.example.demo.entity.Counsellor;
import com.example.demo.entity.Enquiry;

import com.example.demo.repos.CounsellorRepo;
import com.example.demo.repos.EnquireRepo;

import io.micrometer.common.util.StringUtils;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquireRepo enquiryRepo;
	
	@Autowired
	private CounsellorRepo  cousellorRepo;
	/*
	 * @Override public List<Enquiry> getEnquiriess() { // TODO Auto-generated
	 * method stub return null; }
	 */

	

	public EnquiryServiceImpl(EnquireRepo enquiryRepo, CounsellorRepo cousellorRepo) {
		super();
		this.enquiryRepo = enquiryRepo;
		this.cousellorRepo = cousellorRepo;
	}

	
	
	@Override
	public boolean addEnquiry(Enquiry enq, Integer CousellorId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("tests");
		com.example.demo.entity.Counsellor counsellor;
		//try {
			counsellor = cousellorRepo.findById(CousellorId).orElse(null);
			/*
			 * } catch (Exception e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		
		if(counsellor==null) {
			throw new Exception("no soselor found");
		}
		
		enq.setCounsellor(counsellor);
		Enquiry save= enquiryRepo.save(enq);
	//	enquiryRepo.save(enq);
		
		return false;
	}



	@Override
	public List<Enquiry> getAllEnquiries(Integer CousellorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqFilterRequest filerReq, Integer CousellorId) {
		// TODO Auto-generated method stub
		
		Enquiry enq=new Enquiry();
		
		if(StringUtils.isNotEmpty(filerReq.getClassMode())) {
			
			enq.setClassMode(filerReq.getClassMode());
		}
		
if(StringUtils.isNotEmpty(filerReq.getCourseName())) {
			
			enq.setClassMode(filerReq.getCourseName());
		}

if(StringUtils.isNotEmpty(filerReq.getEnqStatus())) {
	
	enq.setClassMode(filerReq.getEnqStatus());
}


Counsellor c = cousellorRepo.findById(CousellorId).orElse(null);
enq.setCounsellor(c);

Example<Enquiry> of = Example.of(enq);
List<Enquiry> enqList = enquiryRepo.findAll(of);
		return enqList;
	}

	@Override
	public Enquiry getEnquiryById(Integer enqId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
