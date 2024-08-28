package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ViewEnqFilterRequest;
import com.example.demo.entity.Enquiry;
import com.example.demo.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	
	private EnquiryService enqService;

	public EnquiryController(EnquiryService enqService) {
		super();
		this.enqService = enqService;
	}
	
	
	public String filterEnquiries(ViewEnqFilterRequest req,HttpServletRequest req1, Model model) {
		HttpSession session = req1.getSession(false);
		Integer enqList = (Integer) session.getAttribute("counsellorId");
		//enqService.getEnquiriesWithFilter(req, counsellorId);
		//model.addAttribute("enquiries",enqsList );
		return "viewEnqsPage";
		
		
	}
	
	@GetMapping("/view-enquiries")
	public String getEnquiries(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false);
		Integer enqList = (Integer) session.getAttribute("counsellorId");
		model.addAttribute("enquiries",enqList);
		
		ViewEnqFilterRequest filterReq=new ViewEnqFilterRequest();
		
		return "viewEnqsPage";
	}
	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		
		Enquiry enqObj=new Enquiry();
		model.addAttribute("enq",enqObj);
		return "enquiryForm";
		
		
	}
	

	@PostMapping("/addEnquiry")
	public String handleAddEnquiryPage(@ModelAttribute("enq") Enquiry enq, HttpServletRequest req,Model model) throws Exception {
		
	HttpSession session=req.getSession(false);
	
	Integer counsellorId=(Integer)session.getAttribute("counsellorId");
	
	boolean isSaved = enqService.addEnquiry(enq, counsellorId);
	
	if(isSaved) {
		model.addAttribute("smsg","enquiry added");
	}else {
		model.addAttribute("emsg","enquiry failed");
	}
	
	return "enquiryForm";
		
		
	}
	
	
	


}
