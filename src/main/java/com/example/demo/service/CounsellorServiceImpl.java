package com.example.demo.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DashboardResponse;
import com.example.demo.entity.Counsellor;
import com.example.demo.entity.Enquiry;
import com.example.demo.repos.CounsellorRepo;
import com.example.demo.repos.EnquireRepo;

@Service
public class CounsellorServiceImpl implements CounsellorService{

	@Autowired
	private CounsellorRepo counsellorRepo;
	
	@Autowired
	private EnquireRepo enqRepo;
	
	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor= counsellorRepo.findByEmailAndPwd(email, pwd);
		return counsellor;
	}

	@Override
	public boolean register(Counsellor counsellor) {
		// TODO Auto-generated method stub
		Counsellor savedConsellor=counsellorRepo.save(counsellor);
		if(null != savedConsellor.getCounsellorId()) {
			return true;
		}
		return false;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		// TODO Auto-generated method stub
		DashboardResponse response=new DashboardResponse();
		List<Enquiry> enqList=enqRepo.getEnquiriesByCounsellorId(counsellorId);
		
		
		int totalEnq=enqList.size();
		
		int enrolledEnqs=enqList.stream()
				.filter(e->e.getEnqStatus().equals("Enrolled"))
				.collect(Collectors.toList())
				.size();
		
		int openEnqs=enqList.stream()
				.filter(e->e.getEnqStatus().equals("Open"))
				.collect(Collectors.toList())
				.size();
		
		int lostEnqs=enqList.stream()
				.filter(e->e.getEnqStatus().equals("Lost"))
				.collect(Collectors.toList())
				.size();
		
		int totalEnqs=enqList.stream()
				.filter(e->e.getEnqStatus().equals("Total"))
				.collect(Collectors.toList())
				.size();
		
		response.setEnrolledEnqs(enrolledEnqs);
		response.setLostEnqs(lostEnqs);
		response.setOpenEnqs(openEnqs);
		response.setTotalEnqs(totalEnqs);
		return response;
		
		
	}

	@Override
	public Counsellor findByEmail(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Counsellor> getServiceConsellors() { // TODO
	 * Auto-generated method stub return null; }
	 */
}
