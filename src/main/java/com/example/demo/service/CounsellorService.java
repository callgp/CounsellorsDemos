package com.example.demo.service;



import com.example.demo.dto.DashboardResponse;
import com.example.demo.entity.Counsellor;

public interface CounsellorService {

	
//List<Counsellor> getServiceConsellors();
	
	public Counsellor login(String email, String pwd);
	public boolean register(Counsellor counsellor);
	public DashboardResponse getDashboardInfo(Integer counsellorId);
	public Counsellor findByEmail(String email, String pwd);
}
